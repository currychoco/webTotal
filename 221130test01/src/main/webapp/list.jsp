<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="member.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberDao"%>
<%@page import="util.DBManager"%>
<%@page import="java.sql.Connection"%>
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
		MemberDao dao = MemberDao.getInstance();
		List<MemberDto> list = dao.getMemberAll();
		System.out.println("size : " + list.size());
	%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>회워목록조회/수정</h3>
		<table border="1" style="border-collapse:collapse;">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(MemberDto member : list){
						Timestamp joinDate = member.getJoindate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				%>
				<tr>
					<td><a href="update.jsp?custno=<%=member.getCustno()%>"><%=member.getCustno() %></a></td>
					<td><%=member.getCustname() %></td>
					<td><%=member.getPhone() %></td>
					<td><%=member.getAddress() %></td>
					<td><%=sdf.format(joinDate) %></td>
					<td><%=member.getGradeString() %></td>
					<td><%=member.getCity() %></td>
				</tr>
				
				<%} %>
			</tbody>
		</table>
		
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>