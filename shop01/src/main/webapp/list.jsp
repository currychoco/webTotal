<%@page import="java.sql.Timestamp"%>
<%@page import="member.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="home.css">
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<section>
		<%
		MemberDao memberDao = MemberDao.getInstance();
		List<MemberDto> list = memberDao.getMemberAll();
		%>
		<h1>회원목록조회/수정</h1>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%
			for (MemberDto m : list) {
			%>
			<tr>
				<td><a href="update.jsp?custno=<%=m.getCustno()%>"><%=m.getCustno()%></a></td>
				<td><%=m.getCustname()%></td>
				<td><%=m.getPhone()%></td>
				<td><%=m.getAddress()%></td>
				<td><%=m.getJoindate()%></td>
				<td><%=m.getGradeString()%></td>
				<td><%=m.getCity()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</section>

	<jsp:include page="footer.jsp" />
</body>
</html>