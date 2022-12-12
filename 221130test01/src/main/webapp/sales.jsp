<%@page import="java.util.ArrayList"%>
<%@page import="money.MoneyDao"%>
<%@page import="util.DBManager"%>
<%@page import="java.sql.Connection"%>
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
		MoneyDao dao = MoneyDao.getInstance();
		ArrayList<ArrayList<String>> list = dao.getSalesInquiry();
	%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>회원매출조회</h3>
		<table border="1" style="border=collapse:collapse;">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>고객등급</th>
					<th>매출</th>
				</tr>
			</thead>
			<tbody>
				<%for(ArrayList<String> data : list) { %>
				<tr>
					<%for(int i=0; i<data.size(); i++) { %>
					<td><%=data.get(i) %></td>
					<%} %>
				</tr>
				<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>