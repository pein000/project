<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>一元购物网站首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <table>
        <tr>
            <td>
                <!--首页列表栏-->
                <div style="width:200px;">
                    <ul class="list-group">
                        <c:forEach items="${typeList}" var="type" varStatus="typeStatus">
                            <li class="list-group-item">
                                <a href="type.jsp?typeId=${type.id}">
                                    <img style="width:49px; height: 20px;"
                                         src="${pageContext.request.contextPath}/static/image/${type.url}"/>
                                        ${type.name}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </td>
            <td>
                <!--首页图片轮播-->
                <div id="myCarousel" class="carousel slide luara" style="width:600px;">
                    <!-- 轮播（Carousel）指标 -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    <!-- 轮播（Carousel）项目 -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img style="width:600px; height: 350px;"
                                 src="${pageContext.request.contextPath}/static/image/big/main_first.jpg" alt="First slide">
                        </div>
                        <div class="item">
                            <img style="width:600px; height: 350px;"
                                 src="${pageContext.request.contextPath}/static/image/big/main_second.jpg" alt="Second slide">
                        </div>
                        <div class="item">
                            <img style="width:600px; height: 350px;"
                                 src="${pageContext.request.contextPath}/static/image/big/main_third.jpg" alt="Third slide">
                        </div>
                    </div>
                    <!-- 轮播（Carousel）导航 -->
                    <a class="carousel-control left" href="#myCarousel"
                       data-slide="prev">&lsaquo;</a>
                    <a class="carousel-control right" href="#myCarousel"
                       data-slide="next">&rsaquo;</a>
                </div>
            </td>
        </tr>
    </table>


    <!--最热商品-->
    <div class="cord_lists">
        <p>最热商品</p>

        <div>
            <c:forEach items="${hottestList}" var="hottest" varStatus="hotStatus">
                <div class="cord_item" style="float: left;">
                    <a href="detail?goodsId=${hottest.id}">
                        <img src="${pageContext.request.contextPath}/static/image/${revlealed.outlineUrl}"/>
                    </a>

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

        <div>
            <c:forEach items="${newestList}" var="newest" varStatus="newStatus">
                <div class="cord_item" style="float: left;">
                    <a href="detail?goodsId=${newest.id}">
                        <img src="${pageContext.request.contextPath}/static/image/${revlealed.outlineUrl}"/>
                    </a>

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

        <div>
            <c:forEach items="${revealedList}" var="revlealed" varStatus="revealedStatus">
                <div class="cord_item" style="float: left;">
                    <a href="detail?goodsId=${revlealed.id}">
                        <img src="${pageContext.request.contextPath}/static/image/${revlealed.outlineUrl}"/>
                    </a>

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