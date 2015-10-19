<%--
  Created by IntelliJ IDEA.
  User: pein
  Date: 2015/10/18
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>注册页面</title>
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
    <li  class="login_processCur">完善个人资料</li>
    <li class="login_arrow"> >> </li>
    <li>完成注册</li>
  </ul>
  <span style="float: right;">已经是会员？<a id="hylinkLoginPage" class="blue Fb" href="login">登录</a></span>
  <p></p>
</div>

<div class="login_form">
  <form role="form" method="post" action="toCompleteRegister">
    <div class="form-group">
      <label for="name">用户昵称</label>
      <input name="name" type="text" class="form-control" id="name"
             placeholder="请输入用户昵称">
    </div>
    <div class="form-group">
      <label for="sign"></label>
      <input name="sign" type="text" class="form-control" id="sign"
             placeholder="请输入签名">
    </div>
    <div class="form-group">
      <label for="email">用户邮箱</label>
      <input name="email" type="email" class="form-control" id="email"
             placeholder="请输入邮箱">
    </div>
    <div class="form-group">
      <div class="form-group">
        <label for="address">收货地址</label>
        <input name="address" type="text" class="form-control" id="address">
      </div>
      </label>
    </div>
    <input name="phone" type="hidden" value="${user.phone}" />
    <input name="password" type="hidden" value="${user.password}" />
    <button type="submit" class="btn btn-default">提交</button>
  </form>

</div>

</body>
</html>
