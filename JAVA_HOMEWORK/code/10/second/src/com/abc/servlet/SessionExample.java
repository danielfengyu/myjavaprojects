package com.abc.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/SessionExample")
public class SessionExample extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=\"white\">");
		out.println("<head>");
		String title = "Session Example";
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>" + title + "</h3>");
		/*
		 * �õ�session��������ǵ�ǰ��������̵�һ�η��ʣ����´���һ�� session���󣬲�ͨ��cookie��url
		 * rewriting��hidden field������session id
		 * �ַ������ݸ��ͻ��ˣ�һ�㶼��ʹ��cookie������Ȼ���´θ������
		 * �����ٷ�������������ٴε���getSession���������õ�session����
		 * �Ͳ����´����ˣ������ϴδ������Ǹ�session����ֱ���رո������ ���̣�����ִ��invalidate�������˳�session��
		 */
		HttpSession session = request.getSession(true);
		out.println("Session Id: " + session.getId());
		out.println("<br>");
		out.println("Session Created: " + new Date(session.getCreationTime())
				+ "<br>");
		out.println("Session Last Accessed Time: "
				+ new Date(session.getLastAccessedTime()));
		String dataName = request.getParameter("dataname");
		String dataValue = request.getParameter("datavalue");
		if (dataName != null && dataValue != null) {
			// ���ͻ����ύ�����ݰ󶨣��洢����session��
			session.setAttribute(dataName, dataValue);
		}
		out.println("<P>");
		out.println("Session Data: <br>");
		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = session.getAttribute(name).toString();
			out.println(name + " = " + value + "<br>");
		}
		out.println("<P>");
		out.print("<form action=\"");
		// �����Ƿ�ر�Cookie�����session id��URL��
		out.print(response.encodeURL("SessionExample"));
		out.print("\" ");
		out.println("method=POST>");
		out.println("Session Data Name:");
		out.println("<input type=text size=20 name=dataname><br>");
		out.println("Session Data Value:");
		out.println("<input type=text size=20 name=datavalue><br>");
		out.println("<input type=submit>");
		out.println("</form>");
		out.println("<P>GET based form:<br>");
		out.print("<form action=\"");
		out.print(response.encodeURL("SessionExample"));
		out.print("\" ");
		out.println("method=GET>");
		out.println("Session Data Name:");
		out.println("<input type=text size=20 name=dataname><br>");
		out.println("Session Data Value:");
		out.println("<input type=text size=20 name=datavalue><br>");
		out.println("<input type=submit>");
		out.println("</form>");
		out.print("<p><a href=\"");
		// �����Ƿ�ر�Cookie�����session id��URL��
		out.print(response
				.encodeURL("SessionExample?dataname=foo&datavalue=bar"));
		out.println("\" >URL encoded </a>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
}
