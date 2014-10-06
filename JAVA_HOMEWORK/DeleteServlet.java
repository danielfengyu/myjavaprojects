
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String filename = request.getParameter("file");
		filename = new String(filename.getBytes("ISO-8859-1"),"GBK");  //URIEncoding=GBK
		
		HttpSession session = request.getSession();
		File current = (File) session.getAttribute("current");
		if (current == null) {
			current = new File(ListServlet.SHARE_DIR);
			session.setAttribute("current", current);
		}
		File f = new File(current, filename);
		f.delete();
		request.getRequestDispatcher("/list").forward(request,response);
	}
}
