package server;

import java.net.*;

/*
�ṩЭ����Զ���
 */
public interface IOStrategy {

    public void service(Socket socket);
}
