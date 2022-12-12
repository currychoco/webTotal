<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberDao"%>
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
MemberDao dao = MemberDao.getInstance();
List<Map<String, String>> list = dao.getMemberRank();
%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>후보자등수</h3>
		<table border="1" style="border-collapse:collapse">
			<thead>
				<tr>
					<td>후보번호</td>
					<td>성명</td>
					<td>총투표건수</td>
				</tr>
			</thead>
			<tbody>
				<%for(Map<String, String> m : list) {%>
					<tr>
						<td><%=m.get("mNo") %></td>
						<td><%=m.get("mName") %></td>
						<td><%=m.get("score") %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>