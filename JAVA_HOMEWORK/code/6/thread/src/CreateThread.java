public class CreateThread { // CreateThread.java
	public static void main(String[] args) {
		Runnable r1 = new Task1(); // ���������������
		Runnable r2 = new Task2(); // ��������������ṩ run����

		Thread t1 = new Thread(r1); // ����һ���̶߳������Ʋ���Ĭ�ϵ�����
		Thread t2 = new Thread(r2, "thread-2"); // �����̣߳�����Ϊthread-2

		t1.start(); // �����߳�
		t2.start();
		System.out.println("done.");
		// �������������ж�Σ�������ѭ�����������Կ����̵߳��������
		// �������̵߳ĵ��ȣ�������������еĽ�����ܲ�ͬ��
	}
}
