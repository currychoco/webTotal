const body = document.body;
const inputCustname = body.querySelector("#custname");
const inputPhone = body.querySelector("#phone");
const inputAddress = body.querySelector("#address");
const inputJoindate = body.querySelector("#joindate");
const inputGrade = body.querySelector("#grade");
const inputCity = body.querySelector("#city");

const inputs = new Array();
inputs.push(inputCustname);
inputs.push(inputPhone);
inputs.push(inputAddress);
inputs.push(inputJoindate);
inputs.push(inputGrade);
inputs.push(inputCity);

/*
window.onload = () => {
    let query = location.search.substring(1);
    const params = query !== '' ? query.split('&') : null;
    params.forEach(e => {
        const data = e.split('=');
        if (data[0] === 'custname')
            inputCustname.value = data[1];
        if(data[0] === 'phone')
            inputPhone.value = data[1];
        if (data[0] === 'address')
            inputAddress.value = data[1];
        if (data[0] === 'joindate')
            inputJoindate.value = data[1];
        if (data[0] === 'grade')
            inputGrade.value = data[1];
        if (data[0] === 'city')
            inputCity.value = data[1];
    })
};
*/

function submitCheck(form){
    let custname = inputCustname.value;
    let phone = inputPhone.value;
    let address = inputAddress.value;
    let joindate = inputJoindate.value;
    let grade = inputGrade.value;
    let city = inputCity.value;

    let check = true;
    inputs.forEach(e => {
        if (e.value === '')
            check = false;
    })

    if (check){
        alert('회원등록이 완료되었습니다!');
        form.submit();
    }
    else {
        if(custname === '') {
            alert('회원성명이 입력되지 않았습니다.');
        }
        else if(phone === '') {
            alert('전화번호가 입력되지 않았습니다.');
        }
        else if(address === '') {
            alert('주소가 입력되지 않았습니다.');
        }
        else if(joindate === '') {
            alert('가입일이 입력되지 않았습니다.');
        }
        else if(grade === '') {
            alert('회원등급이 입력되지 않았습니다.');
        }
        else if(city === '') {
            alert('도시가 입력되지 않았습니다.');
        }

        let url = "join.jsp?"

        if (custname !== '') {
            url += `&custname=${custname}`;
        }
        if (phone !== '') {
            url += `&phone=${phone}`;
        }
        if(phone !== '') {
            url += `&phone=${phone}`;
        }
        if (address !== '') {
            url += `&address=${address}`;
        }
        if (joindate !== '') {
            url += `&joindate=${joindate}`;
        }
        if (grade !== '') {
            url += `&grade=${grade}`;
        }
        if (city !== '') {
            url += `&city=${city}`;
        }
        location.href = url;
    }

}