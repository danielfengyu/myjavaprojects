package b; //Դ�ļ�����ΪB.java

import a.A;

public class B extends A {
	public static void main(String[] args) {
		B b = new B();
		b.i = 9; // ���������Ա�ķ�������ȷ��
		A a = new A();
		// a.i = 9; // ���������Ա�ķ����Ǵ���ģ��������
	}
}
