public class Test { // Test.java��������
	public static void main(String[] args) {
		final Stack stack = new Stack(); // main������Ƕ����Է����������
		Thread t1 = new Thread() { // ������̳���Thread��
			public void run() { // ������run����
				try {
					for (int i = 0; i < 10; i++) {// ����a-z֮�������ַ�
						char c = (char) ('a' + ((int) (Math.random() * 26)));
						stack.push(c); // ѹ��ջ��
						Thread.sleep(c * 10); // �õ�ǰ��������һ���
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread() { // ��һ���̶߳���ѹ���ַ�������̵߳����ַ�
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(100); // ����һ������ȴ��ַ�ջ��������
						char c = stack.pop();
						System.out.println(c);
						Thread.sleep(c * 10);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
