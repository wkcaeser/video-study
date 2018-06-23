<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频学习</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manager.css">
    <link href="${pageContext.request.contextPath}/static/css/video.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="toolbar">
    <div class="toolleft">
        <p class="toolp">湖北省钟祥市食品安全知识网络学习参训单位平台</p>
    </div>

    <div style="float: right; margin-right: 10%; margin-top: 2%">
        <a href="/getUserPage">返回个人中心</a>
    </div>
</div>

<div vid="${vid}" cid="${cid}" id='videoWindow' style="margin-left: 20%">
    <video id="video" preload="auto" width="80%" height="500px"
           poster="" data-setup=''>
        <source id="vSource" src="${videoPath}" type='video/mp4' />
    </video>
</div>
<!--自制进度条-->
<div id="parentDiv" class="parentDiv" style="margin-left: 15%">
    <div id="childDiv" class="childDiv"></div>
    <div id="playControl" style="float: left"><span><button>play/pause</button></span></div>
    <div style="float:right"><span id="current">0:0:0</span>/<span id="all"></span></div>
</div>

<script src="${pageContext.request.contextPath}/static/js/videoController.js"></script>
</body>
</html>
