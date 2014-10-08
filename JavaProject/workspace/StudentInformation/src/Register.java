
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    DataInputStream dis = null;
    DataOutputStream dos = null;   
    /**
     * @throws FileNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public Register() throws FileNotFoundException {
        super();
        
        dis = new DataInputStream(new FileInputStream("E:\\J2EE作业\\StudentInformation\\WebContent\\WEB-INF\\user.txt"));
        
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
		
		dos = new DataOutputStream(new FileOutputStream("E:\\J2EE作业\\StudentInformation\\WebContent\\WEB-INF\\user.txt",true));
		PrintWriter out = new PrintWriter(dos);
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		if(username.equals("")||password1.equals("")||password2.equals(""))
		{
			pw.println("输入不能为空！");
			return;
		}
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\J2EE作业\\StudentInformation\\WebContent\\WEB-INF\\user.txt",true));
		
		//标记新注册用户是否已经存在
		boolean flag = false;
		
		String s;
		while(( s = dis.readLine()) != null)
		{
			String[] sc = s.split(",");
			sc[0] = sc[0].trim();
			sc[1] = sc[1].trim();
			
			if(sc[0].equals(username))
			{
				//用户已存在则跳出
				flag = true;
				break;
			}
		}
		
		//新建用户
		if(!flag)
		{
			if(password1.equals(password2))
			{
				String newUser = username + "," + password1;
				out.println(newUser);
				out.close();
				
				request.getRequestDispatcher("/LogIn.html").forward(request, response);
			}
			else
			{
				pw.println("请重新输入密码！");
			}
			
		}
		else if(flag)
		{
			pw.println("此用户已存在！");
		}
	}

}
