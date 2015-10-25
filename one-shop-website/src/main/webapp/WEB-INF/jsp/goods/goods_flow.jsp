<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
    <jsp:include page="../layout/settings_nav.jsp" flush="true"/>
    <div>
        <div class="cash_flow_content">
            <c:choose>
                <c:when test="${goodsFlowList==null || goodsFlowList ==''}">
                    暂无购物记录！
                    <p>
                        点击
                        <a href="${pageContext.request.contextPath}/index">这里</a>
                        , 去积攒人品购物吧
                    </p>
                </c:when>
                <c:otherwise>
                    <table class="table table-hover">
                        <caption>您的购物记录</caption>
                        <thead>

                        <tr>
                            <th>商品名称</th>
                            <th>商品描述</th>
                            <th>商品图片url</th>
                            <th>商品类型</th>
                            <th>商品价格</th>
                            <th>商品总人次</th>
                            <th>商品当前人次</th>
                            <th>商品id</th>
                            <th>商品用户ID</th>
                            <th>商品ID</th>
                            <th>商品参与人次</th>
                            <th>商品购物时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${goodsFlowList}" var="goodsFlow" varStatus="status">
                            <tr>
                                <td>${goodsFlow.name}</td>
                                <td>${goodsFlow.description}</td>
                                <td>${goodsFlow.outlineUrl}</td>
                                <td>${goodsFlow.type}</td>
                                <td>${goodsFlow.price}</td>
                                <td>${goodsFlow.totalAmount}</td>
                                <td>${goodsFlow.curAmount}</td>
                                <td>${goodsFlow.id}</td>
                                <td>${goodsFlow.userId}</td>
                                <td>${goodsFlow.goodsId}</td>
                                <td>${goodsFlow.quantity}</td>
                                <td>${goodsFlow.goodsTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
