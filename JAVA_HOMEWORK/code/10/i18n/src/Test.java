import java.util.*;

public class Test {
	public static void main(String[] args) throws Exception {
		/*
		 * ��Դ�ļ������ݷ�װ��һ��ResourceBundle�����У�����ͨ��
		 * ResourceBundle��������Դ�ļ��������ָ��Locale����ôʹ�� ƽ̨Ĭ�ϵ���������ԡ�������Դ�ļ�ʱ��Ҫָ���������ƣ�
		 * ����������Ӵ����У�������Դ����Ϊa����Ӧ����Դ�ļ�Ϊ
		 * a.properties������a_zh_CN.properties������a_ja_JP.properties��
		 */
		// ResourceBundle rb = ResourceBundle.getBundle("a",
		// Locale.getDefault());
		ResourceBundle rb = ResourceBundle.getBundle("a",
				new Locale("ja", "JP"));
		System.out.println(rb.getString("greeting"));
	}
}
