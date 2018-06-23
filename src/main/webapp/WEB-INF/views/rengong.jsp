<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理界面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
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
                <input id="password" type="password" name="password" placeholder="请输入密码" class="form-control"/>
            </div>

            <label id="loginStatus" style="color: red"></label>
            <button id="submit" class="btn btn-default form-control"
                    style="width:100%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;" onclick="doIt(this)">进入</button>
        </div>
        <div class="col-md-5">
        </div>
    </div>
</div>


<jsp:include page="/getFooter"/>
<script src="${pageContext.request.contextPath}/static/js/rengong.js"></script>
</body>
</html>
