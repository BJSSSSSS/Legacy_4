/**
 * 
 */
 
 console.log('----------------------');
 
const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');

//전체동의
checkAll.addEventListener("click", function(){
    for(ck of check){
        ck.checked = checkAll.checked;
    }

    // for(ck of check){
    //     if(checkAll.checked){   
    //         ck.checked = checkAll.checked;     
    //     }else{
    //         ck.checked = false;  
    //     }  
    // }
});


// 모든것마다 체크이벤트?(동의 전부 누를때 전체동의 자동으로)
for(ck of check){
    ck.addEventListener("click", function(){
        let final = true;

        for(c of check){
            if(!c.checked){
                final = false;
            }
        }

        checkAll.checked = final;
    });
}

const btn = document.getElementById("btn");

btn.addEventListener("click", function(){

    // let c = true;
    // for(ch of check){
    //     if(!ch.checked){
    //         c = false;
    //     }
    // }
    
    // if(check[0].checked&& check[1].checked &&)

    // 이것이 사용되어야 할때가 있음(예시로 전체동의가 아닌 맨 마지막은)
    // 선택동의라 해제가 되도 될경우! 잘 생각해봅시당



    if(checkAll.checked){
        location.href="./join";
    }else{
        alert('약관에 동의하셔야 합니다');
    }
    
    //버튼 누르면 join form으로 이동하는데
    //동의가 전체동의여야 이동
    //아니면 약관에동의하셔야합니다 하고 alert창이 뜸
});

