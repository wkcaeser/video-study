<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row" style="margin-top:20px;margin-left:70px;">
        <div class="col-md-4">
           <p style="font-family: 宋体; font-size: 30px">
               “要编织全方位、立体化的公共安全网”，要切实加强食品安全监督，用
               <span style="color: red">最严谨的标准、最严格的监管、最严厉的处罚、最严肃的问责，</span>
               加快建设科学完善的食品药品安全治理体系······
           </p>
        </div>
        <div class="col-md-2">
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label>用户名：</label>
                <input id="username" type="text" name="username" placeholder="请输入用户名" class="form-control"/>
            </div>

            <div class="form-group">
                <label>密&nbsp;&nbsp;&nbsp;码：</label>
                <input id="password" type="password" name="password" placeholder="请输入密码" class="form-control"/>
            </div>

            <div class="form-group">
                <input id="validateText" type="text" name="validateText" class="form-control" style="width:50%;"/>
                <img src="" id="validateCode"/> <label id="refreshValidateCode">换一张</label>
                <label id="validateStatus" style="color: red"></label>
            </div>
            <label id="loginStatus" style="color: red"></label>
            <button id="submit" class="btn btn-default form-control"
                    style="width:100%;height:60px;background-color:steelblue;color:#fff;font-weight:bold;font-size:20px;">登录</button>
            <label><a href="/getPasswordPage">忘记密码</a></label>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/js/validate.js"></script>
<script src="${pageContext.request.contextPath}/static/js/tool/login.js"></script>
</body>
</html>
