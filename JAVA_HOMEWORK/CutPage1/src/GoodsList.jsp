<%@page import="java.util.*,com.accp.gz.th.zm.server.entity.*,com.accp.gz.th.zm.server.action.*"
        contentType="text/html;charset=GBK" %>
<%--
    response.setCharacterEncoding("GBK");
    ArrayList list=BusinessDelegate.select();
--%>
<%-------------------------- ��ҳJavaBean�ĳ�ʼ�� -----------------------------%>

<%-- 1�����PageBean��ʵ��pageBean --%>
<jsp:useBean id="pageBean" scope="session"
  class="com.accp.gz.th.zm.client.javabean.PageBean"/>

<%-- 2��ΪpageBean���ò�ѯ�ַ��� --%>
<%
  //if (request.getParameter("querySql") != null) {
  //  pageBean.setQuerySql(request.getParameter("querySql"));
  //}
  if(request.getParameter("typeId") != null) {
    pageBean.setQuerySql("select * from Goods where TID="+request.getParameter("typeId"));
  }
%>
<%--  ��ÿ�ű�� DAO ���Ѿ�������Ĭ�ϵĲ�ѯ��䣨��ѯȫ����¼��
  else {
    pageBean.setQuerySql("select * from Employee");
  }
--%>

<%-- 3��ΪpageBean���ò�ѯ��ҳ�� --%>
<%
  if (request.getParameter("jumpPage") != null) {
    pageBean.setQueryPageNo(Integer.parseInt(request.getParameter("jumpPage")));
  }
  else {
    pageBean.setQueryPageNo(1);
  }
%>
<%-------------------------- ���÷�ҳJavaBean������� -----------------------------%>
<%  ArrayList list=pageBean.getResultDataVec(); %>


<%---------------------------- JavaScript�ű� --------------------------------%>
<script language="JavaScript" type="">
<!--
<%-- 1������ҳ�Ž�����ת --%>
function gotoPage(pageNo){
  document.GoodsForm.jumpPage.value = pageNo;  // �����������ҳ��
  document.GoodsForm.submit();  // �ύ��
}
<%-- 2������������ѡ�������ת --%>
function jumping(){
  document.GoodsForm.submit();  // �ύ��
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
        <th>���</th>
        <th>����</th>
        <th>����</th>
        <th>���</th>
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
      <%-- ����ҳ����һҳ����һҳ��βҳ����ת���������� --%>
      <tr>
      <td align="center" colspan=4>
        ÿҳ<jsp:getProperty name="pageBean" property="rowsPerPage"/>��
        &nbsp;&nbsp;&nbsp;&nbsp;
        ��<jsp:getProperty name="pageBean" property="totalRows"/>��
        &nbsp;&nbsp;&nbsp;&nbsp;
        ��<jsp:getProperty name="pageBean" property="queryPageNo"/>/<jsp:getProperty name="pageBean" property="totalPage"/>ҳ
        &nbsp;&nbsp;&nbsp;&nbsp;

        <% if(pageBean.queryPageNo<=1){%>
          ��ҳ&nbsp;&nbsp;&nbsp;&nbsp;��һҳ&nbsp;&nbsp;&nbsp;&nbsp;
        <%-- ����JavaScript���г����ӵı��ύ --%>
        <%}else{%>
          <a href="javascript:gotoPage(1)">��ҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="javascript:gotoPage(<%=pageBean.getQueryPageNo()-1%>)">��һҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>

        <% if(pageBean.queryPageNo>=pageBean.totalPage){%>
          ��һҳ&nbsp;&nbsp;&nbsp;&nbsp;βҳ&nbsp;&nbsp;&nbsp;&nbsp;
        <%}else{%>
        <%-- ����URL��д���г����ӵı��ύ --%>
          <a href="GoodsList.jsp?jumpPage=<%=pageBean.getQueryPageNo()+1%>">��һҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="GoodsList.jsp?jumpPage=<%=pageBean.getTotalPage()%>">βҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <%}%>

        ת����
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
        ҳ
      </td>
    </tr>

    </table>
    </form>
  </body>
</html>
