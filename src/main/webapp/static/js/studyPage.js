function getVideoList() {
    var id = $("#classList").attr("cid");
    $.ajax({
        type:'get',
        data:{'id':id},
        dataType:'json',
        url:'/getQuestionInfoList',
        success:function (data) {
            var tbody = $($('#classList').find('tbody')[0]);
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].description + "</td>"));
                tr.append($("<td class='time'>0学时</td>"));
                tr.append($("<td>未完成</td>"));
                tr.append($("<td><button qid='" + data[i].id + "' onclick='startStudy(this)'>学习</button></td>"))
                tr.appendTo(tbody);
                getStatus(tr);
            }
        },
        error:function () {
            console.log("get video list error");
        }
    });
}

getVideoList();

function startStudy(button) {
    var qid = $(button).attr('qid');
    window.location.href = "/StudyQuestion/" + qid;
}

function getStatus(element) {
    var tr = $(element);
    var qid = $(tr.find("td")[0]).html();
    $.ajax({
        type:'get',
        url:'/getQuestionStudyStatus',
        data:{'qid':qid},
        success:function (data) {
            if(data.status === "SUCCESS"){
                $(tr.find("td")[3]).html("已完成");
                $(tr.find("td")[3]).css("color", "green");
            }
        }
    });
    $.ajax({
        type:'get',
        url:'/getQuestionStudyTime',
        data:{'qid':qid},
        success:function (data) {
                $(tr.find("td")[2]).html(data.status + "学时");
        }
    })
}
