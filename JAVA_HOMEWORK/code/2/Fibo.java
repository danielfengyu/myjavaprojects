public class Fibo {
	public static void main(String[] args) {
		Fibo f = new Fibo();
		System.out.println(f.fibo1(7));	//�����ַ�������Ч�ʸ��ߣ�
		System.out.println(f.fibo2(7));
	}

	public int fibo1(int n) {			//ʹ�÷����ݹ���ʵ��
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibo1(n - 1) + fibo1(n - 2);
		}
	}

	public int fibo2(int n) {			//ʹ��ѭ����ʵ��
		int a0 = 0, a1 = 1, r = 0;
		if (n == 0) {
			return a0;
		} else if (n == 1) {
			return a1;
		} else {
			for (int i = 2; i <= n; i++) {
				r = a0 + a1;			//��ǰ���ֵ
				a0 = a1;				//ǰ2���ֵ
				a1 = r;				//ǰ1���ֵ
			}
			return r;
		}
	}
}
