<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>toolbar</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
</head>
<body>
<div>
    <div class="toolbar">
        <div class="toolleft">
            <p class="toolp">欢迎参加视频学习</p>
        </div>

        <div>
            <div class="toolright">
                <div class="toollogin"><p class="toolp">登录</p></div>
                <div class="toolregister"><p class="toolp">注册</p></div>
            </div>

            <div style="display: none">
                <p class="toolp">个人中心</p>
            </div>
        </div>
    </div>


</div>

<script src="/static/js/tool/toolbar.js"></script>


</body>
</html>
