<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="sales.SalesDao"%>
<%@page import="java.sql.Connection"%>
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
	SalesDao dao = SalesDao.getInstance();
	List<Map<String, String>> list = dao.getAllSales();
%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>회원매출조회</h3>
		<table border="1" style="border-collapse : collapse">
			<thead>
				<tr>
					<td>회원번호</td>
					<td>회원성명</td>
					<td>고객등급</td>
					<td>매출</td>
				</tr>
			</thead>
			<tbody>
				<%for(Map<String, String> m : list){ %>
					<tr>
						<td><%= m.get("custno") %></td>
						<td><%= m.get("custname") %></td>
						<td><%= m.get("grade") %></td>
						<td><%= m.get("sales") %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</html>