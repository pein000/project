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
        <div class="cash_profile">
           您的当前积分:￥${pointAccount.amount}
            <p>
                点击<a href="${pageContext.request.contextPath}/point/to_charge" >这里</a>
                去赚取积分吧！
            </p>
        </div>
    </div>
</div>
</body>
</html>
