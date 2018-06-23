<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>试题测试系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/question.css" rel="stylesheet">
</head>
<body>
<div class="leftAbsolute">
    <button class="btn btn-info startButton" onclick="startExam(this)">开始测试</button>
    <button class='btn btn-info startButton' id="timer" style="display: none"></button>
    <button class="btn btn-info startButton" style="display: none" onclick="submit()" id="submit">交卷</button>
</div>
<div class="rightAbsolute">
    <h4>测试时间为60分钟！</h4>
    <h4>点击“开始测试”按钮开始进行测试！</h4>
    <h4>测试时间到将自动交卷！</h4>
    <h4>答题完成后可点击“交卷”按钮！</h4>
    <h4>得分60以上及格！</h4>
</div>
<div id="tag" style="margin-left: 25%; margin-right: 25%;">
    <h3 style="margin-top: 30%">请点击“开始测试”按钮开始测试！</h3>
</div>
<div id="question" style="margin-left: 25%; margin-right: 25%; display: none">
</div>
<script src="${pageContext.request.contextPath}/static/js/question.js"></script>
</body>
</html>
