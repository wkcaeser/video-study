function doIt(button) {
    $(button).attr('disabled', false);
    var username = $('#username').val();
    var password = $('#password').val();
    $.ajax({
        type:'post',
        url:'/rengongchange',
        data:{"username":username, "password":password},
        success:function (data) {
                $(button).attr('disabled', true);
                alert(data.status);
        },
        error:function () {
            $(button).attr('disabled', true);
            console.log("操作失败");
        }
    });
}