//格式化时间
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

//获取用户信息
function getUserInfoPage(page) {
    var dataArray = null;
    $.ajax({
        type:'get',
        url:'/getUserInfoPage',
        data:{'page':page},
        dataType:'json',
        async:false,
        success:function (data) {
            dataArray = data;
        },
        error:function () {
            console.log("get user information error");
        }
    })
    return dataArray;
}

//获取课程订单列表
function getOrderPage(page) {
    var dataArray = null;
    $.ajax({
        type:'get',
        url:'/getOrderPage',
        data:{'page':page},
        dataType:'json',
        async:false,
        success:function (data) {
            dataArray = data;
        },
        error:function () {
            console.log("get user information error");
        }
    })
    return dataArray;
}

//获取证书申请列表
function getLicensePage(page) {
    var dataArray = null;
    $.ajax({
        type:'get',
        url:'/getLicensePage',
        data:{'page':page},
        dataType:'json',
        async:false,
        success:function (data) {
            dataArray = data;
        },
        error:function () {
            console.log("get user information error");
        }
    })
    return dataArray;
}
//----------------------------------------------------------------------------------
//填充用户列表
function updateyhdiv(dataArray) {
    var tbody = $('#ckyhdiv').find('tbody')[0];
    $(tbody).empty();
    for(var i=0; i<dataArray.length; i++){
        var tr = $('<tr></tr>');
        tr.append($('<td>'+ dataArray[i].id + '</td>'));
        tr.append($('<td>'+ dataArray[i].username + '</td>'));
        tr.append($('<td>'+ dataArray[i].name + '</td>'));
        tr.append($('<td>'+ dataArray[i].phone + '</td>'));
        tr.append($('<td>'+ dataArray[i].sex + '</td>'));
        tr.append($('<td>'+ dataArray[i].identityNumber + '</td>'));
        tr.append($('<td>'+ dataArray[i].company + '</td>'));
        tr.append($("<td style='color: red'>" + dataArray[i].status + "</td>"));
        tr.appendTo($(tbody));
    }
}

//填充证书申请列表
function updateLicenseDiv(dataArray) {
    var tbody = $('#licensediv').find('tbody')[0];
    $(tbody).empty();
    for(var i=0; i<dataArray.length; i++){
        var tr = $('<tr></tr>');
        tr.append($('<td>'+ dataArray[i].id + '</td>'));
        tr.append($('<td>'+ dataArray[i].name + '</td>'));
        tr.append($('<td>'+ dataArray[i].phone + '</td>'));
        tr.append($('<td>'+ dataArray[i].score + '</td>'));
        var date = new Date();
        date.setTime(dataArray[i].time);
        tr.append($("<td>" + date.Format("yyyy-MM-dd") + "</td>"));
        if(dataArray[i].status == 0)
            tr.append($("<td style='color: red'>待发放</td>"));
        else if(dataArray[i].status == 1)
            tr.append($("<td style='color: green'>已发放</td>"));
        if(dataArray[i].status == 0)
            tr.append($("<td><button cid='" + dataArray[i].id + "' onclick='sendLicense(this)'>发放</button></td>"));
        tr.appendTo($(tbody));
    }
}

//填充课程订单列表
function updateOrderList(dataArray) {
    var tbody = $('#ckkcdddiv').find('tbody')[0];
    $(tbody).empty();
    for(var i=0; i<dataArray.length; i++){
        var tr = $("<tr></tr>");
        tr.append($("<td>" + dataArray[i].id + "</td>"));
        tr.append($("<td>" + dataArray[i].className + "</td>"));
        tr.append($("<td>" + dataArray[i].price + "元/人</td>"));
        tr.append($("<td>" + dataArray[i].uname + "</td>"));
        var date = new Date();
        date.setTime(dataArray[i].time);
        tr.append($("<td>" + date.Format("yyyy-MM-dd") + "</td>"));
        if(dataArray[i].status == 0)
            tr.append($("<td style='color: red'>待付款</td>"));
        else if(dataArray[i].status == 1)
            tr.append($("<td style='color: green'>可学习</td>"));
        else
            tr.append($("<td style='color: yellow'>未知</td>"));
        if(dataArray[i].status == 0)
            tr.append($("<td><button oid='" + dataArray[i].id + "' onclick='changeBuyStatus(this)'>确认收款</button></td>"));
        tr.appendTo(tbody);
    }
}

//-----------------------------------------------------------------------------------

//用户
function getPageNumOfyh() {
    var num = $($($('#ckyhdiv').find('.panel-heading')[0]).find('button')[0]).attr('page');
    return num;
}

