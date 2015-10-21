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
                    暂无积分记录！
                    <p>
                        点击
                        <a href="${pageContext.request.contextPath}/point/to_charge">这里</a>
                        , 开始玩转您的积分吧
                    </p>
                </c:when>
                <c:when test="${totalSize > 0}">
                    <table class="table table-hover">
                        <caption>您的积分记录</caption>
                        <thead>
                        <tr>
                            <th>积分金额</th>
                            <th>积分途径</th>
                            <th>积分类型</th>
                            <th>积分时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pointFlowList}" var="pointFlow" varStatus="status">
                            <tr>
                                <td>${pointFlow.amount}</td>
                                <td>${pointFlow.incomePath}</td>
                                <td>${pointFlow.pointType}</td>
                                <td>${pointFlow.pointTime}</td>
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
