<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户类型注册</title>
    <style>
        .col-md-6 .col-md-4{
            width:25%;
            padding:10px;
        }
        .col-md-6 .row{
            margin-top:10px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.0.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/tool/toolbar.css">
</head>
<body>
<div class="toolbar">
    <div class="toolleft">
        <p class="toolp">湖北省钟祥市食品安全知识网络学习平台</p>
    </div>

    <div>
        <div class="toolright">
            <div class="toollogin"><p class="toolp">单位注册</p></div>
            <div class="toolregister"><p class="toolp">员工注册</p></div>
        </div>

    </div>
</div>

<div style="margin-top: 10%" id="company">
<div class="container">
<div class="row" style="margin-top:20px;margin-left:70px;">
    <div class="col-md-3">
    </div>
    <div class="col-md-6">
        <div class="row">
            <div class="col-md-4">
                <label>请输入你的账号：</label>
            </div>
            <div class="col-md-8">
                <input type="text" id="rkUser" name="rkUser" placeholder="请输入你的账号" class="form-control"/>
                <label id="rkUserStatus" style="color: red"></label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label>请输入单位名称：</label>
            </div>
            <div class="col-md-8">
                <input type="text" id="rkName" name="rkName" placeholder="请输入单位名称" class="form-control"/>
                <label id="rkNameStatus" style="color: red"></label>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <label>请输入单位地址：</label>
            </div>
            <div class="col-md-8">
                <input type="text" id="rkAddress" name="rkAddress" placeholder="请输入单位地址" class="form-control" />
                <label id="rkAddressStatus" style="color: red"></label>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <label>请输入法人姓名：</label>
            </div>
            <div class="col-md-8">
                <input type="text" id="rkOwner" name="rkOwner" placeholder="请输入法人姓名" class="form-control" />
                <label id="rkOwnerStatus" style="color: red"></label>
            </div>
        </div>

        <div class="row">
            <label id="rkMessage" style="color: red" style="color: red"></label>
        </div>
        <button id="rkSubmit" class="btn btn-default" style="width:92%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;">单位申请注册</button>
    </div>
    <div class="col-md-3">
    </div>
</div>
</div>
</div>

<div style="margin-top: 10%; display: none" id="employee">
    <div class="container">
        <div class="row" style="margin-top:20px;margin-left:70px;">
            <div class="col-md-3">
            </div>

            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-4">
                        <label>请输入你的账号：</label>
                    </div>
                    <div class="col-md-8">
                        <input type="text" id="rkEUser" name="rkEUser" placeholder="请输入你的账号" class="form-control"/>
                        <label id="rkEUserStatus" style="color: red"></label>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <label>请输入单位代号：</label>
                    </div>
                    <div class="col-md-8">
                        <input type="text" id="rkCompanyId" name="rkName" placeholder="请输入单位代号" class="form-control"/>
                        <label id="rkCompanyIdStatus" style="color: red"></label>
                    </div>
                </div>

                <div class="row">
                    <label id="rkEMessageStatus" style="color: red" style="color: red"></label>
                </div>
                <button id="rkESubmit" class="btn btn-default" style="width:92%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;">员工申请注册</button>
            </div>
            <div class="col-md-3">
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/js/registerKind.js"></script>
</body>
</html>
