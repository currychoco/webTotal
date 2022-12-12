<%@page import="java.util.List"%>
<%@page import="score.ScoreDao"%>
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
		ScoreDao dao = ScoreDao.getInstance();
		List<List<String>> list = dao.getAllList();

	%>

	<jsp:include page="header.jsp"/>
	<section>
		<h3>전체성적조회</h3>
		<table border="1" style="border-collapse : collapse">
			<thead>
				<tr>
					<td>학번</td>
					<td>성명</td>
					<td>성별</td>
					<td>과목명</td>
					<td>전공구분</td>
					<td>담당교수</td>
					<td>중간</td>
					<td>기말</td>
					<td>출석</td>
					<td>레포트</td>
					<td>기타</td>
					<td>점수</td>
					<td>등급</td>
				</tr>
			</thead>
			<tbody>
				<%for(List<String> info : list){ %>
					<tr>
						<td><%=info.get(0) %></td>
						<td><%=info.get(1) %></td>
						<td><%=info.get(2) %></td>
						<td><%=info.get(3) %></td>
						<td><%=info.get(4) %></td>
						<td><%=info.get(5) %></td>
						<td><%=info.get(6) %></td>
						<td><%=info.get(7) %></td>
						<td><%=info.get(8) %></td>
						<td><%=info.get(9) %></td>
						<td><%=info.get(10) %></td>
						<td><%=info.get(11) %></td>
						<td><%=info.get(12) %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>