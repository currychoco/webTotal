<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	SimpleDateFormat sdf = null;
	
	MemberDao memberDao = MemberDao.getInstance();
	MemberDto member = null;
	
	request.setCharacterEncoding("utf-8");
	String custno = request.getParameter("custno");
	
	if(custno == null){
		response.sendRedirect("list.jsp");
	}
	else {
		member = memberDao.getMemberByCustno(Integer.parseInt(custno));

		if(member == null)
			response.sendRedirect("list.jsp");
		else { %>
			

	<jsp:include page="header.jsp" />
	<section>
		<h3>홈쇼핑 회원 정보 수정</h3>
		<form method="post" action="updatePro.jsp">
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<td>회원번호</td>
					<td><input type="text" id="custno" name="custno" value="<%=custno %>" readonly></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="custname" name="custname" value="<%=member.getCustname() %>"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" id="phone" name="phone" value="<%=member.getPhone()%>"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="address" name="address" value="<%=member.getAddress()%>"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<%
					sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(member.getJoindate());
					%>
					<td><input type="date" id="joindate" name="joindate" value="<%=date%>"></td>
				</tr>
				<tr>
					<td>고객등급[A:VIP,B:일반,C:직원]</td>
					<%
					String grade = member.getGrade();
					%>
					<td><select id="grade" name="grade">
							<option value="A" <%=grade.equals("A") ? "selected" : "" %>>A</option>
							<option value="B" <%=grade.equals("B") ? "selected" : "" %>>B</option>
							<option value="C" <%=grade.equals("C") ? "selected" : "" %>>C</option>
					</select></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" id="city" name="city" value="<%=member.getCity()%>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" onclick="alert('회원정보수정이 완료 되었습니다.')"> <input
						type="button" value="조회"></td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp" />
	<%		}
	}
	%>
</body>
</html>