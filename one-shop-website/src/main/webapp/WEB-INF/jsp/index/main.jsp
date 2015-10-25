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
    <script>
        $(function () {
            //注册
            $("#registerBtn").bind("click", function () {
                location.href = "toRegister";
            });
            //登录
            $("#loginBtn").bind("click", function () {
                location.href = "toLogin";
            });
        })

    </script>
</head>

<div class="main_content">
    <!--head-->
    <div class="head-menu">
        <ul>
            <c:choose>
                <c:when test="${user == null || user == ''}">
                    <li>
                        <input id="loginBtn" class="btn dropdown-toggle" type="button" value="马上登陆"/>
                    </li>
                    <li>
                        <input id="registerBtn" class="btn dropdown-toggle" type="button" value="免费注册"/>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <p class="btn dropdown-toggle">欢迎${user.name}</p>
                    </li>
                    <li>
                        <div class="dropdown" style="float: right;">
                            <button type="button" class="btn dropdown-toggle" id="dropdownMenu1"
                                    data-toggle="dropdown">
                                我的设置
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" style="height: 130px;min-width:90px;" role="menu"
                                aria-labelledby="dropdownMenu1">
                                <li role="presentation">
                                    <a role="menuitem" tabindex="-1" href="#">快购记录</a>
                                </li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation">
                                    <a role="menuitem" tabindex="-1" href="#">获得商品</a>
                                </li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation">
                                    <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/settings/toSettings">
                                        个人设置
                                    </a>
                                </li>
                                <li role="presentation" class="divider" style="height: 1px;"></li>
                                <li role="presentation">
                                    <a role="menuitem" tabindex="-1" href="#">立即充值</a>
                                </li>
                                <li role="presentation" class="divider" style="height: 1px;"></li>
                                <li role="presentation">
                                    <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/login/loginOut">立即退出</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
    <div class="content">
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
                                     src="${pageContext.request.contextPath}/static/image/big/main_first.jpg"
                                     alt="First slide">
                            </div>
                            <div class="item">
                                <img style="width:600px; height: 350px;"
                                     src="${pageContext.request.contextPath}/static/image/big/main_second.jpg"
                                     alt="Second slide">
                            </div>
                            <div class="item">
                                <img style="width:600px; height: 350px;"
                                     src="${pageContext.request.contextPath}/static/image/big/main_third.jpg"
                                     alt="Third slide">
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
                            <img src="${hottest.outlineUrl}"/>
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
                            <img src="${newest.outlineUrl}"/>
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
                            <img src="${revlealed.outlineUrl}"/>
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
</div>
<div class="right_car">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/car/toCar">
                <img href=""/>

                <p>购物车</p>
            </a>
        </li>
        <li>
            <a>
                <img href=""/>

                <p>我的关注</p>
            </a>
        </li>
    </ul>
</div>
</body>
</html>