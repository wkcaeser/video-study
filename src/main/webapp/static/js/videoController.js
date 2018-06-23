//获取vedio jquery对象
var video = $("#video");

//播放暂停功能
$("#playControl").on('click', function() {
    if(video[0].paused) {
        video[0].play();
    }
    else {
        video[0].pause();
    }
    return false;
});

//秒数转化为h：m：s格式
function toDateString(data) {
    var h = parseInt(data/3600);
    var m = parseInt(data%3600/60);
    var s = parseInt(data%3600%60);
    var dataString = "";

    dataString +="" + h + ":";
    dataString +="" + m + ":";
    dataString +="" + s;

    return dataString;
}

//获取视频时长
video.on('loadedmetadata', function() {
    $('#all').text(toDateString(video[0].duration));
});

//获取视频当前观看时长
//update HTML5 video current play time
video.on('timeupdate', function() {
    $('#current').text(toDateString(video[0].currentTime));
    if(video[0].duration === video[0].currentTime){
        //观看时长发送后台进行是否观看完成的判断
        sendLooked(video[0].currentTime);
    }
});

//视频进度条
video.on("timeupdate", function () {
    $("#childDiv").css("width", "" + video[0].currentTime/video[0].duration*100 + "%");
})

//想后台发送currenttime 进行时长匹配判断用户是否观看完视频
function sendLooked() {
    var vid = $("#videoWindow").attr("vid");
    var cid = $("#videoWindow").attr("cid");
    $.ajax({
        type:'post',
        data:{'vid':vid},
        async:false,
        url:"/finishLook",
        success:function (data) {
            if(data.status === "SUCCESS"){
                window.location.href = "/studyPage?classId=" + cid;
            }
        }
    });
}
