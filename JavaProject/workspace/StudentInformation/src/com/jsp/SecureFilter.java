package com.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SecureFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		// ������ת����HttpServletRequest����
		HttpServletRequest request = (HttpServletRequest) arg0;
		
		// ���session����
		HttpSession session = request.getSession();
		
		// ȡ���Ƿ��¼�ɹ��ı�־����
		String s = (String) session.getAttribute("login");
		if (s == null) { // ���Ϊ�գ�û�е�¼������ת����login.htmlҳ��
			request.getRequestDispatcher("/LogIn.html").forward(arg0, arg1);
			return; // �������
		}
		if (s.equals("true")) { // �����¼�ɹ�����ô��������������
			arg2.doFilter(arg0, arg1);
		} else { // ����ֵΪfalse����ôҲת������¼ҳ��
			request.getRequestDispatcher("/LogIn.html").forward(arg0, arg1);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
