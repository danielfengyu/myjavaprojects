import java.io.*;

public class Copy2 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(args[0]);
			FileOutputStream fos = new FileOutputStream(args[1]);
			int c = 0;
			byte[] buffer = new byte[8192]; // �����ֽ�������Ϊ������
			while ((c = fis.read(buffer)) != -1) { // һ�ζ���һ�����飬Ч�ʸ���
				fos.write(buffer, 0, c); // ������������������������
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
