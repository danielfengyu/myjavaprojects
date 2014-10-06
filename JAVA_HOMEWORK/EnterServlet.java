
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet(urlPatterns = { "/enter", "/enterparent" })
	public class EnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			File current = (File) session.getAttribute("current");
			if (current == null) {
				current = new File(ListServlet.SHARE_DIR);
				session.setAttribute("current", current);
			}

			File root = new File(ListServlet.SHARE_DIR);

			String url = request.getRequestURL().toString();
			if (url.endsWith("enterparent")) {
				if (!current.equals(root)) {
					session.setAttribute("current", current.getParentFile());
				} else {
					session.setAttribute("current", root);
				}
				request.getRequestDispatcher("/list").forward(request, response);
				return;
			}

		String dir = request.getParameter("dir");
		if (dir == null) {
			dir = "";
		}
		dir = new String(dir.getBytes("ISO-8859-1"), "GBK"); // URIEncoding=GBK
		if (dir.length() == 0) {
			session.setAttribute("current", root);
			request.getRequestDispatcher("/list").forward(request, response);
			return;
		}

		File f = new File(current, dir);
		if (f.isDirectory()) {
			session.setAttribute("current", f);
		} else {
			session.setAttribute("current", root);
		}
		request.getRequestDispatcher("/list").forward(request, response);
	}
	}
	
