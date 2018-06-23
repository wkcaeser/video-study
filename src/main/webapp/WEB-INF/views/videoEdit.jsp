<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频管理</title>
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

        <div style="float: right; margin-right: 10%; margin-top: 2%">
        <a href="/getUserPage">返回用户管理界面</a>
    </div>
    </div>

    <div class="leftdiv">
            <div class="row" style="margin-top:20%;margin-left:3%;">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <form action="/addClass" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-md-4">
                            <label>课程名称：</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" id="className" name="className" placeholder="请输入课程名称" class="form-control"/>
                            <label id="classNameStatus" style="color: red"></label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <label>课程描述：</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" id="classDescription" name="classDescription" placeholder="请输入课程描述" class="form-control" />
                            <label id="classDescriptionStatus" style="color: red"></label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <label>课程单价/人：</label>
                        </div>
                        <div class="col-md-8">
                            <input type="number" id="classPrice" name="classPrice" placeholder="请输入课程单价" class="form-control" />
                            <label id="classPriceStatus" style="color: red"></label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            <label>课程图标：</label>
                        </div>
                        <div class="col-md-8">
                            <input type="file" id="classImg" name="classImg"  class="form-control" />
                            <label id="classImgStatus" style="color: red"></label>
                        </div>
                    </div>


                    <div class="row">
                        <label id="addClassMessage" style="color: red" style="color: red">${addClassMessage}</label>
                    </div>
                    <input id="classSubmit" value="添加课程" type="submit" class="btn btn-default" style="width:92%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;"/>
                    </form>
                </div>
                <div class="col-md-2">
                </div>
        </div>
    </div>

    <div class="rightdiv">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><h3>课程列表</h3>
                <div style="float: right"></div>
            </div>
            <!-- Table -->
            <table class="table">
                <thead><tr>
                    <th>编号</th>
                    <th>课程名称</th>
                    <th>课程价格</th>
                    <th>课程时长</th>
                    <th>详情</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/static/js/videoClass.js"></script>
</body>
</html>
