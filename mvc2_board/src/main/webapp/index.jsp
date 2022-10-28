<%@page import="board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDao"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="resources/table.css">
    <title>EZEN BOARD</title>
</head>
<script>
	
</script>
<body>
	<%
	BoardDao dao = BoardDao.getInstance();
	ArrayList<BoardDto> list = dao.getBoardAll();
	%>
    <h1>EZEN BOARD</h1>
    <div class="table-container">
        <table border="1">
            <thead>
                <tr>
                    <th>no</th>
                    <th width="200px">title</th>
                    <th>user</th>
                    <th>regDate</th>
                    <th>modDate</th>
                    <th>viewCnt</th>
                </tr>
            </thead>
            <tbody>
            <%for(BoardDto board : list) {%>
                <tr>
                    <td><%=board.getNo() %></td>
                    <td><a href="boardView.jsp?no=<%=board.getNo()%>"><%=board.getTitle() %></a></td>
                    <td><%=board.getUser() %></td>
                    <td><%=board.getRegDate() %></td>
                    <td><%=board.getModDate() %></td>
                    <td><%=board.getViewCnt() %></td>
                </tr>
            <%} %>
            </tbody>
        </table>
        <button onclick="location.href='boardWriteForm.jsp'">글쓰기</button>
    </div>
</body>

</html>