function setPageNumOfyh() {
    var length = $($('#ckyhdiv').find('tbody')[0]).find('tr').length;
    if(length < 8){
        $($($('#ckyhdiv').find('.panel-heading')[0]).find('button')[0]).attr('page', 1);
        return;
    }
    var num = $($($('#ckyhdiv').find('.panel-heading')[0]).find('button')[0]).attr('page');
    $($($('#ckyhdiv').find('.panel-heading')[0]).find('button')[0]).attr('page', parseInt(num)+1);
}

//订单
function getPageNumOfOrder() {
    var num = $($($('#ckkcdddiv').find('.panel-heading')[0]).find('button')[0]).attr('page');
    return num;
}
function setPageNumOfOrder() {
    var length = $($('#ckkcdddiv').find('tbody')[0]).find('tr').length;
    if(length < 8){
        $($($('#ckkcdddiv').find('.panel-heading')[0]).find('button')[0]).attr('page', 1);
        return;
    }
    var num = $($($('#ckkcdddiv').find('.panel-heading')[0]).find('button')[0]).attr('page');
    $($($('#ckkcdddiv').find('.panel-heading')[0]).find('button')[0]).attr('page', parseInt(num)+1);
}

//证书
function getPageNumOfLicense() {
    var num = $($($('#licensediv').find('.panel-heading')[0]).find('button')[0]).attr('page');
    return num;
}
function setPageNumOfLicense() {
    var length = $($('#licensediv').find('tbody')[0]).find('tr').length;
    if(length < 8){
        $($($('#licensediv').find('.panel-heading')[0]).find('button')[0]).attr('page', 1);
        return;
    }
    var num = $($($('#licensediv').find('.panel-heading')[0]).find('button')[0]).attr('page');
    $($($('#licensediv').find('.panel-heading')[0]).find('button')[0]).attr('page', parseInt(num)+1);
}

//-----------------------------------------------------------------

function nextPageOfLicense() {
    setPageNumOfLicense();
    updateLicenseDiv(getLicensePage(getPageNumOfLicense()));
}

function nextPageOfOrder() {
    setPageNumOfOrder();
    updateOrderList(getOrderPage(getPageNumOfOrder()));
}

function nextPageOfyh() {
    setPageNumOfyh();
    updateyhdiv(getUserInfoPage(getPageNumOfyh()));
}

updateyhdiv(getUserInfoPage(1));
//----------------------------------------------------
//订单
function showOrderList() {
    updateOrderList(getOrderPage(1));
    $($($('#ckkcdddiv').find('.panel-heading')[0]).find('button')[0]).attr('page', 1);
    $('#ckyzcgsdiv').css('display', 'none');
    $('#ckdshgsdiv').css('display', 'none');
    $('#ckyhdiv').css('display', 'none');
    $('#ckkcdddiv').css('display', '');
    $('#licensediv').css('display', "none");
}
$('#ckkcdd').on('click', showOrderList);

//用户
function showckyhdiv() {
    updateyhdiv(getUserInfoPage(1));
    $($($('#ckyhdiv').find('.panel-heading')[0]).find('button')[0]).attr('page', 1);
    $('#ckyzcgsdiv').css('display', 'none');
    $('#ckdshgsdiv').css('display', 'none');
    $('#ckyhdiv').css('display', '');
    $('#ckkcdddiv').css('display', 'none');
    $('#licensediv').css('display', "none");
}
$('#ckyh').on('click', showckyhdiv);
//证书
function showLicensediv() {
    updateLicenseDiv(getLicensePage(1));
    $($($('#licensediv').find('.panel-heading')[0]).find('button')[0]).attr('page', 1);
    $('#ckyzcgsdiv').css('display', 'none');
    $('#ckdshgsdiv').css('display', 'none');
    $('#ckyhdiv').css('display', 'none');
    $('#ckkcdddiv').css('display', 'none');
    $('#licensediv').css('display', "");
}
$('#zsgl').on('click', showLicensediv);

function changeBuyStatus(button) {
    var orderId = $(button).attr('oid');
    if(confirm("确实收款？")) {
        $.ajax({
            type: 'post',
            data: {'orderId': orderId},
            async: false,
            url: '/changeBuyStatus',
            success: function (data) {
                if(data.status === "SUCCESS"){
                    updateOrderList(getOrderPage(1));
                }
            }
        });
    }else {
        return;
    }
}

function sendLicense(button) {
    if(!confirm("确认发放证书？"))
        return;
    var id = $(button).attr("cid");
    $.ajax({
        type:'post',
        url:'/sendLicense',
        data:{'id':id},
        success:function (data) {
            if(data.status === "SUCCESS"){
                alert("发放证书成功!");
                updateLicenseDiv(getLicensePage(1));
            }else{
                alert("发放证书失败!");
            }
        },
        error:function () {
            console.log("send license error");
        }
    });
}