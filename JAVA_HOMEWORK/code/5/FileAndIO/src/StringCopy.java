import java.io.*;

//Ϊ�ı���������кŵĹ��ܡ�
public class StringCopy {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	int i = 0;

	public static void main(String[] args) {
		StringCopy sc = new StringCopy();
		sc.write("hello");
		sc.write("nihao");
		sc.write("bye!");
		sc.print();
	}

	public void write(String s) {
		i++; // �к�+1
		s = i + ": " + s + "\r\n"; // ����кźͻس�����
		try {
			baos.write(s.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print() {
		try {
			ByteArrayInputStream bais = // ����һ���ֽ�������
			new ByteArrayInputStream(baos.toByteArray()); // ����Դ��һ������
			int c = 0;
			byte[] buffer = new byte[8192];
			while ((c = bais.read(buffer)) != -1) {
				String s = new String(buffer, 0, c); // ����һ���ַ�������
				System.out.print(s); // ���
			}
			bais.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
