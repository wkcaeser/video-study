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

function getStudentInfo() {
    $.ajax({
        type:'get',
        url:'/getStudentInfo',
        dataType:'json',
        async:false,
        success:function (data) {
            $("#id").html(data.id);
            $("#name").html(data.name);
            $("#company").html(data.company);
            $("#phone").html(data.phone);
        },
        error:function () {
            console.log("get company info error");
        }
    });
}
getStudentInfo();

function payedClassList() {
    $.ajax({
        type:'get',
        url:'/getPayedClass',
        dataType:'json',
        success:function (data) {
            var tbody = $($("#payedClassList").find("tbody")[0]);
            tbody.empty();
            var role = $("#role").html();
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].className + "</td>"));
                var date = new Date();
                date.setTime(data[i].time);
                tr.append($("<td>" + date.Format("yyyy-MM-dd") + "</td>"));
                if(data[i].status > 0) {
                    tr.append($("<td><button vid='" + data[i].classId + "' onclick='studyPage(this)'>学习</button></td>"));
                }
                else {
                    tr.append($("<td style='background: red'>待付款</td>"));
                }
                tr.appendTo(tbody);
            }
        },
        error:function () {
            console.log("get class list error");
        }
    });
}
payedClassList();

function classList(){
    $.ajax({
        type:'get',
        url:'/getClassList',
        dataType:'json',
        success:function (data) {
            var tbody = $($("#classList").find("tbody")[0]);
            tbody.empty();
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].name + "</td>"));
                tr.append($("<td>" + data[i].type + "</td>"));
                tr.append($("<td>" + data[i].price + "元/人</td>"));
                tr.append($("<td><button vid='" + data[i].id + "' onclick='buyClass(this)'>购买</button></td>"));
                tr.appendTo(tbody);
            }
        },
        error:function () {
            console.log("get class list error");
        }
    });
}


function showPayedClassList() {
    payedClassList();
    $('#payedClassList').css('display', "");
    $('#classList').css('display', "none");
}
$('#payedClassListButton').on('click', showPayedClassList);

function showClassList() {
    classList();
    $('#payedClassList').css('display', "none");
    $('#classList').css('display', "");
}
$('#classListButton').on('click', showClassList);

function studyPage(button) {
    var classId = $(button).attr('vid');
    window.location.href = "/studyPage?classId=" + classId;
}

function buyClass(button) {
    if(confirm("是否确定购买课程?")) {
        var classId = $(button).attr("vid");
        $.ajax({
            type:'post',
            async:false,
            data:{
                'classId':classId,
            },
            url:'/buyClass',
            success:function (data) {
                if(data.status === "SUCCESS"){
                    alert("订单提交成功，请向管理员付款审批!");
                }else {
                    alert("订单提交失败!");
                }
            },
            error:function () {
                console.log("buy class error");
            }
        });
    }else {
        return;
    }
}

function requestOverStudy() {
    $.ajax({
        type:'post',
        url:'/checkTimeEnough',
        success:function (data) {
            if(data.status === "SUCCESS"){
                window.location.href = "/question";
            }
            else if(data.status === "WARNING"){
                alert("已完成学习及证书申请!请联系管理员领取");
            }
            else {
                alert("未完成学习！");
            }
        },
        error:function () {
            console.log("over study error");
        }
    })
}