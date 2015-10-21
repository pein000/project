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
                <c:when test="${totalSize ==0}">
                    暂无现金交易记录！
                    <p>
                        点击
                        <a href="${pageContext.request.contextPath}/cash/to_charge">这里</a>
                        开始享受您的交易旅行
                    </p>
                </c:when>
                <c:when test="${totalSize > 0}">
                    <table class="table table-hover">
                        <caption>您的交易记录</caption>
                        <thead>
                        <tr>
                            <th>交易金额</th>
                            <th>交易类型</th>
                            <th>交易途径</th>
                            <th>交易时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cashFlowList}" var="cashFlow" varStatus="status">
                            <tr>
                                <td>${cashFlow.amount}</td>
                                <td>${cashFlow.tradeType}</td>
                                <td>${cashFlow.tradePath}</td>
                                <td>${cashFlow.tradeTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
