<%@page import="java.util.*,com.accp.gz.th.zm.server.entity.*,com.accp.gz.th.zm.server.action.*"
        contentType="text/html;charset=GBK" %>
<%--
    response.setCharacterEncoding("GBK");
    ArrayList list=BusinessDelegate.select();
--%>
<%-------------------------- 分页JavaBean的初始化 -----------------------------%>

<%-- 1、获得PageBean的实例pageBean --%>
<jsp:useBean id="pageBean" scope="session"
  class="com.accp.gz.th.zm.client.javabean.PageBean"/>

<%-- 2、为pageBean设置查询字符串 --%>
<%
  //if (request.getParameter("querySql") != null) {
  //  pageBean.setQuerySql(request.getParameter("querySql"));
  //}
  if(request.getParameter("typeId") != null) {
    pageBean.setQuerySql("select * from Goods where TID="+request.getParameter("typeId"));
  }
%>
<%--  在每张表的 DAO 中已经设置了默认的查询语句（查询全部记录）
  else {
    pageBean.setQuerySql("select * from Employee");
  }
--%>

<%-- 3、为pageBean设置查询的页号 --%>
<%
  if (request.getParameter("jumpPage") != null) {
    pageBean.setQueryPageNo(Integer.parseInt(request.getParameter("jumpPage")));
  }
  else {
    pageBean.setQueryPageNo(1);
  }
%>
<%-------------------------- 利用分页JavaBean获得数据 -----------------------------%>
<%  ArrayList list=pageBean.getResultDataVec(); %>


<%---------------------------- JavaScript脚本 --------------------------------%>
<script language="JavaScript" type="">
<!--
<%-- 1、根据页号进行跳转 --%>
function gotoPage(pageNo){
  document.GoodsForm.jumpPage.value = pageNo;  // 设置下拉框的页号
  document.GoodsForm.submit();  // 提交表单
}
<%-- 2、根据下拉框选择进行跳转 --%>
function jumping(){
  document.GoodsForm.submit();  // 提交表单
}
//-->
</script>


<html>
  <head>
  </head>
  <body>
    <form name="GoodsForm" id="GoodsForm" action="GoodsList.jsp">
    <table border="1">
      <tr>
        <th>编号</th>
        <th>名称</th>
        <th>单价</th>
        <th>库存</th>
      </tr>

      <%
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
      %>
      <%-- “首页、上一页、下一页、尾页、跳转到”等链接 --%>
      <tr>
      <td align="center" colspan=4>
        每页<jsp:getProperty name="pageBean" property="rowsPerPage"/>行
        &nbsp;&nbsp;&nbsp;&nbsp;
        共<jsp:getProperty name="pageBean" property="totalRows"/>行
        &nbsp;&nbsp;&nbsp;&nbsp;
        第<jsp:getProperty name="pageBean" property="queryPageNo"/>/<jsp:getProperty name="pageBean" property="totalPage"/>页
        &nbsp;&nbsp;&nbsp;&nbsp;

        <% if(pageBean.queryPageNo<=1){%>
          首页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
        <%-- 利用JavaScript进行超链接的表单提交 --%>
        <%}else{%>
          <a href="javascript:gotoPage(1)">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="javascript:gotoPage(<%=pageBean.getQueryPageNo()-1%>)">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>

        <% if(pageBean.queryPageNo>=pageBean.totalPage){%>
          下一页&nbsp;&nbsp;&nbsp;&nbsp;尾页&nbsp;&nbsp;&nbsp;&nbsp;
        <%}else{%>
        <%-- 利用URL重写进行超链接的表单提交 --%>
          <a href="GoodsList.jsp?jumpPage=<%=pageBean.getQueryPageNo()+1%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="GoodsList.jsp?jumpPage=<%=pageBean.getTotalPage()%>">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>

        转到第
        <select id="jumpPage" name="jumpPage" onchange="jumping()">
            <%
            for(int i=1; i<=pageBean.getTotalPage(); i++){
            if(i==pageBean.getQueryPageNo()){%>
              <option selected value="<%=i%>"><%=i%></option>
            <%}
            else{ %>
              <option value="<%=i%>"><%=i%></option>
            <%} }%>
        </select>
        页
      </td>
    </tr>

    </table>
    </form>
  </body>
</html>
