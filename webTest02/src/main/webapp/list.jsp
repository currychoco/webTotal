<%@page import="member.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
</head>
<body>
<%
	MemberDao memberDao = MemberDao.getInstance();
	ArrayList<MemberDto> member = memberDao.getMemberAll();
	%>

	<!-- 웹 페이지에 오라클디비 테이블 member_tbl_02 가지고 있는 모든 정보를
	테이블 형태로 출력하기
	-->
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
		for (MemberDto m : member) {
		%>
		<tr>
			<td><%=m.getCustno()%></td>
			<td><%=m.getCustname()%></td>
			<td><%=m.getPhone()%></td>
			<td><%=m.getAddress()%></td>
			<td><%=m.getJoindate()%></td>
			<td><%=m.getGrade()%></td>
			<td><%=m.getCity()%></td>
			<td><a href = "/webTest02/setMember.jsp?custno=<%=m.getCustno()%>">수정</a></td>
		</tr>

		<%
		}
		%>
	</table>
</body>
</html>