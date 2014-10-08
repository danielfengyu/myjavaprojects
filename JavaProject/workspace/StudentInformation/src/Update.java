

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Operate;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String newContent = request.getParameter("newContent");

		id = new String(id.getBytes("ISO-8859-1"), "gb2312");
		num = new String(num.getBytes("ISO-8859-1"), "gb2312");
		newContent = new String(newContent.getBytes("ISO-8859-1"), "gb2312");
		if(num.equals("0") || num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4") || num.equals("5"))
		{
			HttpSession session = request.getSession();
			Operate student  = (Operate) session.getAttribute("student");
			
			//更新信息并跳转页面
			if(student.updateElement(id, num, newContent))
				request.getRequestDispatcher("/StudentPage.jsp").forward(request, response);
			else
				out.println("更新失败，此学生不存在！");
		}
		else
			out.println("请返回重新选择要修改的属性！（0-5）");
	}

}
