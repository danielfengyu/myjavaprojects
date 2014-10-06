package server;

import java.net.*;
import java.io.*;
import java.util.*;
import bean.Student;

public class CrudProtocol implements IOStrategy { // IOStrategy.java����6�µ�����
	CrudService servant = new CrudService(); // ���̹߳��������󣬹���һ�����ӳ�

	public void service(Socket socket) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream()); // ���������������������
			oos.writeObject("echo"); // �����һ���ַ����������֡�
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			while (true) {
				int command = ois.readInt();
				switch (command) {
				case 1: // findFailed
					List<Student> list = servant.findFailed();
					oos.writeObject(list);
					oos.flush();
					break;
				case 2: // findExcellent
					List<Student> list2 = servant.findExcellent();
					oos.writeObject(list2);
					oos.flush();
					break;
				case 3: // delete
					String id = ois.readUTF();
					servant.delete(id);
					break;
				case 4: // insertOrUpdate
					Student s = (Student) ois.readObject();
					servant.insertOrUpdate(s);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("protocol finished.");
		}
	}
}
