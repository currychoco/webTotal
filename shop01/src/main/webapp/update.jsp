<%@page import="member.MemberDto"%>
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
<%
request.setCharacterEncoding("UTF-8");
MemberDao memberDao = MemberDao.getInstance();
MemberDto member = null;

request.setCharacterEncoding("utf-8");
String custno = request.getParameter("custno");

if(custno == null){
	response.sendRedirect("list.jsp");
}else{
	member=memberDao.getMember(Integer.parseInt(custno));
	
	if(member == null){
		response.sendRedirect("list.jsp");
	}else{%>
}
%>
<jsp:include page="header.jsp"/>
<section>
<h3>홈쇼핑 회원 정보 수정</h3>
<form method="post" action="updatePro.jsp">
	<table>
		<tr>
			<th>
			회원번호
			</th>
			<td>
			<input type="text" id="custno" name="custno" value=<%=custno %> readonly>
			</td>
		</tr>
		<tr>
			<th>
			회원성명
			</th>
			<td>
			<input type="text" id="custname" name="custname" value="<%=member.getCustname() %>">
			</td>
		</tr>
		<tr>
			<th>
			회원전화
			</th>
			<td>
			<input type="text" id="phone" name="phone" value="<%=member.getPhone()%>">
			</td>
		</tr>
		<tr>
			<th>
			회원주소
			</th>
			<td>
			<input type="text" id="address" name="address" value="<%=member.getAddress()%>">
			</td>
		</tr>
		<tr>
			<th>
			가입일자
			</th>
			<td>
			<input type="text" id="joindate" name="joindate" value=<%=member.getJoindate() %> readonly>
			</td>
		</tr>
		<tr>
			<th>
			고객등급[A:VIP,B:일반,C:직원]
			
			</th>
			<td>
			<%
			String grade = member.getGrade();
			%>
			<select id="grade" name="grade">
				<option value="A" <%=grade.equals("A") ? "selected" : "" %>>A</option>
				<option value="B" <%=grade.equals("B") ? "selected" : "" %>>B</option>
				<option value="C" <%=grade.equals("C") ? "selected" : "" %>>C</option>
			</select>
			</td>
		</tr>
		<tr>
			<th>
			도시코드
			</th>
			<td>
			<input type="text" id="city" name="city" value="<%=member.getCity()%>">
			</td>
		</tr>
		<tr>
			<th>
			</th>
			<td>
			<input type="submit" value="수정" onclick="alert('회원정보수정이 완료되었습니다.')">
			<button type="button" onclick="location.href='remove.jsp'">삭제</button>
			<button type="button" onclick="location.href='list.jsp'">조회</button>
			</td>
		</tr>
	</table>
	</form>
</section>
<jsp:include page="footer.jsp"/>
<%	}
}
%>
</body>
</html>