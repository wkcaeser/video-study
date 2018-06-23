<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <title>欢迎登陆钟祥市食品安全学习平台</title>
</head>
<body>
<jsp:include page="/getToolBar"/>

<div id="loginPage" >
<jsp:include page="/getLoginPage"/>
</div>

<div id="register" style="display: none">
    <jsp:include page="/getRegister"/>
</div>



<jsp:include page="/getFooter"/>
</body>
</html>
