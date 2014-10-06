<%@ page contentType="text/html; charset=GBK"
import="java.util.*"
import="com.accp.gz.th.zm.server.action.*"
import="com.accp.gz.th.zm.server.dao.*"
import="com.accp.gz.th.zm.server.entity.*"
%>

<% ArrayList list =BusinessDelegate.selectType(); %>
<html>
  <head>
    <title>商品类型</title>
  </head>
  <body bgcolor="#ffffff">
    <%--
        for(int i=0; i<list.size(); i++){
          GoodsType gt=(GoodsType)list.get(i);
          out.println(gt.getName().toString()+"<br>");
        }
    --%>
    <%
        for(int i=0; i<list.size(); i++){
          GoodsType gt=(GoodsType)list.get(i);
          int id=gt.getId();
          String name=gt.getName();
    %>
          <a href="GoodsList.jsp?typeId=<%=id%>" target='right'><%=name%></a><br>
    <%  }   %>

  </body>
</html>
