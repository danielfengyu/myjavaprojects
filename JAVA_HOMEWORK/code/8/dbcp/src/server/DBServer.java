package server;

public class DBServer {
	public static void main(String[] args) throws Exception {
		// NwServer.java��ThreadSupport.java����6�µ����ӣ�ֱ�Ӹ��ù����Ϳ���
		new NwServer(new MultiThreadSupport(new CrudProtocol()));
	}
}
