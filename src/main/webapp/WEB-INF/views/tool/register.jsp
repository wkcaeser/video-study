<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <style>
       .col-md-6 .col-md-4{
            width:25%;
           padding:10px;
        }
        .col-md-6 .row{
            margin-top:10px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top:20px;margin-left:70px;">
        <div class="col-md-3">
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-4">
                    <label>请输入账号：</label>
                </div>
                <div class="col-md-8">
                    <input type="text" id="r_username" name="username" placeholder="请输入账号" class="form-control"/>
                    <label id="r_usernameStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>请输入密码：</label>
                </div>
                <div class="col-md-8">
                    <input type="password" id="r_password" name="password" placeholder="请输入密码" class="form-control" />
                    <label id="r_passwordStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>确认密码：</label>
                </div>
                <div class="col-md-8">
                    <input type="password" id="r_repeatPassword" name="passwordRepeat" placeholder="请确认密码" class="form-control" />
                    <label id="r_passwordRepeatStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>请输入真实姓名：</label>
                </div>
                <div class="col-md-8">
                    <input type="text" id="r_name" name="name" placeholder="请输入真实姓名" class="form-control" />
                    <label id="r_nameStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>请输入电话：</label>
                </div>
                <div class="col-md-8">
                    <input type="text" id="r_phone" name="phone" placeholder="请输入电话" class="form-control" />
                    <label id="r_phoneStatus" style="color: red"></label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label>请输入身份证：</label>
                </div>
                <div class="col-md-8">
                    <input type="text" id="r_identityNumber" name="identityNumber" placeholder="请输入身份证号" class="form-control" />
                    <label id="r_identityStatus" style="color: red"></label>
                </div>
            </div>


            <div class="row">
                <label id="r_registerFailMessage" style="color: red" style="color: red"></label>
            </div>
            <button id="r_submit" class="btn btn-default" style="width:92%;height:60px;background-color:#383838;color:#fff;font-weight:bold;font-size:20px;">注册新用户</button>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/static/js/tool/register.js"></script>
</body>
</html>
