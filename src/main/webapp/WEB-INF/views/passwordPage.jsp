<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
    <style>
        .col-md-6 .col-md-4{
            width:25%;
            padding:10px;
        }
        .col-md-6 .row{
            margin-top:10px;
        }
    </style>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
</head>
<body>
<div class="toolbar">
    <div class="toolleft">
        <p class="toolp">湖北省钟祥市食品安全知识网络学习平台</p>
    </div>

    <div style="float: right; margin-right: 10%; margin-top: 2%">
        <a href="/">返回登录界面</a>
    </div>
</div>

<div class="container">
    <div class="row" style="margin-top:20px;margin-left:70px;">
        <div class="col-md-3">
        </div>
        <div class="col-md-6">
            <form method="post" action="/changePassword">
            <div class="row">
                <div class="col-md-4">
                    <label>请输入账号：</label>
                </div>
                <div class="col-md-8">
                    <input type="text" id="username" name="username" placeholder="请输入账号" class="form-control"/>
                    <label id="usernameStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>请输入身份证：</label>
                </div>
                <div class="col-md-8">
                    <input type="text" id="identityNumber" name="identityNumber" placeholder="请输入身份证号" class="form-control" />
                    <label id="identityStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>请输入新密码：</label>
                </div>
                <div class="col-md-8">
                    <input type="password" id="r_password" name="password" placeholder="请输入密码" class="form-control" />
                    <label id="passwordStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>确认新密码：</label>
                </div>
                <div class="col-md-8">
                    <input type="password" id="r_repeatPassword" name="passwordRepeat" placeholder="请确认密码" class="form-control" />
                    <label id="r_passwordRepeatStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <label id="r_registerFailMessage" style="color: red">${passwordMessage}</label>
            </div>
            <button id="r_submit" class="btn btn-default" style="width:92%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;">修改密码</button>
            </form>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>
<jsp:include page="/getFooter"/>
</body>
</html>
