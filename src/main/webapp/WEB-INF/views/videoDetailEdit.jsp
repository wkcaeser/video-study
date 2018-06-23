<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程视频管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/videoStudy.css">
</head>
<body>
<div class="toolbar">
    <div class="toolleft">
        <p class="toolp">湖北省钟祥市食品安全知识网络学习管理员平台</p>
    </div>

    <div style="float: right; margin-right: 10%;margin-top: 1%">
        <div><a href="/getUserPage">返回用户管理界面</a></div>
        <div><a href="/videoEdit">返回课程管理界面</a></div>
    </div>
</div>

<div class="leftdiv">
    <div class="row" style="margin-top:20%;margin-left:3%;">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <form action="/addClassVideo" method="post" enctype="multipart/form-data">
                <div class="row" style="display: none" >
                    <div class="col-md-4">
                        <label>课程id：</label>
                    </div>
                    <div class="col-md-8">
                        <input id="classId" type="text" name="classId" placeholder="请输入课程id" class="form-control" value="${vid}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <label>课程名称：</label>
                    </div>
                    <div class="col-md-8">
                        <label id="className" class="form-control" >课程1</label>
                        <div class="row">
                            <label  style="color: red" style="color: red"></label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <label>视频名称：</label>
                    </div>
                    <div class="col-md-8">
                        <input type="text" id="videoName" name="videoName" placeholder="请输入视频名称" class="form-control" />
                        <div class="row">
                            <label style="color: red"></label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <label>视频时长(分)：</label>
                    </div>
                    <div class="col-md-8">
                        <input type="number" name="time" placeholder="请输入视频时长" class="form-control" />
                        <div class="row">
                            <label style="color: red"></label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <label>视频文件：</label>
                    </div>
                    <div class="col-md-8">
                        <input type="file" name="video"  class="form-control" />
                        <div class="row">
                            <label style="color: red" style="color: red"></label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label style="color: red" style="color: red"></label>
                </div>
                <input value="添加课程视频" type="submit" class="btn btn-default" style="width:92%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;"/>
            </form>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

<div class="rightdiv">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><h3>课程视频列表</h3>
            <div style="float: right"></div>
        </div>
        <!-- Table -->
        <table class="table">
            <thead><tr>
                <th>编号</th>
                <th>视频名称</th>
                <th>视频时长</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/videoDetailEdit.js"></script>
</body>
</html>
