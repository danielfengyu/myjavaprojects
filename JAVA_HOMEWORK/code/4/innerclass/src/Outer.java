public class Outer {
	int i = 5;

	public void a() {
		class MethodEnclosed { // ������Ƕ�࣬�����ڷ�����
			int i = 6;

			public void a() {
				System.out.println(i); // ���ʵ�ǰ��ĳ�Ա
				System.out.println(this.i); // �����������һ����
				System.out.println(Outer.this.i); // �ⲿ��ĳ�Ա
			}
		} // ��������������ſ���ʹ��
		MethodEnclosed me = new MethodEnclosed();
		me.a(); // �ͷ����ڵı���һ����ֻ���ڷ����ڿ���
	}

	class Inner { // ��Ա�ڲ���
		int i = 7;

		public void a() {
			System.out.println(i); // Ĭ�Ϸ��ʵ��ǵ�ǰ��ĳ�Ա
			System.out.println(this.i); // �����������һ����
			System.out.println(Outer.this.i); // �ⲿ���Ա�ķ�����ʽ
		}
	}

	public static void main(String[] args) {
		Outer o = new Outer(); // ����һ���ⲿ�����
		Inner i = o.new Inner(); // �ٴ������ڲ������
		o.a(); // ����Ǿ�̬�ڲ��࣬��û�б�Ҫ����
		i.a(); // �ⲿ��ʵ���ˡ�
	}
}
