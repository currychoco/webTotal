<%@page import="money.MoneyDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="money.MoneyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	MoneyDao moneyDao = MoneyDao.getInstance();
	ArrayList<MoneyDto> money = moneyDao.getMoneyAll();
	%>
	
	<table>
		<tr>
			<th>회원번호</th>
			<th>판매번호</th>
			<th>공급가격</th>
			<th>수량</th>
			<th>가겨</th>
			<th>상품코드</th>
			<th>판매날짜</th>
		</tr>

		<%
		for (MoneyDto m : money) {
		%>
		<tr>
			<td><%=m.getCustno()%></td>
			<td><%=m.getSaleno()%></td>
			<td><%=m.getPcost()%></td>
			<td><%=m.getAmount()%></td>
			<td><%=m.getPrice()%></td>
			<td><%=m.getPcode()%></td>
			<td><%=m.getSdate()%></td>
		</tr>

		<%
		}
		%>
	</table>
</body>
</html>