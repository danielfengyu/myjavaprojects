public class Calc {
	//Java�����еķ�����C++�����еĳ�Ա��������
	public int add(int i, int j) {
		return i + j;
	}
	public int subtract(int i, int j) {
		return i - j;
	}
	public int factorial(int i) {		//��׳˷���
		if(i==1) {
			return 1;
		}
		else {
			return factorial(i-1)*i;	//�����ݹ�
		}
	}
	public static void main(String[] args) {
		Calc c = new Calc();
		System.out.println("5 + 6 = " + c.add(5, 6));
		System.out.println("11 - 5 = " + c.subtract(11, 5));
		System.out.println(c.factorial(5));
	}
}