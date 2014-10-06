package impl;

import java.util.ArrayList;
import java.io.*;
import java.net.*;
import base.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NetDataLoader implements DataLoader {
	public ArrayList<Student> load() {
		ArrayList<Student> r = new ArrayList<Student>();
		try {
			Socket s = new Socket("localhost", 1234);
			InputStreamReader isr = new InputStreamReader(s.getInputStream(),
					"GBK");
			OutputStreamWriter osw = new OutputStreamWriter(
					s.getOutputStream(), "GBK");
			PrintWriter out = new PrintWriter(osw);
			out.println("get"); // ���������������
			out.flush();

			StringBuffer sb1 = new StringBuffer();
			char[] buff1 = new char[4096];
			int len = 0;
			// �ӷ��������ַ������ݣ�ֱ������Ϊֹ
			while ((len = isr.read(buff1)) != -1) {
				sb1.append(buff1, 0, len);
			}
			// �ٴ��ַ���������Java List����
			JSONArray j1 = JSONArray.fromObject(sb1.toString());
			r = (ArrayList<Student>) JSONArray.toCollection(j1, Student.class);
			isr.close();
			out.close();
			osw.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * ����ĳ�����JSON��̵Ĳ��Գ����൱�����л��ͷ����л��� ��Java����ת��ΪJSON�ַ������ٴӸ��ַ���ת����Java����
	 * ����Ĵ�����ʾ��JavaBean��Java�����ת�����̡�
	 */
	public static void main(String[] args) throws Exception {
		Student s1 = new Student("008", "zxx", "zxx@163.com", 99, 20, true);
		Student s2 = new Student("007", "james", "james@163.com", 100, 70, true);
		Student[] sa = new Student[] { s1, s2 };

		JSONObject o = JSONObject.fromObject(s1);
		System.out.println(o.toString());

		JSONObject o2 = JSONObject.fromObject(o.toString());
		Student s3 = (Student) JSONObject.toBean(o2, Student.class);
		System.out.println(s3);

		JSONArray a = JSONArray.fromObject(sa);
		System.out.println(a.toString());

		JSONArray a2 = JSONArray.fromObject(a.toString());
		Student[] sa2 = (Student[]) JSONArray.toArray(a2, Student.class);
		System.out.println(sa2.length);
	}
}
