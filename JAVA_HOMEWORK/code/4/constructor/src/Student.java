public class Student {
	private String id, name;
	private int age;

	public Student(String id, String name, int age) {
		setId(id);
		setName(name);
		setAge(age);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} // ���������жϣ����Ǽ򵥵�this.age = age;
	}
}
