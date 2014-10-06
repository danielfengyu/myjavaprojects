<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://www.abc.com/ns/mytags" prefix="t"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show time</title>
</head>
<body>
	<%-- 在JSP程序中，通过属性向标记处理器对象传递数据  --%>
	<t:time color="red" format="yyyy-MM-dd HH:mm:ss" />
	<br>
	<%--没有传递color属性，这是可以的，因为color属性不是必须的属性--%>
	<t:time format="yy-MM-dd" />
</body>
</html>
