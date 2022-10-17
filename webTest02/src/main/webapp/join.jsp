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

<h1>회원등록</h1>
<form method = "GET" action="joinPro.jsp">
    name : <input type="text" name="custname"><br>
    phone : <input type="text" name="phone"><br>
    address : <input type="text" name="address"><br>
    grade : <input type="text" name="grade"><br>
    city : <input type="text" name="city"><br>
    <input type="submit" value="회원등록">
</form>
    
</body>
</html>