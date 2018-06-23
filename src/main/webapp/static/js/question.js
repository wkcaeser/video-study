function getQuestion() {
    var question = null;
    $.ajax({
        type:'get',
        async:false,
        url:'/getQuestionListOfExam',
        success:function (data) {
            question = data;
        },
        error:function () {
            console.log("get question error");
        }
    });
    return question;
}

function setQuestion() {
    var questions = getQuestion();
    var page = $('#question');
    for (var i=0; i<questions.length; i++){
        var question = $("<div class='questionDiv' qid='" + questions[i].id + "'>" +
        "<div class='question' >" +
            "<strong>"+ parseInt(i+1) +"、</strong><span>"+ questions[i].description +"</span><span class='errorMessage'></span>" +
            "</div>"+
            "<div class='answer'>"+
            "<p><input name='answer" +questions[i].id+"' type='radio' value='A'>&nbsp;&nbsp;<span>A、</span><span class='answerA'>"+ questions[i].answerA +"</span></p>"+
            "<p><input name='answer" +questions[i].id+"' type='radio' value='B'>&nbsp;&nbsp;<span>B、</span><span class='answerB'>"+ questions[i].answerB +"</span></p>"+
            "<p><input name='answer" +questions[i].id+"' type='radio' value='C'>&nbsp;&nbsp;<span>C、</span><span class='answerC'>"+ questions[i].answerC +"</span></p>"+
            "<p><input name='answer" +questions[i].id+"' type='radio' value='D'>&nbsp;&nbsp;<span>D、</span><span class='answerD'>"+ questions[i].answerD +"</span></p>"+
            "</div>"+
            "</div>")
        page.append(question);
    }
}

setQuestion();

function getAnswer() {
    var json = "";
    var answerDivs = $("#question").find(".questionDiv");
    for(var i=0; i<answerDivs.length; i++){
        var answerJson = "";
        var qid = $(answerDivs[i]).attr("qid");
        var answerButton = $($(answerDivs[i]).find("input:checked")[0]);
        answerJson = '{"qid":"' + qid + '", "aid":"' + answerButton.attr("value")+ '"}';
        if(i == 0){
            json += answerJson;
        }else {
            json += ","+answerJson;
        }
    }
    json = "[" + json + "]";
    return json;
}

function getResponse() {
    $.ajax({
        type:'post',
        url:'/checkAnswer',
        contentType:"application/json",
        data:getAnswer(),
        dataType:'json',
        success:function (data) {
            if(data.status === "SUCCESS"){
                $($('#tag').find('h3')[0]).html("恭喜您，已通过考试！请等待证书发放");
                $('#tag').css('display', '');
                $('#question').css('display', 'none');
                window.location.href = "/getUserPage";
            }else {
                $($('#tag').find('h3')[0]).html("未通过考试，请再接再厉！")
                $('#tag').css('display', '');
                $('#question').css('display', 'none');
            }
        },
        error:function () {
            console.log("check answer error");
        }
    });
}
var timerId = 0;
function submit() {
    if(confirm("是否确认交卷？")) {
        clearInterval(timerId);
        $('#submit').attr('disabled', false);
        getResponse();
    }
}

function clock() {
    var mm = 0;
    var ss = 0;
    var str = '';
    timerId = setInterval(function(){
        if($('#timer').html() === "60:00"){
            clearInterval(timerId);
            getResponse();
            return;
        }
        str = "";
        if(++ss==60)
        {
            mm++;
            ss=0;
        }
        str+=mm<10?"0"+mm:mm;
        str+=":";
        str+=ss<10?"0"+ss:ss;
        $('#timer').html(str);
    },1000);
}

function startExam(button) {
    $(button).css("display", "none");
    $('#submit').css('display', "");
    $('#tag').css('display', 'none');
    $('#question').css('display', '');
    var timer = $('#timer');
    timer.css("display", "");
    timer.html("00:00");
    clock();
}