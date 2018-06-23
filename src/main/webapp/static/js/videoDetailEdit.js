function getClassName() {
    var id = $("#classId").val();
    $.ajax({
        type:'get',
        data:{'id':id},
        url:'/getClassName',
        success:function (data) {
            $('#className').html(data.status);
        },
        error:function () {
            console.log("get class name error");
        }
    });
}
getClassName();

function getVideoList() {
    var id = $("#classId").val();
    $.ajax({
        type:'get',
        data:{'id':id},
        dataType:'json',
        url:'/getVideoList',
        success:function (data) {
            var tbody = $($('.rightDiv').find('tbody')[0]);
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].name + "</td>"));
                tr.append($("<td>" + data[i].time + "分钟</td>"));
                tr.appendTo(tbody);
            }
        },
        error:function () {
            console.log("get video list error");
        }
    });
}

getVideoList();