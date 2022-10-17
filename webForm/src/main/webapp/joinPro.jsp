<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Controller -->

<!-- JSP 내장객체  중 -->
<!-- 1)Request -->
<!-- 2) Response -->
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String id = request.getParameter("id");
String password = request.getParameter("password");

UserDao userDao = UserDao.getInstance();
boolean add = userDao.addUser(name, id, password);
if(add){
	response.sendRedirect("login.jsp");
}else{
	response.sendRedirect("join.jsp");
}
%>


hello
</body>
</html>