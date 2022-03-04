const title = document.getElementById('title');
const writer = document.getElementById('writer');
const btn = document.getElementById('btn');
const frm = document.getElementById('frm');



let titleCheck = false;
let writerCheck = false;

title.addEventListener("blur", function(){
    if(title.value == ''){
        titleCheck = false;
    }else{
        titleCheck = true;
    }
});

writer.addEventListener("blur", function(){
    if(writer.value == ''){
        writerCheck = false;
    }else{
        writerCheck = true;
    }
});

btn.addEventListener("click", function(){

    if(titleCheck && writerCheck){
       frm.submit();
    }else{
        alert('필수요건을 확인하세요');
    }

});


