import java.io.*;

public class Type2 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(args[0]); // �����ļ��ĸ�ʽ
			// ��ʲô�������ֽ�������ʽ����
			InputStreamReader isr = new InputStreamReader(fis, "GBK"); // �������
			// ���Ϊ����������ɽ��ֽ����е����ݰ���ָ������ת��Ϊ�ַ���
			BufferedReader br = new BufferedReader(isr); // �����ṩ�����ַ�����
			// ���ܣ�ͬʱ����������س��ͻ��з����ṩ�����ݶ���
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
