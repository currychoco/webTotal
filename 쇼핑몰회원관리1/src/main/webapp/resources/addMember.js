/**
 * 
 */
 
 function addMember(form){
	const custnameIn = document.body.querySelector("#custname");
	const phoneIn = document.body.querySelector("#phone");
	const addressIn = document.body.querySelector("#address");
	const joindateIn = document.body.querySelector("#joindate");
	const gradeIn = document.body.querySelector("#grade");
	const cityIn = document.body.querySelector("#city");

	const custname= custnameIn.value;
	const phone = phoneIn.value;
	const address = addressIn.value;
	const joindate = joindateIn.value;
	const grade = gradeIn.value;
	const city = cityIn.value;
	
	if(!custname){
		alert("회원성명을 입력하시오");
		custnameIn.focus();
		return;
	}
	if(!phone){
		alert("전화번호를 입력하시오");
		phoneIn.focus();
		return;
	}
	if(!address){
		alert("주소를 입력하시오");
		addressIn.focus();
		return;
	}
	if(!joindate){
		alert("가입일자를 입력하시오");
		joindateIn.focus();
		return;
	}
	if(!grade){
		alert("등급을 입력하시오");
		gradeIn.focus();
		return;
	}
	if(!city){
		alert("도시코드를 입력하시오");
		cityIn.focus();
		return;
	}
	
	alert("회원정보등록이 완료되었습니다.")
	form.submit();
}

function listBack(){
	location.href="memberList.jsp";
}