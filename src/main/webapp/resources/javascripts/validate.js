function validate(){
    var re = /^[a-zA-Z0-9]{4,12}$/;

    var mid = document.getElementById('mid');
    var mpass = document.getElementById('mpass');
    var mname = document.getElementById('mname');
    
    if(join.mpass.value != join.mpassChk.value){
        alert('비밀번호가 다릅니다. 다시 확인해 주세요.');
        join.mpassChk.value = "";
        join.mpassChk.focus();
        return false;
    }

    if(!check(re,mid,"아이디는 4~12자의 영문대소문자와 숫자로만 입력하세요.")){
        return false;
    }
    if(!check(re,mpass,"비밀번호는 4~12자의 영문대소문자와 숫자로만 입력하세요")){
        return false;
    }
    if(mname.value===""){
        alert('이름을 입력하세요');
        return false;
    }

}

function check(re,str,message){
    if(re.test(str.value)){
        return true;
    }
    alert(message);
    str.focus();
}