package fengyu.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Jdbc
 */
@WebServlet("/Jdbc")
public class Jdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jdbc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
		String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JDBCTest" ;//连接字符串
		String username="sa";//用户名
		String password="dayingfengyu";//密码搜索
		try{
			response.setContentType("text/html;charset=gb2312");
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			System.out.println("hhhjj");
			Class.forName(JDriver);
			Connection cn=DriverManager.getConnection(connectDB, username, password);
			PreparedStatement ps=cn.prepareStatement("select * from LoginTable where username=fy and password=1233");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs= ps.executeQuery();
			if(rs.next()){
				response.getWriter().println("欢迎");
				cn.close();
			}else{
				response.getWriter().println("验证失败");
			}
		}catch(Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
		String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JDBCTest" ;//连接字符串
		String username="sa";//用户名
		String password="dayingfengyu";//密码搜索
		try{
			response.setContentType("text/html;charset=gb2312");
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			System.out.println("hhhjj");
			Class.forName(JDriver);
			Connection cn=DriverManager.getConnection(connectDB, username, password);
			PreparedStatement ps=cn.prepareStatement("select * from LoginTable where username=fy and password=1233");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs= ps.executeQuery();
			if(rs.next()){
				response.getWriter().println("欢迎");
				cn.close();
			}else{
				response.getWriter().println("验证失败");
			}
		}catch(Exception e){}
	}

}
