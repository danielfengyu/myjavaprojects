class Test2 {
	public static void main(String[] args) {
		Fruit f1 = new Fruit();
		Fruit f2 = new Apple();
		Apple a1 = null;
		Apple a2 = null;
		if (f1 instanceof Apple) { // �ж�f1 ָ��Ķ����Ƿ���Apple���ʵ��
			a1 = (Apple) f1; // ������Apple�����ʵ��
		}
		if (f2 instanceof Apple) { // ����ǣ��򷵻�true��Ȼ��Ž��а�ȫ��ת��
			a2 = (Apple) f2;
		}
		System.out.println(a1); // ��ӡ������Ϊnull
		System.out.println(a2); // �����Ȼ����null

	}
}
