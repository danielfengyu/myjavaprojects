public class Student implements java.io.Serializable, Comparable { // ʵ�������л��ӿ�
	private String id, name, email;
	private int java, age;
	private boolean gender;

	public Student() { // �ṩ���������췽��
	}

	public Student(String id, String name, int age, int java ,String email
			) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.java = java;
		this.age = age;
		//this.gender = gender;
	}

	public void setAge(int age) { // ���������Ե�setter/getter����
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

	public int hashCode() { // ʵ��ɢ�з���
		return id.hashCode();
	}

	public boolean equals(Object o) { // �ṩ��������жϷ���
		if (o instanceof Student) { // �򵥵�ʵ�֣����ѧ����Ⱦ���Ϊ�������
			return id.equals(((Student) o).id); // ��û�бȽ�ȫ������������
		}
		return false;
	}

	public int compareTo(Object o) { // �ṩ����ıȽϷ���
		Student s = (Student) o;
		return s.java - this.java; // ע�⣺����this.java �C s.java��
	} // ��Ϊ��Ҫ����Java�ɼ�����������ɼ���

	public String toString() { // ��дObject���toString()����
		return "Student{" + "id=" + id + ", name=" + name + ",age=" +age
				+ ", java=" + java + ", email=" + email+ "}";
	}
}
