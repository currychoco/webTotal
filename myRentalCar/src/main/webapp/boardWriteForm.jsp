<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="resources/form.css">
    <title>EZEN BOARD</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	request.setCharacterEncoding("utf-8");
	System.out.println(request.getParameter("no"));
	%>
    <h1>EZEN BOARD</h1>
    <div class="form-container">
        <form method="post" action="boardWriteAction">
            <input type="text" name="title" placeholder="제목" required>
            <textarea name="content" rows="20" placeholder="글내용" required></textarea>
            <div>
            	<span>아이디 &nbsp;: &nbsp;</span>
            	<input type="text" name="user" required>
            </div>
            <div>
            	<span>비밀번호 : </span>
            	<input type="password" name="password" required>
            </div>
            <input type="submit">
        </form>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>