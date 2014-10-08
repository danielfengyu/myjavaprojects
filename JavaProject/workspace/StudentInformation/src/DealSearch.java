

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Element;

import com.jsp.Operate;

/**
 * Servlet implementation class DealSearch
 */
@WebServlet("/DealSearch")
public class DealSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealSearch() {
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
		String serachName = request.getParameter("searchname");
		
		HttpSession session = request.getSession();
		Operate student  = (Operate) session.getAttribute("student");
		List list = new ArrayList();
		
		//读取并输出所要搜索的学生的全部信息
		list = student.readElement(serachName);
		int i = 0;
		for(;i < list.size(); i++)
		{
			Element e = (Element) list.get(i);
			out.println(e.element("id").getText());
			out.println(e.element("name").getText());
			out.println(e.element("age").getText());
			out.println(e.element("gender").getText());
			out.println(e.element("email").getText());
			out.println(e.element("java").getText());
		}
		if(i == 0)
			out.println("该学生不存在！");
	}

}
