<%@ page language="java" contentType="text/html; charset=GB2312"
     import = "com.jsp.Operate, org.dom4j.*,java.util.Iterator,java.util.List;"%>
<%@taglib uri="/WEB-INF/time.tld" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ѧ����Ϣ</title>
</head>
<body bgcolor = "#FFF8DC">
��½ʱ�䣺<t:time color="red" format="yyyy-MM-dd HH:mm:ss" />
<br>
<%

String num = request.getParameter("page1");
if(num == null)
	num = "0";
int page1 = Integer.valueOf(num);
Operate student = new Operate(page1);
session.setAttribute("student", student);
Element root = student.getRoot();
	
%>

<table  border="1">
	<tr>
	<td width = "30%">ѧ��</td><td>����</td><td>����</td><td>�Ա�</td><td width = "30%">����</td><td>java�ɼ�</td>
	</tr>
	<% List studentlist = root.elements("student");%>
	<%for(int i = student.getCurrentPage()*student.getMaxRowNum(); (i < student.getSize() && i < (student.getCurrentPage()+1)*student.getMaxRowNum()); i++) {%>
	<% Element curr = (Element)studentlist.get(i); %>
	<% List attributes = curr.elements();  
    	Element e1 = (Element) attributes.get(0); 
    	Element e2 = (Element) attributes.get(1); 
    	Element e3 = (Element) attributes.get(2); 
    	Element e4 = (Element) attributes.get(3); 
    	Element e5 = (Element) attributes.get(4); 
    	Element e6 = (Element) attributes.get(5); 
    %>
    <tr>
	<td><%= e1.getText() %></td>
	<td><%= e2.getText() %></td>
	<td><%= e3.getText() %></td>
	<td><%= e4.getText() %></td>
	<td><%= e5.getText() %></td>
	<td><%= e6.getText() %></td>
	</tr>
	<%} %>
	</table>
	<a href = "StudentPage.jsp?page1 =0">��ҳ</a>
	<%if(student.getCurrentPage() > 0) {%>
	<a href = "StudentPage.jsp?page1=<%= student.getCurrentPage()-1 %>" >��һҳ</a>
	<%} %>
	<% if(student.getCurrentPage() < (student.getTotalPages()-1)){ %>
	<a href = "StudentPage.jsp?page1=<%= student.getCurrentPage()+ 1 %>">��һҳ</a>
	<%} %>
	<a href = "StudentPage.jsp?page1=<%= student.getTotalPages()-1 %>" >ĩҳ</a>
	<br>
	<form action ="/StudentInformation/Search.html" method = "post"><button>����</button> </form>
	<form action ="/StudentInformation/Delete.html" method = "post"><button>ɾ��</button> </form>
	<form action ="/StudentInformation/Add.html" method = "post"><button>����</button> </form>
	<form action ="/StudentInformation/Update.html" method = "post"><button>�޸�</button> </form>
</body>
</html>