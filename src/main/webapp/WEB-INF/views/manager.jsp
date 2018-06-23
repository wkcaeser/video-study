<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manager.css">
</head>
<body style="background-color: #9d9d9d;">
    <div class="toolbar">
        <div class="toolleft">
            <p class="toolp">湖北省钟祥市食品安全知识网络学习管理员平台</p>
        </div>

        <div style="float: right; margin-right: 10%; margin-top: 2%; background: black">
            <a href="/">返回登录界面</a>
        </div>
    </div>

    <div class="managerleft">
        <div class="list-group managerinfomargin">
            <li class="list-group-item active">
                管理员信息
            </li>
            <li class="list-group-item">姓名：&nbsp;&nbsp;&nbsp;<label>${user.name}</label></li>
            <li class="list-group-item">权限：&nbsp;&nbsp;&nbsp;<label>顶级</label></li>
        </div>

        <div class="list-group managerinfomargin">
            <li class="list-group-item" id="ckyh">查看用户</li>
            <li class="list-group-item" id="ckkcdd">查看课程订单</li>
            <li class="list-group-item" id="zsgl">证书管理</li>
        </div>
    </div>

    <div class="managerright" id="ckyhdiv" style="">
        <div class="panel panel-default studyinfo">
            <!-- Default panel contents -->
            <div class="panel-heading">用户列表
                <div style="float: right"><button onclick="nextPageOfyh()" page="1">下一页</button></div>
            </div>
            <!-- Table -->
            <table class="table">
                <thead><tr>
                    <th>编号</th>
                    <th>账号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>性别</th>
                    <th>身份证</th>
                    <th>所属单位</th>
                    <th>学习状态</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>

    <div class="managerright" id="ckkcdddiv" style="display: none">
        <div class="panel panel-default studyinfo">
            <!-- Default panel contents -->
            <div class="panel-heading">课程订单列表
                <div style="float: right"><button onclick="nextPageOfOrder()" page="1">下一页</button></div>
            </div>
            <!-- Table -->
            <table class="table">
                <thead><tr>
                    <th>编号</th>
                    <th>课程名称</th>
                    <th>课程价格</th>
                    <th>购买人</th>
                    <th>购课时间</th>
                    <th>状态</th>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>


    <div class="managerright" id="licensediv" style="display: none">
        <div class="panel panel-default studyinfo">
            <!-- Default panel contents -->
            <div class="panel-heading">证书列表
                <div style="float: right"><button onclick="nextPageOfLicense()" page="1">下一页</button></div>
            </div>
            <!-- Table -->
            <table class="table">
                <thead><tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>考试分数</th>
                    <th>申请时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>

    <jsp:include page="/getFooter"/>

    <script src="${pageContext.request.contextPath}/static/js/manager.js"></script>
</body>
</html>
