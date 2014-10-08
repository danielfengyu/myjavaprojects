package com.fy.dlut;
import java.util.Date;  
import org.apache.mina.core.service.IoHandlerAdapter;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
public class TimeServerHandler extends IoHandlerAdapter {  
	    @Override  
	    public void exceptionCaught(IoSession session, Throwable cause)  
	            throws Exception {  
	        cause.printStackTrace();  
	    }  
	    @SuppressWarnings("deprecation")  
	    @Override  
	    public void messageReceived(IoSession session, Object message)  
	            throws Exception {  
	        String str = message.toString();  
	        System.out.println("Message received:"+str);  
	        if(str.trim().equalsIgnoreCase("quit")){  
	            session.close();  
	            return;  
	        }  
	          
	        Date date = new Date();  
	        session.write(date.toString());  
	        System.out.println("Message written.");  
	    }  
	    @Override  
	    public void messageSent(IoSession session, Object message) throws Exception {  
	        super.messageSent(session, message);  
	    }  
	    @Override  
	    public void sessionClosed(IoSession session) throws Exception {  
	        super.sessionClosed(session);  
	    }  
	    @Override  
	    public void sessionCreated(IoSession session) throws Exception {  
	        super.sessionCreated(session);  
	    }  
	    @Override  
	    public void sessionIdle(IoSession session, IdleStatus status)  
	            throws Exception {  
	        System.out.println("IDLE"+session.getIdleCount(status));  
	    }  
	    @Override  
	    public void sessionOpened(IoSession session) throws Exception {  
	        // TODO Auto-generated method stub  
	        super.sessionOpened(session);  
	    }  
	      
	}  
	 

