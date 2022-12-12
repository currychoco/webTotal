<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/index.css">
</head>
<body>
<%
	double num = 2.123456;
	System.out.println(String.format("%.5f", num));
%>
	<jsp:include page="header.jsp"/>
	<section></section>
	<jsp:include page="footer.jsp"/>
</body>
</html>