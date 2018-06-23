function getQuestion() {
    var question = null;
    $.ajax({
        type:'get',
        async:false,
        url:'/getQuestionListOfKind',
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
            "<span class='errorMsg'></span></div>"+
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

function checkAnswer(button) {
    $(button).attr("disabled", false);
    var sumScore = 0;
    var questions = getQuestion();
    for(var i=0; i<questions.length; i++){
        var qDiv = $($('#question').find("div[qid="+ questions[i].id +"]")[0]);
        var answer = $(qDiv.find("input:checked")[0]).val();
        if(answer === questions[i].answer.toUpperCase()){
            $(qDiv.find(".errorMsg")[0]).html();
        }else {
            $(qDiv.find(".errorMsg")[0]).html("答案错误");
            sumScore ++;
        }
    }
    if(sumScore == 0){
        $.ajax({
           type:'post',
            url:'/addQuestionStudyLog',
            async:false,
            success:function (data) {
               console.log(data);
                if(data.status === "SUCCESS"){
                    window.location.href = "/studyPage?classId=1";
                }else{
                    alert("请稍后再试!");
                }
            }
        });
    }else {
        alert("请检查错误答案!");
    }
    $(button).attr("disabled", true);
}