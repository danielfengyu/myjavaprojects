//�����࣬Դ�ļ�����ֻ��Ϊ Init.java

public class Init {
	MyDate m = new MyDate();
	MyDate n;		//�Զ���ʼ��Ϊnull
	int i = 5;
	int j;				//�Զ���ʼ��Ϊ0
	
	public static void main(String[] args) {
		MyDate x = new MyDate();
		MyDate y;	//δ��ʼ��
		int a = 5;
		int b;		//�����Զ���ʼ��
		
		Init in = new Init();
		System.out.println(in.m);
		System.out.println(in.n);
		System.out.println(in.i);
		System.out.println(in.j);
		
		System.out.println(x);
		System.out.println(y);		//�������Ǵ���ģ�y��û�г�ʼ��
		System.out.println(a);
		System.out.println(b);		//������Ҳ�Ǵ���ģ�bû�г�ʼ��
	}
}
