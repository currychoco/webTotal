/**
 * 
 */
 
const body = document.body;
const inputCustname = body.querySelector("#custname");
const inputPhone = body.querySelector("#phone");
const inputAddress = body.querySelector("#address");
const inputJoindate = body.querySelector("#joindate");
const inputGrade = body.querySelector("#grade");
const inputCity = body.querySelector("#city");

function submitCheck(form){
	
    let custname = inputCustname.value;
    let phone = inputPhone.value;
    let address = inputAddress.value;
    let joindate = inputJoindate.value;
    let grade = inputGrade.value;
    let city = inputCity.value;

	if(custname === '') {
        alert('회원성명이 입력되지 않았습니다.');
        inputCustname.focus();
        return;
    }
    else if(phone === '') {
        alert('전화번호가 입력되지 않았습니다.');
        inputPhone.focus();
        return;
    }
    else if(address === '') {
        alert('주소가 입력되지 않았습니다.');
        inputAddress.focus();
        return;
    }
    else if(joindate === '') {
        alert('가입일이 입력되지 않았습니다.');
        inputJoindate.focus();
        return;
    }
    else if(grade === '') {
        alert('회원등급이 입력되지 않았습니다.');
        inputGrade.focus();
        return;
    }
    else if(city === '') {
        alert('도시가 입력되지 않았습니다.');
        inputCity.focus();
        return;
    }
    
    alert('회원등록이 완료되었습니다!');
    form.submit();
}