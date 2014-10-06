class Stack {
	private int index = 0;
	private char[] data = new char[100];

	synchronized public void push(char c) {
		while (index == data.length) { // ��Ӧ��ʹ��if�������ж�
			try { // �������������ж�Ӧ��ʹ��while
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		data[index] = c;
		index++;
		notify(); // �����ΪnotifyAll(); ����Ч���Ե�
	}

	synchronized public char pop() {
		while (index == 0) { // ��Ӧ��ʹ��if�������ж�
			try { // �������������ж�Ӧ��ʹ��while
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		index--;
		notifyAll(); // �����ȵ���notify()����
		return data[index];
	}
}
