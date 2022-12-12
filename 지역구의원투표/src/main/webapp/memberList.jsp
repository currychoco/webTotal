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
	List<Map<String, String>> list = dao.getMemberList();
%>

	<jsp:include page="header.jsp"/>
	<section>
		<h3>후보조회</h3>
		<table border="1" style="border-collapse:collapse">
			<thead>
				<tr>
					<td>후보번호</td>
					<td>성명</td>
					<td>소속정당</td>
					<td>학력</td>
					<td>주민번호</td>
					<td>지역구</td>
					<td>대표전화</td>
				</tr>
			</thead>
			<tbody>
				<%for(Map<String, String> map : list){ %>
					<tr>
						<td><%=map.get("mNo") %></td>
						<td><%=map.get("mName") %></td>
						<td><%=map.get("pName") %></td>
						<td><%=map.get("school") %></td>
						<td><%=map.get("jumin") %></td>
						<td><%=map.get("area") %></td>
						<td><%=map.get("tel") %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>