<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String grade = request.getParameter("grade");
String city = request.getParameter("city");

MemberDao memberDao = MemberDao.getInstance();
boolean add = memberDao.addMember(custname, phone, address, grade, city);

if(add){
	response.sendRedirect("login.jsp");
}else{
	response.sendRedirect("join.jsp");
}
%>
</body>
</html>