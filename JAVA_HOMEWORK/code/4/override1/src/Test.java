class A {
	public void someMethod() {
		System.out.println("A");
	}
}

class B extends A {
	public void someMethod() {
		System.out.println("B");
	}
}

class Test {
	public static void main(String[] args) {
		A a = new A();
		a.someMethod(); // ִ�е���A���someMethod����
		B b = new B();
		b.someMethod(); // ִ�е���B���someMethod����
		A a2 = new B();
		a2.someMethod();  //ִ�е���B���someMethod����
		                  //ʵ����Ա������Ҳ���ǷǾ�̬���������Ǻ��ʵ�֣����Ƕ�̬�󶨣�
	}
}
