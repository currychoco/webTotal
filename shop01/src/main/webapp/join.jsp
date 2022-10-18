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
<jsp:include page="header.jsp"/>
<section>
<%
MemberDao memberDao = MemberDao.getInstance();
int custno = memberDao.getLastNo();
String joindate = memberDao.getDate();

String custname = request.getParameter("custname");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String grade = request.getParameter("grade");
String city = request.getParameter("city");
%>
	<form method="post" action="joinPro.jsp">
	<table>
		<tr>
			<th>
			회원번호(자동발생)
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
			<input type="text" id="custname" name="custname" value="<%=custname != null ? custname : ""%>" <%=custname == null ? "autofocus" : "" %>>
			</td>
		</tr>
		<tr>
			<th>
			회원전화
			</th>
			<td>
			<input type="text" id="phone" name="phone" value="<%=phone != null ? phone : ""%>" <%=phone == null ? "autofocus" : "" %>>
			</td>
		</tr>
		<tr>
			<th>
			회원주소
			</th>
			<td>
			<input type="text" id="address" name="address" value="<%=address != null ? address : ""%>" <%=address == null ? "autofocus" : "" %>>
			</td>
		</tr>
		<tr>
			<th>
			가입일자
			</th>
			<td>
			<input type="text" id="joindate" name="joindate" value=<%=joindate %> readonly>
			</td>
		</tr>
		<tr>
			<th>
			고객등급[A:VIP,B:일반,C:직원]
			</th>
			<td>
			<select id="grade" name="grade">
				<option value="A" <%=grade != null && grade.equals("A") ? "selected" : "" %>>A</option>
				<option value="B" <%=grade != null && grade.equals("B") ? "selected" : "" %>>B</option>
				<option value="C" <%=grade != null && grade.equals("C") ? "selected" : "" %>>C</option>
			</select>
			</td>
		</tr>
		<tr>
			<th>
			도시코드
			</th>
			<td>
			<input type="text" id="city" name="city" value="<%=city != null ? city : ""%>" <%=city == null ? "autofocus" : "" %>>
			</td>
		</tr>
		<tr>
			<th>
			</th>
			<td>
			<input type="button" value="등록" onclick="submitCheck(form)">
			<button type="button" onclick="location.href='list.jsp'">조회</button>
			</td>
		</tr>
	</table>
	</form>
</section>
<jsp:include page="footer.jsp"/>
<script src="validation.js" charset="utf-8"></script>
<jsp:include page="footer.jsp"/>
</body>
</html>