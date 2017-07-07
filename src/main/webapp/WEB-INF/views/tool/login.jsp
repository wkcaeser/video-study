<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row" style="margin-top:20px;margin-left:70px;">
        <div class="col-md-4">
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label>用户名：</label>
                <input id="username" type="text" name="username" placeholder="请输入用户名" class="form-control"/>
            </div>

            <div class="form-group">
                <label>密&nbsp;&nbsp;&nbsp;码：</label>
                <input id="password" type="text" name="password" placeholder="请输入密码" class="form-control"/>
            </div>

            <div class="form-group">
                <input id="validateText" type="text" name="validateText" class="form-control" style="width:50%;"/>
                <img src="" id="validateCode"/> <label id="refreshValidateCode">换一张</label>
                <label id="validateStatus" style="color: red"></label>
            </div>
            <label id="loginStatus"></label>
            <button id="submit" class="btn btn-default form-control"
                    style="width:100%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;">登录</button>
        </div>
        <div class="col-md-5">
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/js/validate.js"></script>
<script src="${pageContext.request.contextPath}/static/js/tool/login.js"></script>
</body>
</html>
