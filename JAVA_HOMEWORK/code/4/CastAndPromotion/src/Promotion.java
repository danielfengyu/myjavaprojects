public class Promotion {
	public static void main(String[] args) {
		byte b1 = 5, b2 = 6;
		// b1 = b1 + b2; //�������Ǵ���ģ�+�������ص���С������int
		b1 += b2; // +=������һ��������ǿ��ת��
		// �ȼ���b1 = (byte) (b1+b2)
		float f = 3.0f;
		f = f + b1; // b1��ֵ���Զ�����Ϊfloat���͵�ֵ��Ȼ���f���
		b1 = (byte) f; // floatǿ��ת��Ϊbyte
		f = 220.1234f;
		b1 = (byte) f; // ������С�����֣�ת��Ϊint�������ݣ������������ֽ�
		System.out.println(b1);
		double d = 10e44;
		b1 = (byte) d; // ������С����ת��Ϊint���ͣ�
		// �������������int�����ֵ�����Ը���int���ֵ��
		// ��������3���ֽڣ����ʣ��һ���ֽڣ���Ȼ��ȫ1
		System.out.println(b1); // ��������-1
		int i = (int) d; // i��ֵΪint���͵����ֵ
		                 //������ŷ����1772�������ֵ�һ��÷ɭ������������2^31-1����32λ����ϵͳ�����ķ��������ͳ�����
		System.out.println(i);
		new Promotion().a(b1, f); // ��������ʱ�����ݲ���Ҳ����������
	}

	public int a(int i, float f) {
		return (int) (i + f);
	}
}
