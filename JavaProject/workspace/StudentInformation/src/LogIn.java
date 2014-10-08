

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,String> map;   
    DataInputStream dis = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
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
		
        //����һ���û����������ӳ��
        map = new HashMap<String,String>();
        try {
			dis = new DataInputStream(new FileInputStream("E:\\J2EE��ҵ\\StudentInformation\\WebContent\\WEB-INF\\user.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //��ȡ�Ѵ����û�����Ϣ������ӳ��
        String s;
		try {
			while(( s = dis.readLine()) != null)
			{
				String[] sc = s.split(",");
				sc[0] = sc[0].trim();
				sc[1] = sc[1].trim();
				map.put(sc[0], sc[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset = GB2312");
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter pt = response.getWriter();
		
		//�ж��û�����ĺϷ���
		if(username.equals(""))
		{
			pt.println("�û�������Ϊ�գ�");
			return ;
		}
		if(password.equals(""))
		{
			pt.println("���벻��Ϊ�գ�");
			return ;
		}
		if ((map.get(username)) != null)
		{
			if (map.get(username).equals(password)) 
			{
				//ƥ������ù�����ʹ֮ͨ������תҳ��
				session.setAttribute("login", "true");
				dis.close();
				request.getRequestDispatcher("/StudentPage.jsp").forward(request, response);
			
			} 
			else 
			{
				pt.println("�û������ڣ�");
			}
		} 
		else 
		{
			pt.println("�û������ڣ�");
			
		}
		
	}

}
