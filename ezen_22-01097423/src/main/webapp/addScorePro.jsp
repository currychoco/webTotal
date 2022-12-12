<%@ page import="score.ScoreDao"%>
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

	String stid = request.getParameter("stid");
	
	String dtcode = request.getParameter("subjectCode");
	int midScore = Integer.parseInt(request.getParameter("mid"));
	int finalScore = Integer.parseInt(request.getParameter("final"));
	int attend = Integer.parseInt(request.getParameter("attend"));
	int report = Integer.parseInt(request.getParameter("report"));
	int etc = Integer.parseInt(request.getParameter("etc"));
	
	ScoreDao dao = ScoreDao.getInstance();
	dao.addScore(stid, dtcode, midScore, finalScore, attend, report, etc);
	
	response.sendRedirect("index.jsp");
	
%>
</body>
</html>