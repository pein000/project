<%--
  Created by IntelliJ IDEA.
  User: pein
  Date: 2015/10/19
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人设置页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../layout/settings_left.jsp" flush="true"/>
<div class="content">
    <jsp:include page="../layout/settings_nav.jsp"  flush="true"/>
    <div>
        <div class="edit_profile">
            <form role="form">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label" >您的昵称 : </label>
                    <input type="text" id="name" class="form-control"  value="${user.name}" disabled/>
                </div>
                <div class="form-group">
                    <label for="sign" class="col-sm-2 control-label" >您的签名 : </label>
                    <input type="text" id="sign" class="form-control"  value="${user.name}" disabled/>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label" >联系电话 : </label>
                    <input type="text" id="phone" class="form-control" value="${user.phone}" disabled/>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label" >邮箱 : </label>
                    <input type="text" id="email" class="form-control"  value="${user.email}" disabled/>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label" >收货地址 : </label>
                    <input type="text" id="address" class="form-control"  value="${user.address}" disabled/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
