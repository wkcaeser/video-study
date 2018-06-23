function videoClassList() {
    $.ajax({
        type:'get',
        url:'/getVideoClass',
        dataType:'json',
        success:function (data) {
            var tbody = $($(".rightdiv").find("tbody")[0]);
            tbody.empty();
            for(var i=0; i<data.length; i++){
                var tr = $("<tr></tr>");
                tr.append($("<td>" + data[i].id + "</td>"));
                tr.append($("<td>" + data[i].name + "</td>"));
                tr.append($("<td>" + data[i].price + "元/人</td>"));
                tr.append($("<td>" + data[i].time + "分钟</td>"));
                tr.append($("<td><button vid='" + data[i].id + "' onclick='editVideoDetail(this)'>详情</button></td>"));
                tr.appendTo(tbody);
            }
        },
        error:function () {
            console.log("get class list error");
        }
    });
}

videoClassList();

function editVideoDetail(button) {
    var id = $(button).attr('vid');
    window.location.href = "/editClassDetail?vid=" + id;
}