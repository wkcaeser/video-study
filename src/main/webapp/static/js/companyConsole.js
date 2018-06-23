function getCompanyInfo() {
    $.ajax({
        type:'get',
        dataType:'json',
        url:'/getCompanyInfo',
        async:false,
        success:function (data) {
            $("#id").html(data.id);
            $("#address").html(data.address);
            $("#owner").html(data.owner);
            $("#user").html(data.uname);
            $("#phone").html(data.phone);
        },
        error:function () {
            console.log("get company info error");
        }
    });
}
function classList(){
    $.ajax({
        type:'get',
        url:'/getClassList',
        dataType:'json',
        success:function (data) {
            var tbody = $($("#kclb").find("tbody")[0]);
            tbody.empty();
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].name + "</td>"));
                tr.append($("<td>" + data[i].type + "</td>"));
                tr.append($("<td>" + data[i].price + "元/人</td>"));
                tr.append($("<td>" + 40 + "课时</td>"));
                tr.append($("<td><input id='buyNum' style='width: 30%' type='number' value='5' placeholder='请输入购买数量'></td>"));
                tr.append($("<td><button vid='" + data[i].id + "' onclick='buyClass(this)'>购买</button></td>"));
                tr.appendTo(tbody);
            }
        },
        error:function () {
            console.log("get class list error");
        }
    });
}

function buyClass(button) {
    var buyNum = $("#buyNum").val();
    if(confirm("是否确定购买" + buyNum + "人课程?")) {
        var videoClassId = $(button).attr("vid");
        var companyId = $("#id").html();
        $.ajax({
           type:'post',
            async:false,
            data:{
               'videoClassId':videoClassId,
                'companyId':companyId,
                'buyNum':buyNum
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

function getClassOrderList() {
    var companyId = $("#id").html();
    $.ajax({
        type:'get',
        url:'/getClassOrderList',
        data:{'companyId':companyId},
        dataType:'json',
        success:function (data) {
            var tbody = $($("#ygmkc").find("tbody")[0]);
            tbody.empty();
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].name + "</td>"));
                tr.append($("<td>" + data[i].type + "</td>"));
                tr.append($("<td>" + data[i].price + "元/人</td>"));
                tr.append($("<td>" + 40 + "课时</td>"));
                tr.append($("<td>" + data[i].number + "</td>"));
                if(data[i].status == 0)
                    tr.append($("<td style='color: red'>待付款</td>"));
                else if(data[i].status == 1)
                    tr.append($("<td style='color: green'>可学习</td>"));
                else
                    tr.append($("<td style='color: yellow'>未知</td>"));
                tr.appendTo(tbody);
            }
        },
        error:function () {
            console.log("get class list error");
        }
    });
}

function getUserList() {
    var companyId = $("#id").html();
    $.ajax({
        type:'get',
        url:'/getUserListByCompanyId',
        data:{'companyId':companyId},
        dataType:'json',
        success:function (data) {
            var tbody = $($("#dwxy").find("tbody")[0]);
            tbody.empty();
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].username + "</td>"));
                tr.append($("<td>" + data[i].name + "</td>"));
                tr.append($("<td>" + data[i].phone + "</td>"));
                tr.append($("<td>" + data[i].identityNumber + "</td>"));
                tr.append($("<td style='color: red'>" + data[i].status + "</td>"));
                if(data[i].role == -1){
                    tr.append($("<td><button uid='"+ data[i].id + "' onclick='changeYGStatus(this)'>审批</button></td>"));
                }
                tr.appendTo(tbody);
            }
        },
        error:function () {
            console.log("get class list error");
        }
    });
}

function doChangeAjax(id, role) {
    $.ajax({
        type:'post',
        url:'/getEmployee',
        async:false,
        data:{'id':id, 'role':role},
        success:function (data) {
            if(data.status === "SUCCESS"){
                alert("审批成功");
                getUserList();
            }else {
                alert("审批失败");
            }
        },
        error:function () {
            console.log("employee error");
        }
    });
}

function changeYGStatus(button) {
    var id = $(button).attr("uid");
    if(confirm("审核为您单位员工？（若为管理者请点击“取消”）")){
        doChangeAjax(id, 1);
    }else {
        if(confirm("审核为您单位管理者？")){
            doChangeAjax(id, 3);
        }
    }
}

function showCcb1() {
    classList();
    $("#kclb").css("display", "");
    $("#ygmkc").css("display", "none");
    $("#dwxy").css("display", "none");
}

$("#ccb1").on("click", showCcb1);


function showCcb2() {
    getClassOrderList()
    $("#kclb").css("display", "none");
    $("#ygmkc").css("display", "");
    $("#dwxy").css("display", "none");
}

$("#ccb2").on("click", showCcb2);


function showCcb3() {
    getUserList();
    $("#kclb").css("display", "none");
    $("#ygmkc").css("display", "none");
    $("#dwxy").css("display", "");
}

$("#ccb3").on("click", showCcb3);

function requestLicense() {
    $.ajax({
       type:'post',
        url:'/requestLicense',
        success:function (data) {
            if(data.status==="SUCCESS"){
                alert("已提交申请!");
            }else {
                alert("不满足申请条件!");
            }
        }
    });
}


getCompanyInfo();
classList();