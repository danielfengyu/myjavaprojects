package server;

import java.net.*;
import java.io.*;

/*
ʵ��Э�鲿��

����ĳ��������е���ˣ�*_^
 */
public class MultiThreadSupport implements IOStrategy, Runnable {

    private Socket socket = null;
    private IOStrategy ios = null;

    public MultiThreadSupport(IOStrategy ios) {
        this.ios = ios;
    }

    public void service(Socket socket) {
        this.socket = socket;
        new Thread(this).start();
    }

    public void run() {
        ios.service(socket);
    }
}
