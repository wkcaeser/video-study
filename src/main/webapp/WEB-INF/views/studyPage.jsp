<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食品安全知识学习</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manager.css">
</head>
<body>
<div class="toolbar">
    <div class="toolleft">
        <p class="toolp">湖北省钟祥市食品安全知识网络学习参训单位平台</p>
    </div>

    <div style="background: black;float: right; margin-right: 10%; margin-top: 2%">
        <a href="/getUserPage">返回个人中心</a>
    </div>
</div>

<div style="background: #f5f5f5; min-height: 90%" cid="${classId}" id="classList">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><h3>课程列表</h3><span style="color: green">已学习时长：${time}学时</span>
            <div style="float: right"></div>
        </div>
        <!-- Table -->
        <table class="table">
            <thead><tr>
                <th>编号</th>
                <th>课程名称</th>
                <th>已学习时长</th>
                <th>学习状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/studyPage.js"></script>
</body>
</html>
