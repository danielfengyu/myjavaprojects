<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
</head>
<body bgcolor="#ffffff">
<h1>
欢迎来到网上书店！
</h1>
<% String value = (String)request.getAttribute("error");
   if(value!=null){
   	out.println("错误提示信息"+value);
     }
%>
<form action="login" method="post" >
<br><br>
用户名 <input type="text" name="usename" ><br>
 密码 <input type="password"name="password"><br>
<input type="submit" name="Submit1" value="登录">
<input type="submit" name="Submit2" value="注册">
</form>
</body>
</html>