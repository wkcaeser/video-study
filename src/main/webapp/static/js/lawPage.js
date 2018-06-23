var ss = 0;
var mm = 0;

var hasSendMins = 0;

function addTime() {
    var time = $('#time');
    var str = "";
    if(++ss==60)
    {
        mm++;
        ss=0;

        if(mm - hasSendMins >= 5){
            sendTime(5);
            hasSendMins += 5;
        }
    }
    str+=mm<10?"0"+mm:mm;
    str+=":";
    str+=ss<10?"0"+ss:ss;

    time.html(str);
}

setInterval(addTime, 1000);

function sendTime(time) {
    $.ajax({
        type:'post',
        data:{"time":time},
        url:'/setNewStudyTime'
    })
}

window.onbeforeunload = function(){sendTime(mm-hasSendMins);};