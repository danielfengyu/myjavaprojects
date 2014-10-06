package mytags;

import java.util.*;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

// BodyTagSupport��ʵ����IterationTag�ӿں�BodyTag�ӿ�
public class IterationTag extends BodyTagSupport {
	private String var; // �洢�Զ���ű�����������
	private String type; // �洢�Զ���ű�����������
	private Vector list; // ������ļ�������

	private Iterator iterator = null; // �������ݵĵ���������

	public void setVar(String var) {
		this.var = var;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setList(Vector list) {
		this.list = list;
		iterator = list.iterator();
	}

	public int doStartTag() {
		int result = 0;
		// ���������Ϊ�գ�û�пɵ��������ݣ��Թ�������
		if (iterator == null) {
			result = SKIP_BODY;
		} else {
			if (iterator.hasNext()) {
				// ���е��������ݣ���ô�������е�����ȡ�������뵽pageContent
				// ��JSPҳ���п���ͨ��<jsp:getProperty/>����ȡ������Bean��ֵ
				pageContext.setAttribute(var, iterator.next());

				// �ɷ���EVAL_BODY_BUFFERED��Ҳ�ɷ���EVAL_BODY_INCLUDE
				// �緵��EVAL_BODY_INCLUDE����ô�������е�JSP����ֱ��
				// �����JspWriter���͵�JSP��������out�С�
				// �緵��EVAL_BODY_BUFFERED����ô��������JSP���������
				// BodyContent���͵�out�����У����������е�JSP����Ƭ�ε�
				// ��������out��������Ԫ�����JSP��������out������
				// Ҳ����JspWriter������ͨ������BodyTagSupport���ṩ��
				// getPreviousOut��������BodyContent���getEnclosingWriter
				// ���Ԫ�����JSP��������out��
				result = EVAL_BODY_BUFFERED;
				// result = EVAL_BODY_INCLUDE;
			} else {
				result = SKIP_BODY;
			}
		}
		return result;
	}

	// ���doStartTag�����ķ���ֵ��EVAL_BODY_BUFFEREDʱ����ִ�д˷���
	public void setBodyContent(BodyContent bc) {
		// ���ø����setBodyContent���������ܴ����BodyContent����
		super.setBodyContent(bc);
		System.out.println("setBodyContent");
	}

	// doInitBody������setBodyContent����ִ�к�ִ�У�Ҳ����doStartTag����
	// �з���EVAL_BODY_BUFFEREDʱ�ŵ��ô˷�����
	public void doInitBody() throws JspException {
		System.out.println("init body");
	}

	// �����ݵĵ���������ִ������������е�JSP�����ִ��doAfterBody������
	// �˷����ķ���ֵ�����EVAL_BODY_AGAIN��������ִ���������е�JSP����
	public int doAfterBody() {
		int result = 0;
		if (iterator.hasNext()) {
			// �缯���л���δ������Ԫ�أ�������ִ�������ݣ������һ��Ԫ�ء�
			pageContext.setAttribute(var, iterator.next());
			result = EVAL_BODY_AGAIN;
		} else {
			result = SKIP_BODY;
		}
		return result;
	}

	public int doEndTag() throws JspException {
		BodyContent bc = getBodyContent();
		// ��doStartTag�ķ���ֵ��EVAL_BODY_INCLUDE����û�д���
		// BodyContent����getBodyContent����������null��������Ԫ��������
		// ��ֱ�������JSP��������out�С�doEndTag��������ʵ�֡�
		// ��doStartTag�����ķ���ֵ��EVAL_BODY_BUFFERED����ôԪ�������ݵ�
		// ִ�н������������������������BodyContent�У���û��ֱ�������
		// Ԫ�����out�����У���Ҫ��BodyContent�����е����ݶ����������
		// ��JspWriter���͵�out�����С�
		if (bc != null) {
			// ������out������ͬһ�����󣬶���Ԫ�������������out��
			JspWriter out = getPreviousOut();
			// JspWriter out = bc.getEnclosingWriter();

			try { // �������ݶ����е����ݣ�������ⲿ��out����
				out.print(bc.getString());
			} catch (IOException e) {
				throw new JspException("iterator: " + e.getMessage());
			}
		}
		return EVAL_PAGE;
	}
}
