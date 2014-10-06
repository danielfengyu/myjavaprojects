package base;

public class Student implements java.io.Serializable, Comparable, Cloneable {
	private String id, name, email; // ѧ�ţ����֣��ʼ���ַ
	private int java, age; // Java�ɼ�������
	private boolean gender; // �Ա�true���У�false��Ů��

	public Student() {
	}

	public Student(String id, String name, String email, int java, int age,
			boolean gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.java = java;
		this.age = age;
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	public int getJava() {
		return java;
	}

	public String getName() {
		return name;
	}

	public boolean getGender() {
		return gender;
	}

	public int hashCode() {
		return id.hashCode();
	}

	public boolean equals(Object o) {
		if (o instanceof Student) {
			return id.equals(((Student) o).id);
		}
		return false;
	}

	public int compareTo(Object o) {
		Student s = (Student) o;
		return s.java - this.java; // �ɼ����ߣ�����С�����ɼ����ߣ����󡰴�
	}

	public String toString() {
		return "Student{" + "id=" + id + ", name=" + name + ", email=" + email
				+ ", java=" + java + ", age=" + age + ", gender=" + gender
				+ '}';
	}

	public static void main(String[] args) throws Exception { // ���Գ���
		Student s1 = new Student("007", "zxx", "zxx@163.com", 99, 20, true);
		Student s2 = (Student) s1.clone(); // ����clone����
		System.out.println("s1 == s2 " + (s1 == s2));
		System.out.println("s1.equals(s2) " + s1.equals(s2)); // ��������жϹ���
		System.out.println(s1); // ����toString����
		System.out.println(s2);
	}
}
