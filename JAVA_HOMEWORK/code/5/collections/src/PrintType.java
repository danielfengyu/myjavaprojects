class G<T> { // һ�������࣬��װ��һ���������ݣ��������ݵ�������T
	private T data; // ���Դ���һ����װ�ַ�������װInteger���͵�G����

	public G(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

class PrintType { // ��������G���Ͷ���ķ�װ���������ݵ����͵�����
	/*
	 * �������������� public void print(G<Object> o) { // ���Ͳ���T������String��������Integer //
	 * ��ζ�����������أ���ʹ��G<Object>ô��
	 * System.out.println(o.getData().getClass().getName()); }
	 */

	public void print(G<?> o) { // ���Ͳ���T������String��������Integer
		// ��ζ�����������أ���ʹ��G<Object>ô��
		System.out.println(o.getData().getClass().getName());
	}

	public static void main(String[] args) {
		// ����������G���͵Ķ���һ����װ��Integer����һ����װ��String����
		G<Integer> g1 = new G<Integer>(new Integer(5));
		G<String> g2 = new G<String>(new String("nihao"));

		PrintType p = new PrintType();
		p.print(g1); // �������д���G<Object>��G<Integer>����ת��
		p.print(g2); // �������д���G<Object>��G<String>����ת��
	}
}
