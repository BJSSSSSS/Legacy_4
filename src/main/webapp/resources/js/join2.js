

// ID, PW, NAME, EMAIL, PHONE
// 이름이 입력이 안되어 있으면 이름을 입력하세요 ALERT 창
// 두개이상 비어있으면 첫번째것만 focus로 가기
// -> 이건 return 을 활용하면 됨
// 하나하나 검사
const id = document.getElementById('id');
const idResult = document.getElementById('idResult');
const pw = document.getElementById('pw');
const pwResult = document.getElementById('pwResult');
const pw2 = document.getElementById('pw2');
const pw2Result = document.getElementById('pw2Result');
const name = document.getElementById('name');
const phone = document.getElementById('phone');
const email = document.getElementById('email');

const frm = document.getElementById('frm');
const btn = document.getElementById('btn');

let pwCheck = true; // 같지 않을 때 true, 같으면 false


// --------- ID 입력 후 처리 ----------
id.addEventListener("blur", function(){
    if(id.value == ''){
        idResult.innerHTML = 'ID를 입력하세요';
       // id.focus(); 
    }
});

// --------- PW 길이 검증 ------------
pw.addEventListener('blur', function(){
    if(pw.value.length < 8 || pw.value.length > 12){
        pwResult.innerHTML = 'PW의 글자수가 맞지 않습니다';
        //pw.focus();
    }else{
        pwResult.innerHTML = "";
    }
});

// ---------- PW 일치 확인 -----------
pw2.addEventListener('blur', function(){

    pwResult2.innerHTML = 'PW 일치!!'

    if(pw.value != pw2.value){
        pwResult2.innerHTML = 'PW가 일치 하지 않습니다'
        pwCheck = true;
        pw2.value='';
        // pw2.focus();
    } else{
        pwCheck = false;
    }
});

//------ 검증이 끝나고 PW 변경 시------
pw.addEventListener('change', function(){
    pwCheck = true;
    pw2.value = '';
    pwResult2.innerHTML ='PW가 일치 하지 않습니다';
    pw2.focus();
    // 근데 이렇게하면 바로 change로 가버려서 
    // pw일치하지않는다고 떠버리네 이걸 어째야 하누
});


// ---------- 가입버튼 ----------------
btn.addEventListener("click", function(){

    if(id.value ==''){
        alert('ID를 입력하세요');
        id.focus();
        return;
    }

    if(pw.value == '' || pw.value.length < 8 || pw.value.length > 12){
        alert('PW가 정확하지 않습니다')
        pw.focus();
        return;
    }

    if(pwCheck){
        alert('PW가 일치하지 않습니다');
        pw2.focus();
        return;
    }

    if(name.value == ''){
        alert('name을 입력하세요')
        name.focus();
        return;
    }

    if(phone.value == ''){
        alert('phone을 입력하세요')
        phone.focus();
        return;
    }

    if(email.value == ''){
        alert('email을 입력하세요')
        email.focus();
        return;
    }

    frm.submit();

});

    // if(pwCheck){
    //     num++;
    // }else{
    //     message = 'PW';
    //     pw.focus();
    //     return;
    // }

    // if(pw2Check){
    //     num++;
    // }else{
    //     message = 'PW2';
    //     pw2.focus();
    //     return;
    // }

    // if(nameCheck){
    //     num++;
    // }else{
    //     message = 'Name';
    //     name.focus();
    //     return;
    // }

    // if(phoneCheck){
    //     num++;
    // }else{
    //     message = 'phone';
    //     phone.focus();
    //     return;
    // }

    // if(emailCheck){
    //     num++;
    // }else{
    //     message = 'email';
    //     email.focus();
    //     return;
    // }














// let idCheck = false;
// let pwCheck = false;
// let pw2Check = false;
// let nameCheck = false;
// let phoneCheck = false;
// let emaildCheck = false;


// id.addEventListener("blur", function(){
//     if(id.value == ''){
//         idCheck = false;
//     }else{
//         idCheck = true;
//     }
// });


// pw.addEventListener("blur", function(){
//     if(pw.value == ''){
//         pwCheck = false;
//     }else{
//         pwCheck = true;
//     }
// });


// pw2.addEventListener("blur", function(){
//     if(pw2.value == ''){
//         pw2Check = false;
//     }else{
//         pw2Check = true;
//     }
// });


// name.addEventListener("blur", function(){
//     if(name.value == ''){
//         nameCheck = false;
//     }else{
//         nameCheck = true;
//     }
// });


// phone.addEventListener("blur", function(){
//     if(phone.value == ''){
//         phoneCheck = false;
//     }else{
//         phoneCheck = true;
//     }
// });


// email.addEventListener("blur", function(){
//     if(email.value == ''){
//         emailCheckCheck = false;
//     }else{
//         emailCheck = true;
//     }
// });