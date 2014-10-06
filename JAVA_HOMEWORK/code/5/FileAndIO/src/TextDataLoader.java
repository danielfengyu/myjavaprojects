import java.util.*;
import java.io.*;

public class TextDataLoader { // TextDataLoader.java
	public ArrayList<Student> load() { // ���ı��ļ��м������ݣ�����һ��List����
		ArrayList<Student> r = new ArrayList<Student>(); // ����һ���յļ���
		try {
			FileInputStream fis = new FileInputStream("a1.txt");
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			BufferedReader br = new BufferedReader(isr);
			String s = " ";
			while ((s = br.readLine()) != null) {
				s = s.trim();
				if (s.length() == 0)
					continue; // ����������ǿգ����������һ��
				StringTokenizer st = new StringTokenizer(s, ","); // �ַ����ָ�����
				String id = st.nextToken().trim(); // �ָ�Ϊ�������
				String name = st.nextToken().trim();
				int age = Integer.parseInt(st.nextToken().trim());
				int java = Integer.parseInt(st.nextToken().trim());
				String email = st.nextToken().trim();
				//boolean gender = st.nextToken().trim().equals("��");
				/*
				 * ����Ĵ���ʵ��Ҳ�������������ķָ�� String[] sa = s.split(",");
				 * //����String���split����Ҳ������� String id = sa[0].trim(); String
				 * name = sa[1].trim(); String email = sa[2].trim(); int age =
				 * Integer.parseInt(sa[3].trim()); int java =
				 * Integer.parseInt(sa[4].trim()); boolean gender =
				 * sa[5].trim().equals("��");
				 */
				Student stu = new Student(id, name,age,java ,email);
				r.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public static void main(String[] args) {
		TextDataLoader dl1 = new TextDataLoader();
		ArrayList<Student> list = dl1.load(); // ���������ļ����ݵ�����list
		int sum = 0; // �ۼӳɼ�
		for (int i = 0; i < list.size(); i++) { // ����list����
			Student s = list.get(i);
			sum += s.getJava(); // �ۼ�
			if (s.getJava() < 60) {
				System.out.println(s.getName() + " failed.");
			}
		}
		System.out.println("average��= " + 1.0 * sum / list.size()); // ���ƽ���ɼ�
		Collections.sort(list); // ���򼯺�
		for (int i = 0; i < list.size(); i++) { // ���ճɼ���������ɼ���
			Student s = list.get(i);
			System.out.println(s.getId() + "\t\t\t" + s.getName() + "\t\t\t"
					+ s.getJava());
		}
	}
}
