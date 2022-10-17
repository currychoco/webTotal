<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="total.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>홈쇼핑 회원 정보 수정</h1>
<%
request.setCharacterEncoding("UTF-8");

int custno = Integer.parseInt(request.getParameter("custno"));
MemberDao memberDao = MemberDao.getInstance();
MemberDto m = memberDao.getMember(custno);
%>

<form method = "GET" action="setMemberPro.jsp">
	<table>
		<tr>
			<th>회원번호</th>
			<td><input type="text" name="custno" value="<%=m.getCustno()%>" readonly></td>
		</tr>
		<tr>
			<th>회원성명</th>
			<td><input type="text" name="custname" value="<%=m.getCustname()%>"></td>
		</tr>
		<tr>
			<th>회원전화</th>
			<td><input type="text" name="phone" value="<%=m.getPhone()%>"></td>
		</tr>
		<tr>
			<th>회원주소</th>
			<td><input type="text" name="address" value="<%=m.getAddress()%>"></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><input type="text" name="joindate" value="<%=m.getJoindate()%>" readonly></td>
		</tr>
		<tr>
			<th>고객등급[A:VIP,B:일반,C:직원]</th>
			<td><input type="text" name="grade" value="<%=m.getGrade()%>"></td>
		</tr>
		<tr>
			<th>도시코드</th>
			<td><input type="text" name="city" value="<%=m.getCity()%>"></td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" value="수정">
				<button type="button" onClick="location.href='list.jsp'">조회</button>
			</td>
		</tr>
	</table>
	
</form>

</body>
</html>