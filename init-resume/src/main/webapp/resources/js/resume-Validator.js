 // 키 다운시 전화번호 양식에 맞게 변환
    $(document).on("keydown", "#info_phone", function() { 
        $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") ); 
    });



  // 전화번호 유효성 검사
  function telValidator(args) {
    const msg = '유효하지 않는 전화번호입니다.';
    // IE 브라우저에서는 당연히 var msg로 변경
    
    if (/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/.test(args)) {
        return true;
    }
    alert(msg);
    return false;
  }

  // 이메일 유효성 검사
  function emailValidator(args) {
    var msg = '유효하지 않는 이메일입니다.';
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(args)) {
        return true;
    }
    alert(msg);
    return false;
  }

  // input 상자 유효성 검사
  function inputValidator(id) {
    var msg = $("#"+id).attr('placeholder') +"값을 넣어주세요.";
    if(!$("#"+id).val()){
      return true;
    }

    alert(msg);
    return false;
  }