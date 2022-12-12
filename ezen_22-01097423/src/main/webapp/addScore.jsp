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
		<h3>개인성적등록</h3>
		<form method = "post" action="addScorePro.jsp" onsubmit="return check()">
			<table border="1" style="border-collapse:collapse">
				<tr>
					<th>학번</th>
					<td><input type="text" id="stid" name="stid"></td>
				</tr>
				<tr>
					<th>과목코드</th>
					<td><input type="text" id="subjectCode" name="subjectCode"> 예)S001</td>
				</tr>
				<tr>
					<th>중간(30%)(0~100)</th>
					<td><input type="text" id="mid" name="mid"> 점</td>
				</tr>
				<tr>
					<th>기말(30%)(0~100)</th>
					<td><input type="text" id="final" name="final"> 점</td>
				</tr>
				<tr>
					<th>출석(20%)(0~100)</th>
					<td><input type="text" id="attend" name="attend"> 점</td>
				</tr>
				<tr>
					<th>레포트(10%)(0~100)</th>
					<td><input type="text" id="report" name="report"> 점</td>
				</tr>
				<tr>
					<th>기타(10%)(0~100)</th>
					<td><input type="text" id="etc" name="etc"> 점</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="button" onclick="scoreSubmit(form)" value="등록">
						<input type="button" onclick="reStart()" value="다시쓰기">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp"/>
	<script type="text/javascript" src="resources/addScore.js">
	function  check(){
		
		let stdid = document.getElementById('stid').value;
		
		if(stdid === ''){
			alert('학번이 등록되지않았습니다');
			return false;
		}
		
		alert('성공적으로 등록되었습니다');
	}
	</script>
</body>
</html>