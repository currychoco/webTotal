<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

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
	request.setCharacterEncoding("utf-8");

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	int custno = Integer.parseInt(request.getParameter("custno"));
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	
	MemberDao dao = MemberDao.getInstance();
	dao.updateMember(new MemberDto(custno, custname, phone, address, joindate, grade, city));
	
	response.sendRedirect("updateMember.jsp?custno=" + custno);
%>
</body>
</html>