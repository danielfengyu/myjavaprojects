import java.io.*;

public class PrintExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("b.txt");
		PrintStream ps = new PrintStream(fos);
		ps.println("���"); // ������ı����ݽ�����ƽ̨Ĭ�ϵı���ת��Ϊ
		// �ֽ���������������ӵ�fos�ļ��������
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos, "GBK"));
		pw.println("���2"); // ������������������ı����ݰ���ָ���ı���
		pw.close(); // ������ı��ļ���
	}
} //b.txt�ı��ļ�������������������ı�����

