function memberIdCheck() {
    const memberId = $("memberId").val();
    if (memberId == "") {
        alert("아이디를 입력해주세요 필수항목입니다");
        $("#memberId").focus();
        return false;
    }
    $.ajax({
        type: "get",
        url: "register_form",
        data: {"memberId": memberId},
        dataType: JSON,

        success: function (result) {
            if (result.result == "0") {
                confirm("사용 가능한 아이디입니다")
            return false
            }else if (result.result == "1") {
                alert("이미 사용중인 아이디입니다");
                $("#memberId").focus();
            }else{
                alert("success이지만 result 값이 undefined 잘못된");
            }
        },
        error: function (request, status, error) {
            alert("ajax 실행 실패");
            alert("code:" + reuqest.status + "\n" + "error :" + error);
        },

    })
}