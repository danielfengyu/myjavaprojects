/*
   ����������һ��Դ�ļ�����������࣬��������Ǿ�����
   ��һ��Դ�ļ��У����Ĺ�������ܶ���һ�������ң�
   �ļ����ƺ�����Ҫһ�¡�
*/

class MyDate {
	int year, month, day;
}

class Test {
	public static void main(String[] args) {
		new MyDate();
		MyDate d1 = new MyDate();
	}
}

class Test2 {
	public static void main(String[] args) {
		
		MyDate d1 = new MyDate();
		
		MyDate d2, d3;	//���ﲢû�������ʹ���MyDate����
		//�������������������ñ�����
		//Java���ñ�����ͬC/C++�����е�ָ�롣
		
		MyDate d4 = new MyDate();		//�������ñ�������������
		MyDate d5 = new MyDate();
		
		d1.year = 1997; d1.month = 7; d1.day = 1;	//ͨ��.�����������ʶ���ĳ�Ա
		//d2.year = 1999; d2.month = 12; d2.day = 20;  //d2���ò�û��ָ��ĳ������
													//�����ĳ����ǲ�����ġ�
		d2 = d4;
		d3 = d5;
		d2 = null;
		d3 = null;
		d4 = null;
		d5 = null;
	}
}

class ArrayTest {
	public static void main(String[] args) {
		int[ ] a;				//����������һ�������������͵����ñ���
		int b[ ];				//����һ����ʽ��������ʹ��
		int[ ] c = new int[10];	//�����������ñ���������������󣬳�����10
		byte[ ] ba = new byte[0];
		b = c;
		a = c;
		a[0] = 1;
		b[1] = 3;
		c[2] = 5;				//a, b, c���������ñ���ָ�����ͬһ���������
		System.out.println(b.length);	//����ĳ������ĳ�Ա��ʹ�ó�Ա������.
		System.out.println(ba.length);
		
		MyDate[] da = new MyDate[3];	//������һ��������������
		da[0] = new MyDate();			//Ϊ������Ԫ�س�ʼ��
		da[1] = new MyDate();
		da[2] = new MyDate();
									//����   java ArrayTest
		da[3] = new MyDate();  		//�������Ǵ���ģ������±������0��ʼ
									//ע������ʱ����ľ�����Ϣ
		int[ ][ ] m = new int[2][3];		//��ά���飬���õĶ��壬2*3������
		int[ ][ ] n = new int[2][ ];			//������
		n[0] = new int[3];
		n[1] = new int[4];
		int[ ] array[ ] = new int[3][4];		//�����ã�������ʽҲ����ȷ�ġ�
	}
}


class VariableTest {
	MyDate m = new MyDate();	//��Ա�����ڶ��У��ó�Ա������һ�����ã�ָ���
	public void print() {			//����Ҳ�ڶ���
		MyDate m = new MyDate();	//�ֲ�����m ��ջ�У���ָ��Ķ���Ȼ�ڶ���
		System.out.println(m.year);		//���m�������õ����ϸ���䴴���Ķ���
	}
	public static void main(String[] args) {
		VariableTest vt = new VariableTest();
		vt.print();
	}
}





