package com.dlut.fy;
import org.apache.mina.core.service.IoHandlerAdapter;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.example.sumup.ServerSessionHandler;  
import org.apache.mina.example.sumup.message.AddMessage;  
import org.apache.mina.example.sumup.message.ResultMessage;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
public class MinaServerHandler extends IoHandlerAdapter {  
    private static final String SUM_KEY = "sum";  
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerSessionHandler.class);  
      
    @Override  
    public void exceptionCaught(IoSession session, Throwable cause)  
            throws Exception {  
        session.close(true);  
        cause.printStackTrace();  
    }  
    @Override  
    public void messageReceived(IoSession session, Object message)  
            throws Exception {  
        // client only sends AddMessage. otherwise, we will have to identify  
        // its type using instanceof operator.  
        AddMessage am = (AddMessage) message;  
          
        //Add the value to the current sum.  
        int sum = ((Integer) session.getAttribute(SUM_KEY)).intValue();  
        int value = am.getValue();  
        long expectedSum = (long) sum+value;  
          
        if(expectedSum > Integer.MAX_VALUE || expectedSum < Integer.MIN_VALUE){  
            //If the sum overflows or underflows , return error message.  
            ResultMessage rMessage = new ResultMessage();  
            rMessage.setSequence(am.getSequence()); // copy sequence  
            rMessage.setOk(false);  
            session.write(rMessage);  
        } else {  
            //sum up  
            sum = (int) expectedSum;  
            session.setAttribute(SUM_KEY,new Integer(sum));  
              
            //return the result message.  
            ResultMessage rmMessage = new ResultMessage();  
            rmMessage.setSequence(am.getSequence()); //copy sequece  
              
            rmMessage.setOk(true);  
            rmMessage.setValue(sum);  
            session.write(rmMessage);  
        }  
    }  
    @Override  
    public void messageSent(IoSession session, Object message) throws Exception {  
        System.out.println("Message sent:"+message);  
    }  
    @Override  
    public void sessionIdle(IoSession session, IdleStatus status)  
            throws Exception {  
        LOGGER.info("Disconnecting the idle...");  
        //disconnect an idle client  
        session.close(true);  
    }  
    @Override  
    public void sessionOpened(IoSession session) throws Exception {  
        //Set idle time to 60 seconds  
        session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 60);  
          
        //Initial sum is 0  
        session.setAttribute(SUM_KEY,new Integer(0));  
    }  
}  
 