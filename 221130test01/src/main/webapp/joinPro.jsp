<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
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
		MemberDto member = null;
		
		request.setCharacterEncoding("utf-8");
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindateStr = request.getParameter("joindate");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = sdf.parse(joindateStr);
		Timestamp joindate = new Timestamp(date.getTime());
		
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		member = new MemberDto(custno, custname, phone, address, joindate, grade, city);
		memberDao.addMember(member);
		
		response.sendRedirect("list.jsp");
	
	%>
</body>
</html>