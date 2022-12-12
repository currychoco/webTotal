<%@page import="util.DBManager"%>
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
	<jsp:include page="header.jsp"/>
	<section>
		<form method="post" action="votePro.jsp">
			<h3>투표하기</h3>
			<table border="1" style="border-collapse:collpase">
				<tr>
					<td>주민번호</td>
					<td class="td-left"><input type="text" id="jumin" name="jumin"> 예 : 8906153154726</td>
				</tr>	
				<tr>
					<td>성명</td>
					<td class="td-left"><input type="text" id="name" name="name"></td>
				</tr>	
				<tr>
					<td>투표번호</td>
					<td class="td-left">
						<select id="mNo" name="mNo">
							<option value="" selected></option>
							<option value="1">[1] 김후보</option>
							<option value="2">[2] 이후보</option>
							<option value="3">[3] 박후보</option>
							<option value="4">[4] 조후보</option>
							<option value="5">[5] 최후보</option>
						</select>
					</td>
				</tr>	
				<tr>
					<td>투표시간</td>
					<td class="td-left"><input type="text" id="time" name="time"></td>
				</tr>	
				<tr>
					<td>투표장소</td>
					<td class="td-left"><input type="text" id="area" name="area"></td>
				</tr>	
				<tr>
					<td>유권자확인</td>
					<td class="td-left">
						<label><input type="radio" name="vConfirm" value="Y">확인</label>
						<label><input type="radio" name="vConfirm" value="N">미확인</label>			
					</td>
				</tr>	
				<tr>
					<td colspan="2">
						<input type="button" onclick="vote(form)" value="투표하기">
						<input type="button" onclick="revote()" value="다시하기">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp"/>
	<script type="text/javascript" src="resources/vote.js"></script>
</body>
</html>