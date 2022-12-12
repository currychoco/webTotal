<%@page import="vote.VoteDao"%>
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
	
	String jumin = request.getParameter("jumin");
	String name = request.getParameter("name");
	String mNo = request.getParameter("mNo");
	String time = request.getParameter("time");
	String area = request.getParameter("area");
	String vConfirm = request.getParameter("vConfirm");
	
	VoteDao dao = VoteDao.getInstance();
	dao.vote(jumin, name, mNo, time, area, vConfirm);
	
	response.sendRedirect("/");
%>
</body>
</html>