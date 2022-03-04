// 전역변수
// var는 쓰지말자 전역, 지역 다 선언가능해서 헷갈림

const pwResult = document.getElementById('pwResult');
const pw = document.getElementById('pw');

const pwResult2 = document.getElementById('pwResult2');
const pw2 = document.getElementById('pw2');
const idResult = document.getElementById('idResult');
const id = document.getElementById('id');

const frm = document.getElementById('frm');
const btn = document.getElementById('btn');

const name = document.getElementById('name');
const phone = document.getElementById('phone');
const email = document.getElementById('email');

let idCheck = false; //check OK : True, check X : False
let pwCheck = false;
let nameCheck = false;
let phoneCheck = false;
let emailCheck = false;



pw.addEventListener("keyup", function(){
    //지역변수
    let message = '잘못된 비번'
    let bg = 'c1'

    if(pw.value.length == 0){
        message =""; 
    }else if(pw.value.length < 8 || pw.value.length > 12){
    }
    else{
        message ='정상적인 비번'
        bg = 'c2';
    }
    pwResult.innerText = message;
    pwResult.className = bg;
});

id.onblur = function(){

    let v = id.value;
    let bg = 'c1'

    if(v == ""){//v.length == 0
       
        idResult.innerText = "필수 입력";
        idResult.className = bg;
        idCheck = false;
        console.log(idCheck);
    }{
        idCheck = true;
        console.log(idCheck);
    }

    // 이거 왜 안없어질까 생각해볼것!
    // if(v.length == 0){//v.length == 0
    //     console.log(v);
    //     idResult.innerText = "필수 입력";
    //     idCheck = false;
    // }{
    //     idResult.innerText = "";
    //     bg = 'c2';
    //     console.log(v);
    //     idCheck = true;
    // }
    // idResult.className = bg;
};

    // let v = id.value;
    // let message = '비어 있지 않다';
    // if(v == ''){//v.length == 0
    //     console.log('비어있음');
    // } else{
    //     console.log('비어 있지 않다')
    // }

//     if(id.value.length == 0){
//         alert('필수입니다');
//     }
// }

pw2.onkeyup = function(){

    let message = '불일치'
    let bg = 'c1'
    
    if(pw.value == pw2.value){
        message ='일치';
        bg = 'c2';
        pwCheck = true;
    }else if(pw2.value.length == 0){
        message = "";
        pwCheck = false;
    }else{
        pwCheck = false;
    }
    pwResult2.innerText = message;
    pwResult2.className = bg;
};


name.addEventListener("blur", function(){
    if(name.value ==''){
        nameCheck = false;
    }else{
        nameCheck = true;
    }
});

phone.addEventListener("blur", function(){
    if(phone.value ==''){
        phoneCheck = false;
    }else{
        phoneCheck = true;
    }
});

email.addEventListener("blur", function(){
    if(email.value ==''){
        emailCheck = false;
    }else{
        emailCheck = true;
    }
});

pw.addEventListener("change", function(){
    pwCheck = false;
    pw2.value = '';
    pwResult2.innerHTML ='';
    pw2.focus();
});


btn.addEventListener("click", function(){
    if(idCheck && pwCheck && nameCheck && phoneCheck && emailCheck){
        frm.submit();
    }else{
        alert('필수요건을 확인하세요');
    }
    

});




