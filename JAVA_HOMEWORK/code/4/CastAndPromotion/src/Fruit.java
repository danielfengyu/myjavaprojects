public class Fruit {
}

class Apple extends Fruit {
}

class Test {
	public static void main(String[] args) {
		int i1 = 5, i2 = 1000;
		byte b1 = (byte) i1;
		byte b2 = (byte) i2; // intת����byte,
		// ת������ֱ�ӽ�����3���ֽڵ����ݶ�����
		System.out.println(b1); // ��һ������ת����ֵδ��
		System.out.println(b2); // �ڶ�������ת����ֵ�����仯

		Fruit f1 = new Fruit();
		Fruit f2 = new Apple(); // ��������ñ�������ָ������ʵ��
		Apple a1 = new Apple();
		Apple a2;
		a1 = f1; // �﷨���󣬴���������ֱ�Ӹ���С���ͱ�����
		a2 = f2; // �﷨���󣬴���������ֱ�Ӹ���С���ͱ�����

		a1 = (Apple) f1; // �﷨û�д��󣬵����ڸ�ֵ���գ�
		a2 = (Apple) f2;

		f1 = a1; // ����Ǹ�ֵ��������������ж�û������
		f2 = a2;
	}
}
