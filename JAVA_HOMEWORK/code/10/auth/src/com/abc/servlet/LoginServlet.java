package com.abc.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String authcode = request.getParameter("authcode");

		HttpSession session = request.getSession();

		if (username == null || username.length() == 0) {
			forward(request, response);
			return;
		}
		if (password == null || password.length() == 0) {
			forward(request, response);
			return;
		}
		if (authcode == null || authcode.length() == 0) {
			forward(request, response);
			return;
		}
		if (!username.equals(password)) { // �˴�û���ṩʲô��֤�߼���ֻҪ
			forward(request, response); // �û���������һ�����¼�ɹ�
			return;
		}
		// �û��������֤�����Ͳ�������֤��һ��
		// ��������֤������session�У���������������֮�乲������
		if (!authcode.equals(session.getAttribute("authcode"))) {
			forward(request, response);
			return;
		}

		response.setContentType("text/html");
		response.getWriter().println("login success!");

	}

	private void forward(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
		// response.sendRedirect("login.html��);
	}
}
