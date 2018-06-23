function login() {
    //checkValidateCode();
    if(!($("#validateStatus").html() === 'SUCCESS')) {
        $("#validateStatus").html('请输入正确验证码');
        return;
    }
    var username = $('#username').val();
    var password = $('#password').val();
    var validateCode = $('#validateText').val();
    $.ajax({
        url:'login',
        type:'post',
        dataType:'json',
        data:{
            'username':username,
            'password':password,
            'validateCode':validateCode
        },
        success:function (data) {
          if(data.status === "ERROR"){
              $("#loginStatus").html("账号或者密码错误！");
          }else {
              if(data.status === "-1"){
                  $("#loginStatus").html("您的账号未审核，请等待管理员审核！");
              }
              else {
                  window.location.href = "/getUserPage";
              }
          }
        },
        error:function () {
          console.log('login error');
        }
    });
}

$('#submit').on('click', login);