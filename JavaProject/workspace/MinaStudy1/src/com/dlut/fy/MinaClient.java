package com.dlut.fy;

import java.net.InetSocketAddress;  
import org.apache.mina.core.RuntimeIoException;  
import org.apache.mina.core.future.ConnectFuture;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.example.sumup.codec.SumUpProtocolCodecFactory;  
import org.apache.mina.filter.codec.ProtocolCodecFilter;  
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;  
import org.apache.mina.filter.logging.LoggingFilter;  
import org.apache.mina.transport.socket.nio.NioSocketConnector;  
public class MinaClient {  
    private final static long DEF_TIMEOUT = 60*1000L; //1 minute      
    // Set this to false to use object serialization instead of custom codec.  
    private static final boolean USE_CUSTOM_CODEC = true;  
    // Server and port  
    private static final int PORT = 8100;  
    private static final String SERVER = "127.0.0.1";  
    private static IoSession session;  
      
    /** 
     * @param args 
     * @throws InterruptedException  
     */  
    public static void main(String[] args) throws InterruptedException {  
        if (args.length == 0) {  
           System.out.println("Please specify the list of any integers");  
           return;  
        }  
          
        //prepare values to sum up  
        int len = args.length;  
        int[] values = new int[len];  
        for(int i = 0; i < len; i ++){  
            values[i] = Integer.parseInt(args[i]);   
        }  
          
        // Create TCP/IP connector.  
        NioSocketConnector connector = new NioSocketConnector();  
          
        //Set connect timeout  
        connector.setConnectTimeoutMillis(DEF_TIMEOUT);  
          
        // Add 'codec' filter  
        if(USE_CUSTOM_CODEC){  
            connector.getFilterChain().addLast("codec",  
                    new ProtocolCodecFilter(  
                            new SumUpProtocolCodecFactory(false)));  
        } else {  
            connector.getFilterChain().addLast("codec",  
                    new ProtocolCodecFilter(  
                            new ObjectSerializationCodecFactory()));  
        }  
          
        connector.getFilterChain().addLast("logger", new LoggingFilter());  
        //Start communication  
        connector.setHandler(new NetCatProtocolHandler(values));  
          
        //If it fails to connect to the server,  
        //retry it after 10 seconds!  
        while(true){  
            try{  
                ConnectFuture future = connector.connect(new InetSocketAddress(SERVER,PORT));  
                future.awaitUninterruptibly();  
                session = future.getSession();  
                break;  
            } catch (RuntimeIoException e) {  
                System.err.println("Fail to connect!");  
                e.printStackTrace();  
                Thread.sleep(10*1000L);  
            }  
        }  
          
        //Wait for the connection attempt to be finished.  
        session.getCloseFuture().awaitUninterruptibly();  
          
        connector.dispose();  
    }  
}  