<%@ page import="java.util.*,mytags.*" pageEncoding="GBK" %>
<%@ taglib uri="http://www.abc.com/ns/mytags" prefix="it"%>

<HTML>
<HEAD>
<TITLE>Iteration Tag Example</TITLE>
</HEAD>
<BODY BGCOLOR="#FFFFFF">
	<%-- Ϊ����ʾ���򣬴�����һ�����ϣ������3������Ԫ�ء�--%>
	<%
		Vector students = new Vector();
		students.add(new Student("001", "zs", 19));
		students.add(new Student("002", "ls", 20));
		students.add(new Student("003", "ww", 19));
	%>

	<table border="1">
		<tr>
			<th align="center">ID</th>
			<th align="center">Name</th>
			<th aligh="center">Age</th>
		</tr>
		<it:iterator var="student" type="mytags.Student"
			list="<%=students%>">
			<tr>
				<%--����û��ʹ��jsp:useBean���������Student Bean����--%>
				<%--�������Զ���ű�������ʽ������һ��Student Bean����--%>
				<td><jsp:getProperty name="student" property="id" /></td>
				<td><jsp:getProperty name="student" property="name" /></td>
				<td><jsp:getProperty name="student" property="age" /></td>
			</tr>
		</it:iterator>
	</table>
</BODY>
</HTML>
