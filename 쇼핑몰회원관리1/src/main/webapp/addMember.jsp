<%@page import="member.MemberDto"%>
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
	int custno = dao.getLastNo();
%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>홈쇼핑 회원 등록</h3>
		<form method="post" action="addMemberPro.jsp">
			<table border="1" style="border-collapse:collapse">
				<tr>
					<th>회원번호</th>
					<td><input type="text" id="custno" name="custno" value="<%=custno %>" readonly></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" id="custname" name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" id="phone" name="phone"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" id="address" name="address"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" id="joindate" name="joindate"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" id="grade" name="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" id="city" name="city"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" onclick="addMember(form)" value="등록">
						<input type="button" onclick="listBack()" value="조회">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp"/>
	<script type="text/javascript" src="resources/addMember.js"></script>
</html>