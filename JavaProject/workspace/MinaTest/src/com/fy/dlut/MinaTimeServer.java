package com.fy.dlut;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaTimeServer {
	public static void main(String[] args) throws IOException {  
        IoAcceptor acceptor = new NioSocketAcceptor();  
          
        //This filter will log all information such as newly created   
            //sessions, messages received, messages sent, session closed  
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());  
        //This filter will translate binary or protocol specific data into   
            //message object and vice versa. We use an existing TextLine   
            //factory because it will handle text base message for you (  
            //you don't have to write the codec part)  
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(  
                new TextLineCodecFactory(Charset.forName("UTF-8"))));  
          
        acceptor.setHandler(new TimeServerHandler());  
          
        acceptor.getSessionConfig().setReadBufferSize(BUF_SIZE);  
        //the first parameter defines what actions to check for when   
            //determining if a session is idle, the second parameter defines   
            //the length of time in seconds that must occur before a session   
            //is deemed to be idle.  
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);  
          
        acceptor.bind(new InetSocketAddress(PORT));  
    }  
    private static final int PORT = 8181,BUF_SIZE = 2048;  
}