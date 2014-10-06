interface K {
	void a();
}
class A {
	public void a() {
		System.out.println("a");
	}
}
class B extends A implements K {
	
}
class InstanceOfExample {
	public static void main(String[] args) {
		Object o = new int[0];
		if(o instanceof A) {		//����false
			A a = (A)o;
		}
		if(o instanceof K) {		//����false
			K k = (K)o;
		}
		if(o instanceof int[]) {	//����true
			int[] ia = (int[])o;
		}
		A a1 = new A();
		B b1 = new B();
		if(a1 instanceof B) {	//����false
			B b2 = (B)a1;
		}
		if(a1 instanceof K) {	//����false������a1������a��������������
			K k2 = (K)a1;		//��A�����в�û��ʵ�ֽӿ�K
		}
		if(b1 instanceof A) {	//����true
			A a2 = (A)b1;
		}
		if(b1 instanceof K) {	//����true
			K k2 = (K)b1;
		}
	}
}
