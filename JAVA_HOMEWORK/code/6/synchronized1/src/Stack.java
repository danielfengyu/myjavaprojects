public class Stack { // Stack.java
	private char[] data = new char[100]; // ���ַ�ջ���������100���ַ�
	private int index;

	public void push(char c) {
		data[index] = c;
		index++;
	}

	public char pop() {
		index--;
		return data[index];
	}
}
