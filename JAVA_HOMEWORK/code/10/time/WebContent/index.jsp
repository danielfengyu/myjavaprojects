<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://www.abc.com/ns/mytags" prefix="t"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show time</title>
</head>
<body>
	<%-- ��JSP�����У�ͨ���������Ǵ��������󴫵�����  --%>
	<t:time color="red" format="yyyy-MM-dd HH:mm:ss" />
	<br>
	<%--û�д���color���ԣ����ǿ��Եģ���Ϊcolor���Բ��Ǳ��������--%>
	<t:time format="yy-MM-dd" />
</body>
</html>
