<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>单位管理平台</title>
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

    <div style="float: right; margin-right: 10%; margin-top: 2%">
        <a href="/">返回登录界面</a>
    </div>
</div>

<div class="managerleft" style="min-height: 90%">
    <div class="list-group managerinfomargin">
        <li class="list-group-item active">
            参训单位信息
        </li>
        <li class="list-group-item">单位ID：&nbsp;&nbsp;&nbsp;<label id="id"></label></li>
        <li class="list-group-item">单位地址：&nbsp;&nbsp;&nbsp;<label id="address"></label></li>
        <li class="list-group-item">单位法人：&nbsp;&nbsp;&nbsp;<label id="owner"></label></li>
        <li class="list-group-item">申请人：&nbsp;&nbsp;&nbsp;<label id="user"></label></li>
        <li class="list-group-item">联系电话：&nbsp;&nbsp;&nbsp;<label id="phone"></label></li>
    </div>

    <div class="list-group managerinfomargin">
        <li class="list-group-item" id="ccb1">查看课程</li>
        <li class="list-group-item" id="ccb2">已购买课程</li>
        <li class="list-group-item" id="ccb3">查看员工</li>
        <li class="list-group-item" id="ccb4" onclick="requestLicense()">申请证书</li>
    </div>
</div>

<div class="managerright" id="kclb" style="min-height: 90%">
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
                <th>课程价格</th>
                <th>课程时长</th>
                <th>购买数量</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<div class="managerright" id="ygmkc" style="min-height: 90%; display: none">
    <div class="panel panel-default studyinfo">
        <!-- Default panel contents -->
        <div class="panel-heading">已购买课程列表
            <div style="float: right"></div>
        </div>
        <!-- Table -->
        <table class="table">
            <thead><tr>
                <th>编号</th>
                <th>课程名称</th>
                <th>课程类型</th>
                <th>课程价格</th>
                <th>课程时长</th>
                <th>购买数量</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<div class="managerright" id="dwxy" style="min-height: 90%; display: none">
    <div class="panel panel-default studyinfo">
        <!-- Default panel contents -->
        <div class="panel-heading">参与学习员工列表
            <div style="float: right"></div>
        </div>
        <!-- Table -->
        <table class="table">
            <thead><tr>
                <th>编号</th>
                <th>账号</th>
                <th>姓名</th>
                <th>电话</th>
                <th>身份证</th>
                <th>学习状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/js/companyConsole.js"></script>
</body>
</html>
