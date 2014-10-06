package num;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/NumberGuessServlet")
public class NumberGuessServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Number Guess</title></head>");
		out.println("<body bgcolor=\"white\"><font size=4>");
		// �õ�session����
		HttpSession session = request.getSession();
		// ��һ�δ���session���򷵻�null����ΪsessionΪ�½��������а󶨵�����
		Object o = session.getAttribute("bean");
		NumberGuessBean bean = null;
		if (o == null) {
			// ���Ϊ�գ����½�һ����Ϸ���󣬲��洢����session��
			bean = new NumberGuessBean();
			session.setAttribute("bean", bean);
		} else {
			bean = (NumberGuessBean) o;
		}
		/*
		 * ����Ĵ��봦��ͻ����ύ�����ݣ��������ҳ������FORM���� �������ı�����������Ϊguess��Ҫע���Сд�����⣬����
		 * action����û���ṩ��Ĭ��Ϊ�ύ����ǰҳ�棬Ҳ�������Servlet
		 */
		String guess = "";
		guess = request.getParameter("guess"); // �ͻ����ύ��guess����
		if (guess != null && !guess.equals("")) {
			bean.setGuess(guess); // ����ģ���ṩ���жϹ���
		}
		// ģ�͹��ܵ�����Ϻ󣬿�ʼ����ҳ��������䵱VIEW��CONTROLLER
		if (bean.getSuccess()) {
			out.println(" Congratulations!  You got it.");
			out.println("And after just " + bean.getNumGuesses()
					+ "  tries.<p>");
			bean.reset();
			out.println("Care to <a href=\"NumberGuessServlet\">try again</a>?");
		} else if (bean.getNumGuesses() == 0) {
			out.println("Welcome to the Number Guess game.<p>");
			out.println("I'm thinking of a number between 1 and 100.<p>");
			out.println("<form method=get>What's your guess? ");
			out.println("<input type=\"text\" name=\"guess\"/>");
			out.println("<input type=\"submit\" value=\"Submit\"></form>");
		} else {
			out.println(" Good guess, but nope.  Try <b>" + bean.getHint()
					+ "</b>.");
			out.println("You have made " + bean.getNumGuesses()
					+ " guesses.<p>");
			out.println("I'm thinking of a number between 1 and 100.<p>");
			out.println("<form method=get>What's your guess? ");
			out.println("<input type=\"text\" name=\"guess\"/>");
			out.println("<input type=submit value=\"Submit\"></form>");
		}
		out.println("</font></body></html>");
	}
}
