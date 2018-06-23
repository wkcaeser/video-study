<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${kind}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/questionPractice.css">
</head>
<body style="background-color: steelblue">
<div style="position: fixed;right: 0px;width:8%;background: whitesmoke"><h3>本次学习时间：</h3><h2 id="time">0</h2></div>
<div style="margin-top: 2%; margin-left: 10%; margin-right: 10%; background-color:whitesmoke; padding-left: 3%; padding-right: 3%; padding-top: 3%">
        <div id="question">

        </div>

        <button class="btn btn-default form-control"
                style="width:100%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;" onclick="checkAnswer(this)">提交</button>
    </div>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/lawPage.js"></script>
<script src="${pageContext.request.contextPath}/static/js/questionPractice.js"></script>
</body>
</html>
