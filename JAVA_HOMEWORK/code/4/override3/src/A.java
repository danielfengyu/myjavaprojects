class A {
	public void a() {
		System.out.println("a");
	}

	public void b() {
		this.a();
	}
}

class B extends A {
	public void a() {
		System.out.println("b");
	}

	public void b() {
		System.out.println("hehe");
		super.b();
	}

	public static void main(String[] args) {
		A a = new B(); // ����������Ķ������������Ǹ�������
		a.b(); // �����˸��ǣ������b���������ã�Ȼ���ڸ÷����е����˸����b����
		       //�����b���������˵�ǰ�����a()�������������и��Ƿ�������Ȼ���õ��������a()������
	}
}
