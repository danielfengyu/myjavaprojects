import java.io.*;

public class Copy1 /* ������δ���� */{
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(args[0]);
			FileOutputStream fos = new FileOutputStream(args[1]);
			int c = 0;
			while ((c = fis.read()) != -1) { // ���ļ��ж�һ���ֽڣ�ֱ���ļ�����
				fos.write(c);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
