package server;

import java.net.*;

/*
ʵ������ͨ�ţ����Է������κ�Ӧ�ã�û���ṩЭ�飬
Ҳ����˵NwServer�����������κ�Э�顣
 */
public class NwServer {

    private int port = 4321;

    public NwServer(IOStrategy io) throws Exception {
        //��ֻ������ܿͻ��˵��������󣬽������罨����socket���ӣ�
        //Ȼ�������ύ��Э�鴦�����

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is ready");

        while (true) {
            Socket socket = server.accept();

            InetAddress ia = socket.getInetAddress();
            System.out.println(ia.getHostName() + "(" + ia.getHostAddress() + ") connected.");

            io.service(socket);
        }
    }
}
