<%@page import="board.BoardDto"%>
<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	BoardDao dao = BoardDao.getInstance();
	
	if(request.getParameter("no")!=null && request.getParameter("password") != null){
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDto board = dao.getBoardByNo(no);
		String password = request.getParameter("password");
		
		if(board.getPassword().equals(password)){
			dao.deleteBoard(no);
			response.sendRedirect("alertAndRedirect?alertMsg=Delete Success!&redirectUrl=index");
		}
	}
	response.sendRedirect("alertAndRedirect?alertMsg=Delete Failed...&redirectUrl=index");
%>
</body>
</html>