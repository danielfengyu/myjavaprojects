package impl;

import base.*;
import java.util.*;
import java.io.*;

public class TextDataLoader implements DataLoader {
	public ArrayList<Student> load() {
		ArrayList<Student> r = new ArrayList<Student>();

		try {
			/*
			 * �����ķ�ʽ����ȡ���ݣ���ʹ���ֽ�������ȡ�ļ��� ���ݵ�Ȼ��һ���ֽ�һ���ֽڵķ�ʽ��ȡ�ģ�Ȼ��ʹ��
			 * �ֽ������ַ�����ת���������������ַ���ʽ��ȡ�ļ����ݣ� ���ʹ��BufferedReader�������ַ����ݣ�������س����У�
			 * �����ı����ݵ���ʽ��������
			 */
			FileInputStream fis = new FileInputStream("student.txt");
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			BufferedReader br = new BufferedReader(isr);
			String s = "";
			while ((s = br.readLine()) != null) { // ��ȡ����ֱ��ȫ������
				s = s.trim();
				if (s.length() == 0)
					continue; // ���������������������һ��
				/*
				 * ʹ��StringTokenizer���ָ��ַ����� Ҳ����ʹ��String���split�������ָ����Ƕ���
				 */
				StringTokenizer st = new StringTokenizer(s, ",");
				/* ���������Ķ�ȡ���� */
				String id = st.nextToken().trim();
				String name = st.nextToken().trim();
				String email = st.nextToken().trim();
				int age = Integer.parseInt(st.nextToken().trim());
				int java = Integer.parseInt(st.nextToken().trim());
				boolean gender = st.nextToken().trim().equals("��");
				// �����ݼ�¼ת������ΪStudent����
				Student stu = new Student(id, name, email, java, age, gender);
				r.add(stu);
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	public static void main(String[] args) {
		//���Գ���
		DataLoader loader = new TextDataLoader();
		ArrayList<Student> st = loader.load();
		for(Iterator<Student> it = st.iterator(); it.hasNext(); ) {
			Student s = it.next();
			System.out.println(s);
		}
	}
}
