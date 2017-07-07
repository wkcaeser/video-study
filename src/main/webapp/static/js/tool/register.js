function checkUsername() {
    var usernameStatus = $('#r_usernameStatus');
    var username = $('#r_username');
    if(username.val() === ""){
        usernameStatus.html("请输入用户名");
        return;
    }
    $.ajax({
        type:'get',
        url:'checkUsername',
        data:{'username':username.val()},
        success:function (data) {
            if(data.status === 'SUCCESS'){
                usernameStatus.html("");
            }
            else {
                usernameStatus.html("用户名不可用");
            }
        },
        error:function () {
           console.log("用户名不可用");
        }
    });
}

$("#r_username").on("blur", checkUsername);

function checkPassword() {
    var password = $('#r_username');
    var passwordStatus = $('#r_passwordStatus');
    if(password.val() === ""){
        passwordStatus.html("请输入密码");
        return;
    }else{
        passwordStatus.html("");
    }
}
$("#r_password").on("blur", checkPassword);
$("#r_repeatPassword").on("click", checkPassword);

function checkPasswordRepeat() {
    var password = $('#r_password');
    var passwordStatus = $('#r_passwordStatus');
    var repeatPassword = $("#r_repeatPassword");
    var repeatPasswordStatus = $("#r_passwordRepeatStatus");
    if(password.val() === ""){
        passwordStatus.html("请输入密码");
        return;
    }else{
        passwordStatus.html("");
    }
    if(repeatPassword.val() === password.val()){
        repeatPasswordStatus.html("");
    }else {
        repeatPasswordStatus.html("密码输入不一致");
    }
}

$("#r_repeatPassword").on("blur", checkPasswordRepeat);

function checkName() {
    if($("#r_name").val() === ""){
        $("#r_nameStatus").html("姓名不能为空");
        return
    }else {
        $("#r_nameStatus").html("");
    }
}
$("#r_name").on("blur", checkName);

function checkPhone() {
    if($("#r_phone").val() === ""){
        $("#r_phoneStatus").html("姓名不能为空");
        return
    }else {
        $("#r_phoneStatus").html("");
    }
}
$("#r_phone").on("blur", checkPhone);


function checkIdentity() {
    if($("#r_identityNumber").val() === ""){
        $("#r_identityStatus").html("姓名不能为空");
        return
    }else {
        $("#r_identityStatus").html("");
    }
}
$("#r_identityNumber").on("blur", checkIdentity);

function register() {
    var username = $("#r_username");
    var password = $("#r_password");
    var name = $("#r_name");
    var phoneNumber = $("#r_phone");
    var identityNumber = $("#r_identityNumber");

    if(username.val() === ""){
        $("#r_usernameStatus").html("用户名不能为空");
        return;
    }

    if(password.val() === ""){
        $("#r_passwordStatus").html("密码不能为空");
        return;
    }

    if(name.val() === ""){
        $("#r_nameStatus").html("姓名不能为空");
        return;
    }

    if(phoneNumber.val() === ""){
        $("#r_phoneStatus").html("电话号不能为空");
        return;
    }

    if(identityNumber.val() === ""){
        $("#r_identityStatus").html("身份证号不能为空");
        return;
    }
    var registerData = {
        'username':username.val(),
        'password':password.val(),
        'name':name.val(),
        'phone':phoneNumber.val(),
        'identityNumber':identityNumber.val()
    };

    $.ajax({
        type:'post',
        url:'/register',
        data:JSON.stringify(registerData),
        success:function (data) {
            console.log(data);
        },
        error:function () {
            console.log("register");
        }
    });
}

$("#r_submit").on("click", register);