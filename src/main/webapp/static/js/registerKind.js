function companyRegister() {
    $('#company').css('display', '');
    $('#employee').css('display', 'none');
}
$('.toollogin').on('click', companyRegister);

function employeeRegister() {
    $('#company').css('display', 'none');
    $('#employee').css('display', '');
}
$('.toolregister').on('click', employeeRegister);

function checkUserAlive() {
    var rkUser = $('#rkUser').val();
    $.ajax({
       type:'get',
        url:'/checkUsername',
        data:{'username':rkUser},
        async:false,
        success:function (data) {
            if(data.status === "SUCCESS"){
                $('#rkUserStatus').html("请输入正确账号");
            }else {
                $('#rkUserStatus').html();
            }
        },
        error:function () {
            console.log("checkUsername");
        }
    });
}

function checkRkUser() {
    var rkUser = $('#rkUser').val();
    if(rkUser === ""){
        $('#rkUserStatus').html("账号不能为空");
        return;
    }
    else {
        $('#rkUserStatus').html("");
    }
    checkUserAlive();
}
$('#rkUser').on('blur', checkRkUser);

function checkRkName() {
    var rkName = $('#rkName').val();
    if(rkName === ""){
        $('#rkNameStatus').html("公司名不能为空");
        return;
    }
    else {
        $('#rkNameStatus').html("");
    }
}
$('#rkName').on('blur', checkRkName);

function checkRkAddress() {
    var rkAddress = $('#rkAddress').val();
    if(rkAddress === ""){
        $('#rkAddressStatus').html("公司地址不能为空");
        return;
    }
    else {
        $('#rkAddressStatus').html("");
    }
}
$('#rkAddress').on('blur', checkRkAddress);

function checkRkOwner() {
    var rkOwner = $('#rkOwner').val();
    if(rkOwner === ""){
        $('#rkOwnerStatus').html("法人姓名不能为空");
        return;
    }
    else {
        $('#rkOwnerStatus').html("");
    }
}
$('#rkOwner').on('blur', checkRkOwner);

function registerKind() {
    $('#rkSubmit').attr('disabled', false);
    var rkUser = $('#rkUser');
    var rkName = $('#rkName');
    var rkAddress = $('#rkAddress');
    var rkOwner = $('#rkOwner');

    if(rkUser.val() === ""){
        $('#rkUserStatus').html("账号不能为空");
        if($('#rkUserStatus').html() !== "")
            return;
        return;
    }

    if(rkName.val() === ""){
        $('#rkNameStatus').html("公司名不能为空");
        return;
    }
    if(rkAddress.val() === ""){
        $('#rkAddressStatus').html("公司地址不能为空");
        return;
    }
    if(rkOwner.val() === ""){
        $('#rkOwnerStatus').html("法人姓名不能为空");
        return;
    }

    var resgisterKindData = {
        'user':rkUser.val(),
        'companyName':rkName.val(),
        'companyAddress':rkAddress.val(),
        'companyOwner':rkOwner.val()
    };

    $.ajax({
        type:'post',
        url:'/registerKind',
        data:resgisterKindData,
        async:false,
        success:function (data) {
            if(data.status === "SUCCESS") {
                alert("注册成功!请等待管理员审批");
                window.location.href = "/";
            }
            else
                alert("注册失败！");
        },
        error:function () {
            console.log("registerKind");
        }
    });
    $('#rkSubmit').attr('disabled', true);
}

$('#rkSubmit').on('click', registerKind);

function checkEUserAlive() {
    var rkEUser = $('#rkEUser').val();
    $.ajax({
        type:'get',
        url:'/checkUsername',
        data:{'username':rkEUser},
        async:false,
        success:function (data) {
            if(data.status === "SUCCESS"){
                $('#rkEUserStatus').html("请输入正确账号");
            }else {
                $('#rkEUserStatus').html();
            }
        },
        error:function () {
            console.log("checkUsername");
        }
    });
}

function checkRkEUser() {
    var rkEUser = $('#rkEUser').val();
    if(rkEUser === ""){
        $('#rkEUserStatus').html("账号不能为空");
        return;
    }
    else {
        $('#rkEUserStatus').html("");
    }
    checkEUserAlive();
}
$('#rkEUser').on('blur', checkRkEUser);

function checkECompanyIdAlive() {
    var companyId = $('#rkCompanyId').val();
    $.ajax({
        type:'get',
        url:'/checkCompanyId',
        data:{'companyId':companyId},
        async:false,
        success:function (data) {
            if(data.status === "SUCCESS"){
                $('#rkCompanyIdStatus').html("请输入正确公司代号");
            }else {
                $('#rkCompanyIdStatus').html();
            }
        },
        error:function () {
            console.log("checkUsername");
        }
    });
}

function checkCompanyId() {
    var companyId = $('#rkCompanyId').val();
    if(companyId === ""){
        $('#rkEUserStatus').html("公司代号不能为空");
        return;
    }
    else {
        $('#rkEUserStatus').html("");
    }
    checkECompanyIdAlive();
}
$('#rkCompanyId').on('blur', checkCompanyId);

function registerEmployee() {
    $('#rkESubmit').attr('disabled', false);
    var companyId = $('#rkCompanyId').val();
    var username = $('#rkEUser').val();
    $.ajax({
        type:'post',
        data:{'username':username, 'companyId':companyId},
        url:'/registerEmployee',
        async:false,
        success:function (data) {
            if(data.status === "SUCCESS"){
                alert("注册成功!请等待管理员审批");
                window.location.href = "/";
            }
            else {
                alert("注册失败！");
                $('#rkESubmit').attr('disabled', true);
            }
        },
        error:function () {
            console.log("register employee error");
        }
    });
}

$('#rkESubmit').on('click', registerEmployee);



