package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.accp.gz.th.zm.server.entity.*;
import com.accp.gz.th.zm.server.action.*;

public final class GoodsList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html;charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      com.accp.gz.th.zm.client.javabean.PageBean pageBean = null;
      synchronized (session) {
        pageBean = (com.accp.gz.th.zm.client.javabean.PageBean) _jspx_page_context.getAttribute("pageBean", PageContext.SESSION_SCOPE);
        if (pageBean == null){
          pageBean = new com.accp.gz.th.zm.client.javabean.PageBean();
          _jspx_page_context.setAttribute("pageBean", pageBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      out.write('\n');

  //if (request.getParameter("querySql") != null) {
  //  pageBean.setQuerySql(request.getParameter("querySql"));
  //}
  if(request.getParameter("typeId") != null) {
    pageBean.setQuerySql("select * from Goods where TID="+request.getParameter("typeId"));
  }

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

  if (request.getParameter("jumpPage") != null) {
    pageBean.setQueryPageNo(Integer.parseInt(request.getParameter("jumpPage")));
  }
  else {
    pageBean.setQueryPageNo(1);
  }

      out.write('\n');
      out.write('\n');
  ArrayList list=pageBean.getResultDataVec(); 
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n<script language=\"JavaScript\" type=\"\">\n<!--\n");
      out.write("\nfunction gotoPage(pageNo){\n  document.GoodsForm.jumpPage.value = pageNo;  // 设置下拉框的页号\n  document.GoodsForm.submit();  // 提交表单\n}\n");
      out.write("\nfunction jumping(){\n  document.GoodsForm.submit();  // 提交表单\n}\n//-->\n</script>\n\n\n<html>\n  <head>\n  </head>\n  <body>\n    <form name=\"GoodsForm\" id=\"GoodsForm\" action=\"GoodsList.jsp\">\n    <table border=\"1\">\n      <tr>\n        <th>编号</th>\n        <th>名称</th>\n        <th>单价</th>\n        <th>库存</th>\n      </tr>\n\n      ");

      for(int i=0; i<list.size(); i++)
      {
        Goods g = (Goods)list.get(i);
        out.println("<tr>");
        out.println("<th>"+g.getId()+"</th>");
        out.println("<th>"+g.getName()+"</th>");
        out.println("<th>"+g.getPrice()+"</th>");
        out.println("<th>"+g.getNumber()+"</th>");
        out.println("</tr>");
      }
      
      out.write("\n      ");
      out.write("\n      <tr>\n      <td align=\"center\" colspan=4>\n        每页");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.accp.gz.th.zm.client.javabean.PageBean)_jspx_page_context.findAttribute("pageBean")).getRowsPerPage())));
      out.write("行\n        &nbsp;&nbsp;&nbsp;&nbsp;\n        共");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.accp.gz.th.zm.client.javabean.PageBean)_jspx_page_context.findAttribute("pageBean")).getTotalRows())));
      out.write("行\n        &nbsp;&nbsp;&nbsp;&nbsp;\n        第");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.accp.gz.th.zm.client.javabean.PageBean)_jspx_page_context.findAttribute("pageBean")).getQueryPageNo())));
      out.write('/');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.accp.gz.th.zm.client.javabean.PageBean)_jspx_page_context.findAttribute("pageBean")).getTotalPage())));
      out.write("页\n        &nbsp;&nbsp;&nbsp;&nbsp;\n\n        ");
 if(pageBean.queryPageNo<=1){
      out.write("\n          首页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;\n        ");
      out.write("\n        ");
}else{
      out.write("\n          <a href=\"javascript:gotoPage(1)\">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;\n          <a href=\"javascript:gotoPage(");
      out.print(pageBean.getQueryPageNo()-1);
      out.write(")\">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;\n        ");
}
      out.write("\n\n        ");
 if(pageBean.queryPageNo>=pageBean.totalPage){
      out.write("\n          下一页&nbsp;&nbsp;&nbsp;&nbsp;尾页&nbsp;&nbsp;&nbsp;&nbsp;\n        ");
}else{
      out.write("\n        ");
      out.write("\n          <a href=\"GoodsList.jsp?jumpPage=");
      out.print(pageBean.getQueryPageNo()+1);
      out.write("\">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;\n          <a href=\"GoodsList.jsp?jumpPage=");
      out.print(pageBean.getTotalPage());
      out.write("\">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;\n        ");
}
      out.write("\n\n        转到第\n        <select id=\"jumpPage\" name=\"jumpPage\" onchange=\"jumping()\">\n            ");

            for(int i=1; i<=pageBean.getTotalPage(); i++){
            if(i==pageBean.getQueryPageNo()){
      out.write("\n              <option selected value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n            ");
}
            else{ 
      out.write("\n              <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n            ");
} }
      out.write("\n        </select>\n        页\n      </td>\n    </tr>\n\n    </table>\n    </form>\n  </body>\n</html>\n");
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
