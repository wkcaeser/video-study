function login() {
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
        data:{
            'username':username,
            'password':password,
            'validateCode':validateCode
        },
        success:function (data) {
          console.log(data);
        },
        error:function () {
          console.log('login error');
        }
    });
}

$('#submit').on('click', login);