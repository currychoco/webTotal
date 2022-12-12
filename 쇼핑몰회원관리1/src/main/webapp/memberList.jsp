<%@page import="member.MemberDto"%>
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
	List<MemberDto> list = dao.memberList();
%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>회원목록조회/수정</h3>
		<table border="1" style="border-collapse:collapse">
			<thead>
				<tr>
					<td>회원정보</td>
					<td>회원성명</td>
					<td>전화번호</td>
					<td>주소</td>
					<td>가입일자</td>
					<td>고객등급</td>
					<td>거주지역</td>
				</tr>
			</thead>
			<tbody>
				<%for(MemberDto mem : list){%>
					<tr>
						<td><a href="updateMember.jsp?custno=<%=mem.getCustno() %>"><%=mem.getCustno() %></a></td>
						<td><%=mem.getCustname() %></td>
						<td><%=mem.getPhone() %></td>
						<td><%=mem.getAddress() %></td>
						<td><%=mem.getJoindate() %></td>
						<td><%=mem.getGrade() %></td>
						<td><%=mem.getCity() %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</html>