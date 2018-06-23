<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工学习界面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manager.css">
</head>
<body>
<div class="toolbar">
    <div class="toolleft">
        <p class="toolp">湖北省钟祥市食品安全知识网络学习员工学习平台</p>
    </div>

    <div style="float: right; margin-right: 10%; margin-top: 2%;background: black;">
        <a href="/">返回登录界面</a>
    </div>
</div>

<div class="managerleft" style="min-height: 90%">
    <div class="list-group managerinfomargin">
        <li class="list-group-item active">
            参训单位信息
        </li>
        <li class="list-group-item">用户ID：&nbsp;&nbsp;&nbsp;<label id="id"></label></li>
        <li class="list-group-item">姓名：&nbsp;&nbsp;&nbsp;<label id="name"></label></li>
        <li class="list-group-item">单位名称：&nbsp;&nbsp;&nbsp;<label id="company"></label></li>
        <li class="list-group-item">联系电话：&nbsp;&nbsp;&nbsp;<label id="phone"></label></li>
    </div>

    <div class="list-group managerinfomargin">
        <li class="list-group-item" id="payedClassListButton" cid="">可学习课程</li>
        <li class="list-group-item" id="classListButton" cid="">可学习课程</li>
        <li class="list-group-item" id="ccb4" onclick="requestOverStudy()">申请证书</li>
    </div>
</div>

<div class="managerright" id="payedClassList" style="min-height: 90%">
    <div class="panel panel-default studyinfo">
        <!-- Default panel contents -->
        <div class="panel-heading">可学习课程列表
            <div style="float: right"></div>
        </div>
        <!-- Table -->
        <table class="table">
            <thead><tr>
                <th>编号</th>
                <th>课程名称</th>
                <th>购课时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<div class="managerright" id="classList" style="min-height: 90%; display: none">
    <div class="panel panel-default studyinfo">
        <!-- Default panel contents -->
        <div class="panel-heading">课程列表
            <div style="float: right"></div>
        </div>
        <!-- Table -->
        <table class="table">
            <thead><tr>
                <th>编号</th>
                <th>课程名称</th>
                <th>课程类型</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/js/employeePage.js"></script>
</body>
</html>
