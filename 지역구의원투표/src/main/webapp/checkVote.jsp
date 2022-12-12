<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="vote.VoteDao"%>
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
	VoteDao dao = VoteDao.getInstance();
	List<Map<String, String>> list = dao.checkVote();
%>
	<jsp:include page="header.jsp"/>
	<section>
		<table border="1" style="border-collapse:collapse">
			<thead>
				<tr>
					<td>성명</td>
					<td>생년월일</td>
					<td>나이</td>
					<td>성별</td>
					<td>후보번호</td>
					<td>투표시간</td>
					<td>유권자확인</td>
				</tr>
			</thead>
			<tbody>
				<%for(Map<String, String> m : list){ %>
					<tr>
						<td><%=m.get("vName") %></td>
						<td><%=m.get("birth") %></td>
						<td>만 <%=m.get("age") %>세</td>
						<td><%=m.get("gender") %></td>
						<td><%=m.get("mNo") %></td>
						<td><%=m.get("time") %></td>
						<td><%=m.get("vConfirm") %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>