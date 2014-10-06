package com.abc.dl.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	/*
	 * ����û�֪����LoginServlet�����URL��ַ����������
	 * http://localhost:8080/dl/login����ô������ת����login.html�����ҽ� �û��ѵ�¼�������־��Ϊfalse��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("login", "false");
		request.getRequestDispatcher("/login.html").forward(request, response);
	}

	/*
	 * ��������£��û���login.htmlҳ�������û��������룬�ύ��������� �����doPost���������ã����е�¼��֤
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// �û������벻Ϊ�գ����Ҷ���ֵһ������Ϊ��֤ͨ����������Ǹ�����
		if (username != null && password != null && username.equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("login", "true"); // ���õ�¼�ɹ���־
			/*
			 * �ɷ���main.html�������б�Ҳ���Խ�����̶���URL��ַ�޸�һ�£� ����û�δ��¼��ֱ�ӽ����ļ����أ����磺
			 * http://localhost:8080/dl/servlet/download?fileid=1
			 * ���ڹ��������ظ����󣬽�����ת������¼ҳ�棬�����¼�ɹ���Ӧ�� ��ת���������URL�����Դ�session��ȡ����ǰ��URL��ַ
			 */
			request.getRequestDispatcher("/servlet/main.html").forward(request,
					response);
			return;
		}
		// �����¼δ�ɹ��������µ�¼��ֱ�ӵ���doGet����
		doGet(request, response);
	}
}
