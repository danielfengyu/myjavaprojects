//�����ǿͻ��˵ĳ���
import bean.Student;
import java.util.*;
import java.net.*;
import java.io.*;

public class DBClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 4321);
			Thread.sleep(100); // �ȴ������������������󣬴��������
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			String echo = (String) ois.readObject();
			System.out.println(echo); // ��������֡���Ϣ
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeInt(4); // ����һ��ѧ������Ϣ
			oos.writeObject(new Student("003", "fs", "fs@abc.com", 21, 58, true));
			oos.flush();
			Thread.sleep(100); // �ͻ������ݿ��������֮��һ�㶼����ʱ������
			oos.writeInt(4); // ������һ��ѧ������Ϣ
			oos.writeObject(new Student("004", "ws", "ws@abc.com", 21, 48, true));
			oos.flush();
			Thread.sleep(100);
			oos.writeInt(1); // ��ѯ�������ѧ��������
			oos.flush();
			List<Student> list = (List<Student>) ois.readObject();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getName());
			}
			s.close(); // ֱ�ӹر�Socket����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
