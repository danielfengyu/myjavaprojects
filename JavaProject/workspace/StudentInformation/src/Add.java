
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Operate;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset = GB2312");
		
		//获取所要增加的学生信息
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String java = request.getParameter("java");
		
		//对字符串进行转换
		id = new String(id.getBytes("ISO-8859-1"), "gb2312");
		name = new String(name.getBytes("ISO-8859-1"), "gb2312");
		age = new String(age.getBytes("ISO-8859-1"), "gb2312");
		gender = new String(gender.getBytes("ISO-8859-1"), "gb2312");
		email = new String(email.getBytes("ISO-8859-1"), "gb2312");
		java = new String(java.getBytes("ISO-8859-1"), "gb2312");
		
		//调用增加学生信息函数
		HttpSession session = request.getSession();
		Operate student  = (Operate) session.getAttribute("student");
		student.addElement(id, name, age, gender, email, java);
		request.getRequestDispatcher("/StudentPage.jsp").forward(request, response);
	}

}
