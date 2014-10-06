//package com.abc.dl.servlets;
import java.io.*;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//import com.sun.xml.internal.fastinfoset.sax.Properties;
@WebServlet("/list")
public class ListServlet extends HttpServlet{
	/**
	 * Servlet implementation class ListServlet
	 */
		private static final long serialVersionUID = 1L;
		public static String SHARE_DIR ;//= "D:/NET";
	       
		
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ListServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	        BufferedInputStream in = null;
			try {
				in = new BufferedInputStream(new FileInputStream("E:/J2EE/dl/WebContent/WEB-INF/share.properties"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return ;
			}
	        Properties p = new Properties();
	        try {
				p.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        SHARE_DIR = p.getProperty("share");
	        //System.out.println(SHARE_DIR);
	        System.out.println();
	    }
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(request,response);
		}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset = GB2312");
		PrintWriter out=response.getWriter();
		/**InputStream in=null;
		*FileInputStream fis = new FileInputStream("E:/J2EE/dl/WebContent/WEB-INF/share.properties");
		*InputStreamReader isr = new InputStreamReader(fis, "GBK");
		*BufferedReader br = new BufferedReader(isr);
		*SHARE_DIR=br.readLine();
		*/
	HttpSession session = request.getSession();
	File current = (File) session.getAttribute("current");
	if (current == null) {
		current = new File(ListServlet.SHARE_DIR);
		session.setAttribute("current", current);
	}

	File[] children = current.listFiles();
	File root = new File(ListServlet.SHARE_DIR);
	
	
		out.println("<p>");
		String st=ListServlet.SHARE_DIR;
	if (children.length > 0) {
		
		out.println("<table border=1><tr><th style=\"width: 280px\">文件名称</th><th>文件大小</th><th>操作</th></tr>");
		for (int i = 0; i < children.length; i++) {
			//out.println(st);
			String url = children[i].getName();
			st=children[i].getName();
			String url5 = "enterparent?"
					+ java.net.URLEncoder.encode(url, "GBK");
			out.print("<tr><td>" +children[i].getParent()
					+ "</td><td>父目录</td><td><a href=\"" + url5
					+ "\">返回</a></td></tr>");
			st=children[i].getParent();
			//out.println(st);
			if (children[i].isFile()) {
				String url2 = "download?file="
						+ java.net.URLEncoder.encode(url, "GBK");
				//st=;
				String url3 = "delete?file="
						+ java.net.URLEncoder.encode(url, "GBK");
				//st=url3;
				out.print("<tr><td><a href=" + url2 + ">"
						+ children[i].getName() + "</a></td><td>"
						+ children[i].length() + "</td><td><a href=\""
						+ url3 + "\">删除</a></td></tr>");
				
			} else {
				String url4 = "enter?dir="
						+ java.net.URLEncoder.encode(url, "GBK");
				st=children[i].getName();
				//out.println( st);
				out.print("<tr><td>" + children[i].getName()
						+ "</td><td>子目录</td><td><a href=\"" + url4
						+ "\">进入</a></td></tr>");
			}
			
		}
		out.println("</table>");
	} else {
		out.println("该目录下没有任何文件.");
	}
	out.println(st);
	out.println("<p>");
	out.println("<form action=\"upload\" method=\"post\"  enctype=\"multipart/form-data\">");
	out.println("<input type=\"file\" name=\"tfile\" size=\"30\" />");
	out.println("<input type=\"submit\"	value=\"上传文件\" />");
	out.println("</form>");


	}
}
