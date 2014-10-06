//package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
//import com.accp.gz.th.zm.server.action.*;
//import com.accp.gz.th.zm.server.dao.*;
//import com.accp.gz.th.zm.server.entity.*;

public final class TypeList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 ArrayList list;
  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');
 list =BusinessDelegate.selectType(); 
      out.write("\r\n<html>\r\n  <head>\r\n    <title>商品类型</title>\r\n  </head>\r\n  <body bgcolor=\"#ffffff\">\r\n    ");
      out.write("\r\n    ");

        for(int i=0; i<list.size(); i++){
          GoodsType gt=(GoodsType)list.get(i);
          int id=gt.getId();
          String name=gt.getName();
      out.write("\r\n          <a href=\"GoodsList.jsp?typeId=");
      out.print(id);
      out.write("\" target='right'>");
      out.print(name);
      out.write("</a><br>\r\n    ");
  }
    
      out.write("\r\n  </body>\r\n</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
