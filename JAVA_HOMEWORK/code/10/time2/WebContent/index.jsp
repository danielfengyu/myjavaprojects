<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://www.abc.com/ns/mytags" prefix="t"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show time</title>
</head>
<body>
	<p>
		<%-- �˴��ṩ�˽ű����������ƺ�����  --%>
		<t:time color="red" format="yyyy-MM-dd HH:mm:ss" var="d"
			type="java.util.Date" />
	<p>
		<%-- ���ʸýű������������ֵ --%>
		<%= d %>  
		
		<%-- ����ű��������������ʾ��������Preferences->Validation->JSP Syntax Validation�н���֤��ѡ������������֤����Ժ��Ե���������� --%>
</body>
</html>
</html>