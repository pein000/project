<%--
  Created by IntelliJ IDEA.
  User: pein
  Date: 2015/10/18
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>完成注册页面</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
<div class="login_title">
  <h2>新用户注册</h2>
  <ul class="login_process">
    <li>填写注册信息</li>
    <li class="login_arrow"> >> </li>
    <li>完善个人资料</li>
    <li class="login_arrow"> >> </li>
    <li  class="login_processCur">完成注册</li>
  </ul>
  <span style="float: right;">已经是会员？<a id="hylinkLoginPage" class="blue Fb" href="login">登录</a></span>
  <p></p>
</div>

<div class="progress_sign">
  <p>${user.name}您好！恭喜您完成一元购物网站的注册</p>
  <p>赶紧点击<a href="index">这里</a>，去撞大运吧 </p>
</div>
</body>
</html>
