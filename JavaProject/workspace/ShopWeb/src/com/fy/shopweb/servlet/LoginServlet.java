package com.fy.shopweb.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import com.fy.shopweb.bean.*;
import com.fy.shopweb.shopcart.ShoppingCart;

import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 11;
	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	private   ServletContext sc=null;
	
	//Initialize 
	public void init() throws ServletException {
		super.init();
		sc=this.getServletContext();
	}
	//Process the HTTP Get request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String varname = request.getParameter("usename");
		String varpassword = request.getParameter("password");
		String reg = request.getParameter("Submit2");
		if(reg !=null){
			response.sendRedirect("register.jsp");
			return;
		}
		String register = request.getParameter("register");
		if(register!=null){
			doRegister(request, response);
			return;
		}
		boolean succ=false;
		Customer cu=new Customer();
		try {
			succ = cu.login(varname,varpassword);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
				succ = cu.login(varname,varpassword);
			}catch (SQLException ex) {
				ex.getErrorCode();
			}*/
		String username=varname;
		if(succ){
		       
			this.doBrowse(request, response);
		    HttpSession mysession = request.getSession(false);
		    ShoppingCart mycart = new ShoppingCart();
		    mysession.setAttribute(username,mycart);
		    mysession.setAttribute("username",username);   
		}
		else{
		       this.doError(request, response);
		}
		return;
	 }
	//Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
  
	private void doBrowse(HttpServletRequest request, HttpServletResponse response) throws
     ServletException, IOException
	{
		RequestDispatcher rd=sc.getRequestDispatcher("/querybook.jsp");
		rd.forward(request,response);
	}

	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		Customer cust = new Customer();
		cust.setUser(request.getParameter("username"));
		cust.setPassword(request.getParameter("password"));
		cust.setName(request.getParameter("name"));
		cust.setTitle(request.getParameter("title"));
		cust.setEmail(request.getParameter("email"));
		try {
			cust.saveInfo();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		RequestDispatcher rd=sc.getRequestDispatcher("/login.jsp");
		rd.forward(request,response);
	}
	private void doBrowseErr(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		RequestDispatcher rd=sc.getRequestDispatcher("/login.jsp");
		rd.forward(request,response);
	}

	private void doError(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException
	{
		request.setAttribute("error","name or password error!");
		this.doBrowseErr(request, response);
	}
	//Clean up resources
	public void destroy() {}
}


