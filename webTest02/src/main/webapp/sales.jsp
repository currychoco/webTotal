<%@page import="java.util.Collections"%>
<%@page import="member.MemberDtoTotalSales"%>
<%@page import="money.MoneyDto"%>
<%@page import="member.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="money.MoneyDao"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원관리</title>
</head>
<body>
	<%
	MemberDao memberDao = MemberDao.getInstance();
	MoneyDao moneyDao = MoneyDao.getInstance();
	
	ArrayList<MemberDto> member = memberDao.getMemberAll();
	ArrayList<MoneyDto> money = moneyDao.getMoneyAll();
	
	
	//memberTotal 리스트에 값 저장
	ArrayList<MemberDtoTotalSales> memberTotal = new ArrayList<>();
	for(MoneyDto m : money){
		MemberDto mem = memberDao.getMember(m.getCustno());
		boolean isExistCustno =false;
		for(int i = 0;i<memberTotal.size();i++){
			if(memberTotal.get(i).getCustno() == mem.getCustno()){
				isExistCustno = true;
				int mul = m.getPcost() * m.getAmount();
				memberTotal.get(i).add(mul);
				break;
			}
		}
		if(!isExistCustno){
			int mul = m.getPcost() * m.getAmount();
			memberTotal.add(new MemberDtoTotalSales(m.getCustno(),mem.getCustname(), mem.getGrade(), mul));
		}
	}
	
	//memberTotal 리스트 정렬
	for(int i =0;i<memberTotal.size() - 1;i++){
		for(int j =i+1;j<memberTotal.size();j++){
			if(memberTotal.get(i).getTotalSales() < memberTotal.get(j).getTotalSales()){
				Collections.swap(memberTotal, i, j);
			}
		}
	}
	%>

	<table>
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>

		<%
		for(MemberDtoTotalSales mt : memberTotal){
		%>

		<tr>
			<td><%=mt.getCustno() %></td>
			<td><%=mt.getCustname() %></td>
			<td><%=mt.getGrade() %></td>
			<td><%=mt.getTotalSales() %></td>
		</tr>

		<%
		}
		%>
	</table>

</body>
</html>