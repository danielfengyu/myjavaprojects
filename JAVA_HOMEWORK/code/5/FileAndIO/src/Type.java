import java.io.*;

public class Type { // ��ʾ����ı��ļ�������
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(args[0]); // �����ı�����������
			int c = 0;
			while ((c = fr.read()) != -1) { // ��һ���ַ����ݣ�ֱ����������ȫ�������
				System.out.print((char) c); // ������ַ���ע�����ת��Ϊchar����
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
