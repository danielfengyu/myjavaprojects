import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer {

	Map<String, Socket> users = new HashMap<String, Socket>();
	BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	public static void main(String[] args) throws Exception {
		new ChatServer().start();
	}

	public void start() throws Exception {
		users = Collections.synchronizedMap(users);
		new Thread() {
			public void run() {
				while (true) {
					try {
						String message = queue.take();
						Set<String> set = users.keySet();
						for(Iterator<String> it=set.iterator(); it.hasNext(); ) {
							String u=it.next();
							Socket s = users.get(u);
							DataOutputStream dos = new DataOutputStream(s.getOutputStream());
							dos.writeUTF(message);
							dos.flush();
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		ServerSocket ss = new ServerSocket(1234);
		while (true) {
			Socket s = ss.accept();
			new MyThread(s).start();

		}
	}

	class MyThread extends Thread {
		private Socket s;
		private String username;

		public MyThread(Socket s) {
			this.s = s;
		}

		public void run() {
			try {
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				int command = 0;
				while (true) {
					command = dis.readInt();
					switch (command) {
					case 1:
						String message = dis.readUTF();
						message = username + ": " + message;
						queue.put(message);
						break;
					case 2:
						username = dis.readUTF();
						users.put(username, s);
						break;
					}
				}
			} catch (Exception e) {
				users.remove(username);
				e.printStackTrace();
			}
		}
	}

}
