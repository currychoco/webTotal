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

int custno = Integer.parseInt(request.getParameter("custno")); 
String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String grade = request.getParameter("grade");
String city = request.getParameter("city");

if(grade.equals("VIP")){
	grade = "A";
}else if(grade.equals("일반")){
	grade = "B";
}else{
	grade = "C";
}

MemberDao memberDao = MemberDao.getInstance();
boolean set = memberDao.setMember(custno, custname, phone, address, grade, city);

if(set){
	response.sendRedirect("list.jsp");
}else{
	response.sendRedirect("list.jsp");
}
%>
</body>
</html>