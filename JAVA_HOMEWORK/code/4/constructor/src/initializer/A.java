package initializer;

public class A {
	int i = 0;
	{
		System.out.println("first");
	} // ��ʼ������

	A(int i) {
		this.i = i;
		System.out.println("contructor");
	}

	{
		System.out.println("second");
	} // ��ʼ������

	public static void main(String[] args) {
		A a = new A(5);
		A b = new A(6);
	}
}
