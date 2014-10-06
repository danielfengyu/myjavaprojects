package mytags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.*;

//�����Ǵ�������ʵ�ְ���ָ���ĸ�ʽ����ɫ��ʽ���ʱ��
public class TimeTag extends TagSupport {
	private String color, format;

	// ������color���Ե�д����
	public void setColor(String color) {
		this.color = color;
	}

	// ������format���Ե�д����
	public void setFormat(String format) {
		this.format = format;
	}

	// ��Ϊ�ǿ�Ԫ�أ������Թ������ݴ�����̣��������Ҳ���Բ�д��
	// ʹ��TagSupport���Ĭ��ʵ��Ҳ���ԡ�
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		try {
			Date d = new Date();
			if (format == null) { // ���JSPû�д��ݸ�ʽ������formatΪnull
				format = "yyyy-MM-dd"; // Ĭ�ϵĸ�ʽ
			}
			if (color == null) { // ���JSPû�д�����ɫ������colorΪnull
				color = "black"; // Ĭ�ϵ���ɫ
			}
			// java.text.SimpleDateFormat���԰���ָ�������ڸ�ʽ��Date����
			// ת��Ϊ�ַ�������JavaSEƽ̨��SimpleDateFormat API�淶
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			String sd = sdf.format(d);

			// JspWriter��̳���Writer�࣬��������ݵķ���write��print��println
			// �ȷ�������IOException���쳣������������Ҫ��������쳣������
			JspWriter out = pageContext.getOut();
			out.write("<font color=\"" + color + "\">" + sd + "</font>");
		} catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	// ��JSPҳ���е�����ϱ�Ǵ����������Ҫ����release������
	// ����������ͷŻض�����У�������Ҫ��format��color������Ϊnull
	public void release() {
		format = null;
		color = null;
	}
}
