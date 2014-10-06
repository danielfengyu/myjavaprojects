package serv;

import java.net.*;
import java.io.*;
import java.util.*;
import base.*;
import net.sf.json.*;

public class DataServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("data server is ready.");
			while (true) {
				Socket s = ss.accept();
				new ServThread(s).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// ServThread��Ҳ������DataServer.java�ļ��У���û�е�������һ��Դ�ļ��С�
class ServThread extends Thread {
	private Socket s;

	public ServThread(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(s.getInputStream(),
					"GBK");
			BufferedReader br = new BufferedReader(isr);
			OutputStreamWriter osw = new OutputStreamWriter(
					s.getOutputStream(), "GBK");
			/*
			 * �������е����ݼ��������ڷ������ϵ�Excel�ļ���Ȼ��ͨ������ ������ͻ���
			 */
			DataLoaderFactory factory = new DataLoaderFactory();
			DataLoader loader = factory.getDataLoader("impl.ExcelDataLoader");
			ArrayList<Student> r = loader.load();

			String command = br.readLine();
			if (command.equals("get")) { // JSON��̷ǳ���
				JSONArray j1 = JSONArray.fromObject(r);
				// �����ݼ�����JSON�ַ�������ʽ������ͻ���
				osw.write(j1.toString());
				osw.flush();
			}
			osw.close();
			isr.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
