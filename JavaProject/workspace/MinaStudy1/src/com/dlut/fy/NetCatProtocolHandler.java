package com.dlut.fy;
import org.apache.mina.core.service.IoHandlerAdapter;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.example.sumup.ClientSessionHandler;  
import org.apache.mina.example.sumup.message.AddMessage;  
import org.apache.mina.example.sumup.message.ResultMessage;  
import org.slf4j.LoggerFactory;  
public class NetCatProtocolHandler extends IoHandlerAdapter {  
      
    private int[] values;     
    private boolean finished;  
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ClientSessionHandler.class);  
      
    // provide a method for other class to judge whether it's finished.  
    public boolean isFinished() {  
        return finished;  
    }  
    public NetCatProtocolHandler(int[] values) {  
        this.values = values;  
    }  
    @Override  
    public void exceptionCaught(IoSession session, Throwable cause)  
            throws Exception {  
        session.close(true);  
    }  
    @Override  
    public void messageReceived(IoSession session, Object message)  
            throws Exception {  
//      IoBuffer buffer = (IoBuffer) message;         
//      while(buffer.hasRemaining()){  
//          System.out.println(buffer.getChar());  
//      }         
//      System.out.flush();  
          
          
        // server only sends ResultMessage. otherwise, we will have to identify  
        // its type using instanceof operator.  
        ResultMessage rm = (ResultMessage)message;  
        if(rm.isOk()){  // server returned OK code.           
            // if received the result message which has the last sequence  
            // number, it is time to disconnect.  
            if(rm.getSequence() == values.length - 1){  
                //Print the sum and disconnect.  
                LOGGER.warn("Server error, disconnecting...");  
                session.close(true);  
                  
                finished = true;  
            }  
        }  
    }  
    @Override  
    public void messageSent(IoSession session, Object message) throws Exception {  
        session.write(message);  
        System.out.println("Message sent:"+message);  
    }  
    @Override  
    public void sessionClosed(IoSession session) throws Exception {  
        System.err.println("Total "+ session.getReadBytes()+" byte(s)");  
    }  
    @Override  
    public void sessionIdle(IoSession session, IdleStatus status)  
            throws Exception {  
        if(status == IdleStatus.READER_IDLE) {  
            session.close(true);  
        }  
    }  
    @Override  
    public void sessionOpened(IoSession session) throws Exception {  
        // Set reader idle time to 60 seconds.  
        // sessionIdle(...) method will be invoked when no data is read  
        // for 60 seconds.  
        //session.getConfig().setIdleTime(IdleStatus.READER_IDLE, 60);  
          
        // send summation requests  
        for(int i = 0; i < values.length; i ++){  
            AddMessage message = new AddMessage();  
            message.setSequence(i);  
            message.setValue(values[i]);  
              
            session.write(message);  
        }  
    }  
      
}  