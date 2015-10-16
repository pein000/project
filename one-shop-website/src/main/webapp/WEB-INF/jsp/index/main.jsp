<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="favicon.ico">
</head>

<title>一元购物网站首页</title>
<body id="loadingPicBlock" class="home" rf="1">
<div class="wrapper">
    <!--顶部-->
    <div style="height:400px;width:100%;position: absolute">
        <img style="float: left;" src="${pageContext.request.contextPath}/static/image/big/main_first.jpg">
        <img style="float: left;" src="${pageContext.request.contextPath}/static/image/big/main_second.jpg">
        <img style="float: left;" src="${pageContext.request.contextPath}/static/image/big/main_third.jpg">
    </div>
    <div class="g-toolbar clrfix">
        <ul>
            <c:forEach items="${typeList}" var="type" varStatus="status">
                <li><img src="${pageContext.request.contextPath}/static/image/${type.url}"> ${type.name}</li>
            </c:forEach>
        </ul>
    </div>
    <!--最热商品-->
    <div class="cord_lists">
        <p>最热商品</p>

        <div style="height: 100px;">
            <c:forEach items="${hottestList}" var="hottest" varStatus="hotStatus">
                <div class="cord_item" style="float: left;">
                    <img src="${pageContext.request.contextPath}/static/image/${hottest.outlineUrl}"/>

                    <div>${hottest.name}</div>
                    <div>${hottest.description}</div>
                    <div>${hottest.totalAmount}</div>
                    <div>${hottest.curAmount}</div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!--最新商品-->
    <div class="cord_lists">
        <p>最新商品</p>

        <div style="height: 100px;">
            <c:forEach items="${newestList}" var="newest" varStatus="newStatus">
                <div class="cord_item" style="float: left;">
                    <img src="${pageContext.request.contextPath}/static/image/${newest.outlineUrl}"/>

                    <div>${newest.name}</div>
                    <div>${newest.description}</div>
                    <div>${newest.totalAmount}</div>
                    <div>${newest.curAmount}</div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!--最新揭晓商品-->
    <div class="cord_lists">
        <p>最新揭晓商品</p>

        <div style="height: 100px;">
            <c:forEach items="${revealedList}" var="revlealed" varStatus="revealedStatus">
                <div class="cord_item" style="float: left;">
                    <img src="${pageContext.request.contextPath}/static/image/${revlealed.outlineUrl}"/>

                    <div>${revlealed.name}</div>
                    <div>${revlealed.description}</div>
                    <div>${revlealed.totalAmount}</div>
                    <div>${revlealed.curAmount}</div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>