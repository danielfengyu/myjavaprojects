import java.util.*;

class Student {
	private String id, name; // ���������˽�����Գ�Ա
	private int age;
	private boolean gender; // ƪ�����ޣ�û���ṩ���ԵĶ�д����getter/setter

	public Student(String id, String name, int age, boolean gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String toString() { // ����Object���toString()����
		return "id = " + id + "\t\tname = " + name;
	}
}

public class MapDemo {
	public static void main(String[] args) {
		Student s1 = new Student("001", "����", 19, true);
		Student s2 = new Student("002", "����", 19, true);
		Student s3 = new Student("003", "����", 20, true);
		Map map = new TreeMap();
		map.put("001", s1); // ע���ֵ�Ե����˳��ͱ���˳��
		map.put("003", s3);
		map.put("002", s2);

		Set set = map.keySet(); // ���عؼ��ּ��ϣ�
		Iterator iterator = set.iterator(); // ��ü��ϵı���������
		while (iterator.hasNext()) { // ѭ����������
			String s = (String) iterator.next(); // �õ��ؼ��ֶ���
			Student stu = (Student) map.get(s); // �õ�ӳ���ֵ����
			System.out.println(stu); // ���ֵ����
		}
	}
}
