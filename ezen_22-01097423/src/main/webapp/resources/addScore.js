/**
 * 
 */
 function scoreSubmit(form){
	const inputStid = document.body.querySelector("#stid");
	const inputSubjectCode = document.body.querySelector("#subjectCode");
	const inputMid = document.body.querySelector("#mid");
	const inputFinal = document.body.querySelector("#final");
	const inputAttend = document.body.querySelector("#attend");
	const inputReport = document.body.querySelector("#report");
	const inputEtc = document.body.querySelector("#etc");
	
	const stid = inputStid.value;
	const subjectCode  = inputSubjectCode.value;
	const mid = inputMid.value;
	const final =inputFinal.value;
	const attend =inputAttend.value;
	const report =inputReport.value;
	const etc =inputEtc.value;
	
	if(!stid){
		alert("학번이 입력되지 않았습니다.");
		inputStid.focus();
		return;
	}
	if(!subjectCode){
		alert("과목코드가 입력되지 않았습니다.");
		inputSubjectCode.focus();
		return;
	}
	if(!mid){
		alert("중간(30%)(0~100)이 입력되지 않았습니다.");
		inputMid.focus();
		return;
	}
	if(!final){
		alert("기말(30%)(0~100)이 입력되지 않았습니다.");
		inputFinal.focus();
		return;
	}
	if(!attend){
		alert("출석(20%)(0~100)이 입력되지 않았습니다.");
		inputAttend.focus();
		return;
	}
	if(!report){
		alert("레포트(10%)(0~100)이 입력되지 않았습니다.");
		inputReport.focus();
		return;
	}
	if(!etc){
		alert("기타(10%)(0~100)학번이 입력되지 않았습니다.");
		inputEtc.focus();
		return;
	}
	
	form.submit();
	
}

function reStart(){
	alert("정보를 지우고 처음부터 다시 입력합니다!");
	location.reload();
}