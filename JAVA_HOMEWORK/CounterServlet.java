package Ch_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public static final String CONTENT_TYPE="text/html;sharset=GB2312";
    public void init(ServletConfig config)throws ServletException{
    	super.init(config);
    }
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context=getServletContext();
		Integer count=(Integer)context.getAttribute("count");
		if(count==null){
				count=new Integer(0);
				context.setAttribute("count", new Integer(0));
		}
		response.setContentType(CONTENT_TYPE);
		PrintWriter out=response.getWriter();
		out.println ("<html>");
		out.println("<head><title>点击数</title></head>");
		out.println ("<body>");
		out.println("<p>当前计数是："+count+"</p>");
		out.println("</body></html>");
		count=new Integer(count.intValue()+1);
		context.setAttribute("count", count);
	}
	public void desdroy(){
		
	}

}
