<%@page import="money.MoneyDao"%>
<%@page import="money.MoneyDto"%>
<%@page import="member.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.grid{
		display : grid;
		grid-template-ares :
		
	}
</style>
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
</head>
<body>
	<div class="grid">
		<div class = "title">
			<h1>쇼핑몰 회원관리 ver1.0</h1>
		</div>
		<div class = "nav">
			<a href = "join.jsp">회원등록</a>
			<a href = "login.jsp">로그인</a>
			<a href = "list.jsp">회원정보조회/수정</a>
			<a href = "sales.jsp">회원매출조회</a>
			<a href = "saleslist.jsp">판매리스트</a>
			<a href = "/">홈으로</a>
		</div>
		<div class = contents>
		</div>
	</div>
</body>
</html>