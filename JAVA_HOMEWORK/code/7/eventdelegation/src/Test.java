//�����ǲ��Գ���Test.java
//��ִ�м�������ĳ��򣬹۲����ڵ�ִ��˳��˵�����̵߳ĵ��Ⱥ�ִ�о��в�ȷ���ԡ�

public class Test {
	public static void main(String[] args) {
		Student s = new Student();
		Parent p1 = new Parent();
		Parent p2 = new Parent();
		Classmate c1 = new Classmate();
		s.addAgeChangedListener(p1);
		s.addAgeChangedListener(p2);
		s.addAgeChangedListener(c1);

		s.setAge(18);
	}
}
