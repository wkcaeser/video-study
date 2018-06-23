/**
 * 刷新验证码
 */
function refreshValidateCode() {
    $.ajax({
        type:'post',
        url:'/validateCode',
        success:function (data) {
            var img = $("#validateCode");
            img.attr("src", "data:image/jpg;base64,"+data);
        },
        error:function () {
            console.log("validateCode gg !");
        }
    })
}

function checkValidateCode() {
    var code = $("#validateText").val();
    code = {'code' : code};
    $.ajax({
        type:"GET",
        url:"/checkValidateCode",
        dataType:"json",
        contentType: "application/json",
        data:code,
        async:false,
        success:function (data) {
            var status = data.status;
            $("#validateStatus").html(status);
        },
        error:function (data) {
            console.log("error : " + data);
        }
    })
}
$("#refreshValidateCode").on("click", refreshValidateCode);
$("#validateText").on("blur", checkValidateCode);
$(document).ready(refreshValidateCode);
