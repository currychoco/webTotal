/**
 * 
 */
 function vote(form){
	const juminIn = document.body.querySelector("#jumin");
	const nameIn = document.body.querySelector("#name");
	const mNoIn = document.body.querySelector("#mNo option:checked");
	const timeIn = document.body.querySelector("#time");
	const areaIn = document.body.querySelector("#area");
	const vConfirmIn = document.body.querySelector("input[name=vConfirm]:checked");
		
	const jumin = juminIn.value;
	const name = nameIn.value;
	const mNo = mNoIn.value;
	const time = timeIn.value;
	const area = areaIn.value;
	
	
	if(!jumin){
		alert("주민번호가 입력되지 않았습니다!");
		juminIn.focus();
		return;
	}
	if(!name){
		alert("성명이 입력되지 않았습니다!");
		nameIn.focus();
		return;
	}
	if(!mNo){
		alert("후보번호가 선택되지 않았습니다!");
		mNoIn.focus();
		return;
	}
	if(!time){
		alert("투표시간이 입력되지 않았습니다!");
		timeIn.focus();
		return;
	}
	if(!area){
		alert("투표장소가 입력되지 않았습니다!");
		areaIn.focus();
		return;
	}
	if(!vConfirmIn || !vConfirmIn.value) {
		alert("유권자확인이 선택되지 않았습니다!");
		vConfirmIn.focus();
		return;
	}
	const vConfirm = vConfirmIn.value;
	
	alert("투표하기 정보가 정상적으로 등록 되었습니다!");
	form.submit();
}

function revote(){
	
}