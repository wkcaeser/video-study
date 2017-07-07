<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
    <title>Title</title>
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
