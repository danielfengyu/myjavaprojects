import java.io.*;

public class MyException extends Exception { // �ص�����ṩ���췽���Ķ���
	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public static void main(String[] args) {
		try {
			x();

		} catch (MyException ex) {
			ex.printStackTrace();
		}
	}

	static public void x() throws MyException {
		try {
			FileInputStream fis = new FileInputStream("a.dat");
			fis.read();
			fis.close();
		} catch (Exception ex) {
			throw new MyException(ex);
		}
	}

}
