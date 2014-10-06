public class Student implements Comparable {
	private String id, name; // ���õķ�װӦ�ý����Զ���Ϊ˽��
	private int age;
	private boolean gender;

	// ���������ص��������췽��
	public Student(String id, String name, int age, boolean gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Student() {
	}

	// ���������ԵĶ�д������getters/setters.
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	// ����жϷ���������Object���equals����
	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student s = (Student) o;
			return s.id.equals(id) && // �����ַ������equals����
					s.name.equals(name) && s.age == age && s.gender == gender;
		} else {
			return false;
		}
	}

	public int compareTo(Object o) { // �����߳���Ӧ�ñ�֤��ͬ���͵Ķ�����бȽ�
		Student s = (Student) o; // �����п����׳�ClassCastException�쳣��
		return this.age - s.age; // �ĸ�ͬѧ����������ͬѧ����ʹ�
		// Ҳ���Ե���String���compareTo�������������ֻ�ѧ�Ž��бȽ��ж�
		// return this.name.compareTo(s.name);
		// return this.id.compareTo(s.id);
	}

}
