<%@page import="member.MemberDto"%>
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
MemberDao memberDao = MemberDao.getInstance();

request.setCharacterEncoding("utf-8");

int custno = Integer.parseInt(request.getParameter("custno"));
MemberDto member = memberDao.getMember(custno);

String custname=request.getParameter("custname");
if(custname != null){
	member.setCustname(custname);
}

String phone=request.getParameter("phone");
if(phone != null){
	member.setPhone(phone);
}

String address = request.getParameter("address");
if(address != null){
	member.setAddress(address);
}

String grade = request.getParameter("grade");
member.setGrade(grade);

String city = request.getParameter("city");
if(city != null){
	member.setCity(city);
}

memberDao.setMember(custno, member);
response.sendRedirect("list.jsp");
%>
</body>
</html>