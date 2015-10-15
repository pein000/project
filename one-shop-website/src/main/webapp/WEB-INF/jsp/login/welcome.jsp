<%--
  Created by IntelliJ IDEA.
  User: pein
  Date: 2015/9/13
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
用户名称：
<input type="text" value="${user.name}"/>
用户密码：
<input type="password" value = "${user.password}"/>
用户TELPHONE
<input type="tel" value="${user.phone}"/>
<input type="button" value="登录"/>
</body>
</html>
