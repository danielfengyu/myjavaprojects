public class A { // A.java
	public void a(K k) { // ����a��Ҫ����һ��ʵ�ֽӿ�K�Ķ���
		k.a(); // ���øýӿڵ�a��b����
		k.b();
	}

	public static void main(String[] args) {
		A a1 = new A(); // ����һ��A����
		a1.a(new K() { // ������a����
			public void a() {
				System.out.println("a");
			}

			public void b() {
				System.out.println("b");
			}
		});
	}
}
