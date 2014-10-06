import java.net.*;
import java.io.*;
public class Chat {

	public static void main(String[] args) throws Exception {
		//java Chat otherComputer
		//需要两台计算机进行通信
		//注意关闭掉防火墙
		//由于输入输出信息都在控制台，所以显示的内容比较乱，如果使用GUI就会好。
		new Thread() {
			public void run() {
				try {
					DatagramSocket ds = new DatagramSocket(1234);
					ds.setBroadcast(false);
					while(true) {
						byte[] buffer = new byte[32768];
						DatagramPacket dp = new DatagramPacket(buffer,buffer.length);	
						ds.receive(dp);
						String message = new String(dp.getData(),0,dp.getLength());
						System.out.println();
						System.out.println("He say: " + message);
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		
		}.start();
		
		new Chat().start(args[0]);

		
	}
	
	public void start(String remotehost) throws Exception {
		DatagramSocket ds = new DatagramSocket();
		ds.setBroadcast(false);
		byte[] buffer = new byte[32768];
		InetSocketAddress isa = new InetSocketAddress(remotehost, 1234);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		while(true) {
			System.out.print("I say: ");
			s = br.readLine();
			if(s!=null && !s.equals("quit")) {
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				dp.setSocketAddress(isa);
				dp.setData(s.getBytes());
				ds.send(dp);
			}
			else {
				System.exit(0);
			}
			
		}
			
	}

}
