package com.dlut.fy;
import java.io.IOException;  
import java.net.InetSocketAddress;  
import org.apache.mina.example.sumup.codec.SumUpProtocolCodecFactory;  
import org.apache.mina.filter.codec.ProtocolCodecFilter;  
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;  
import org.apache.mina.filter.logging.LoggingFilter;  
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;  
public class MinaServer {  
    private static final int PORT = 8100,BUF_SIZE = 2048;  
    // Set this to false to use object serialization instead of custom codec.  
    private static final boolean USE_CUSTOM_CODEC = true;  
    public static void main(String[] args) throws IOException {  
        NioSocketAcceptor acceptor = new NioSocketAcceptor();  
          
        // Add 'codec' filter  
        if(USE_CUSTOM_CODEC){  
            acceptor.getFilterChain().addLast("codec",  
                    new ProtocolCodecFilter(  
                            new SumUpProtocolCodecFactory(false)));  
        } else {  
            acceptor.getFilterChain().addLast("codec",  
                    new ProtocolCodecFilter(  
                            new ObjectSerializationCodecFactory()));  
        }  
          
        //This filter will log all information such as newly created   
            //sessions, messages received, messages sent, session closed  
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());  
          
        acceptor.setHandler(new MinaServerHandler());  
          
        acceptor.getSessionConfig().setReadBufferSize(BUF_SIZE);  
        //the first parameter defines what actions to check for when   
            //determining if a session is idle, the second parameter defines   
            //the length of time in seconds that must occur before a session   
            //is deemed to be idle.  
        //acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 60);  
          
        acceptor.bind(new InetSocketAddress(PORT));  
        System.out.println("Listening on port:"+PORT);  
          
    }  
}  