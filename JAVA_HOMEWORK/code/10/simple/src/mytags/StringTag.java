package mytags;

import java.io.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
//SimpleTagSupportʵ�ֽӿ�SimpleTag������BodyTagSupport��TagSupport������
//���屣����ԱpageContext���ڴ����в��ṩ�ñ�����Ա��ȡ����֮����ͨ��
//��������getJspContext���JspContext�����ٽ��ö���ǿ��ת��ΪPageContext

public class StringTag extends SimpleTagSupport {
	private String c; // �����Сд���趨��������
	private int count; // ����������ѭ�����������������

	public void setCase(String c) {
		this.c = c;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void doTag() throws JspException, IOException {
		// �����׳�JspException��IOException�������в�����Ҫдtry-catch�ˡ�
		StringWriter sw = new StringWriter(); // ����һ����ʱ���ַ������������
		getJspBody().invoke(sw); // ִ�������ݵ�������������������
		String s = sw.toString(); // ���������ת��Ϊ�ַ���
		if (c != null) { // ���д�Сдת��
			if (c.equalsIgnoreCase("lower")) {
				s = s.toLowerCase();
			} else if (c.equalsIgnoreCase("upper")) {
				s = s.toUpperCase();
			}
		}
		// ����ָ���Ĵ�����ѭ���������������������
		for (int i = 0; i < count; i++) {
			getJspContext().getOut().write(s);
		}
	}
}
