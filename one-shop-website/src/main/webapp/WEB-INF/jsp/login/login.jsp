<%--
  Created by IntelliJ IDEA.
  User: pein
  Date: 2015/9/13
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>

<body>
<div class="login_bg">
    <div>
        <img>
    </div>

    <div>
        <form role="form" method="post" action="toCompleteLogin">
            <div class="form-group">
                <label for="phone">账号</label>
                <input name="phone" type="text" class="form-control" id="phone"
                       placeholder="用户名/手机号码/邮箱">
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input name="password" type="password" class="form-control" id="password"
                       placeholder="请输入密码">
            </div>
            <div class="form-group">
                <label for="identifyCode">验证码</label>
                <input name="code" type="text" class="form-control" id="identifyCode"
                       placeholder="请输入验证码">
                <label for="identifyCode">
                    <a>
                        <img id="identifyPic" src="identify"/>
                    </a>
                </label>
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>
</div>
</body>
</html>
