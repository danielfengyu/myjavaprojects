public class B extends A {
	float f;

	public B(float f) { // ��������Ǵ���ģ����벻ͨ��
						// super(0);  //ͨ������һ��Ĭ��ֵ����ɳ�ʼ������ĳ�Ա
		this.f = f; // �ڴ����ǰ�����������һ��super()��������
	} // ���ǣ�����û���޲����Ĺ��췽��
	
	//���������������ȷ�Ĺ��췽������ΪB��ӵ��������Ա��Ӧ�ö���������Ա���г�ʼ��
	//ͨ�����ø���Ĺ��췽������ɼ̳еĸ���ĳ�Ա�ĳ�ʼ����Ȼ���ǳ�ʼ������ĳ�Ա
	public B(float f, int i) {
		super(i);
		
		this.f = f;
	}

	public static void main(String[] args) {
		B b1 = new B(3f);
	}
}
