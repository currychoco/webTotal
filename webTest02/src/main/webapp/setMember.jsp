<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정보수정</h1>
<%
int custno = Integer.parseInt(request.getParameter("custno"));
MemberDao memberDao = MemberDao.getInstance();
MemberDto m = memberDao.getMember(custno);
%>

<form method = "GET" action="setMemberPro.jsp">
	custno : <input type="text" name="custno" value="<%=m.getCustno()%>" readonly><br>
	name : <input type="text" name="custname" value="<%=m.getCustname()%>"><br>
	phone : <input type="text" name="phone" value="<%=m.getPhone()%>"><br>
	address : <input type="text" name="address" value="<%=m.getAddress()%>"><br>
	grade : <input type="text" name="grade" value="<%=m.getGrade()%>"><br>
	city : <input type="text" name="city" value="<%=m.getCity()%>"><br>
	<input type="submit" value="수정">
</form>

</body>
</html>