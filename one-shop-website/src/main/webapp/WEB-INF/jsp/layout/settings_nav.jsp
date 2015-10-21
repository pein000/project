<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script>--%>
  <%--$(function(){--%>
    <%--$(".nav li a").bind("click",function(){--%>
      <%--var dom = $(this);--%>
      <%--var li = dom.parent();--%>
      <%--var ul--%>
      <%--$(li).addClass("active");--%>
      <%--$(li).--%>
    <%--})--%>
  <%--})--%>
<%--</script>--%>
<div>
  <ul class="nav nav-tabs">
    <li><a href="${pageContext.request.contextPath}/cash/toCashAccount">现金账户</a></li>
    <li><a href="${pageContext.request.contextPath}/point/toPointAccount">积分账户</a></li>
    <li><a href="javascript:;">我的快购</a></li>
    <li><a href="${pageContext.request.contextPath}/settings/toSettings">个人资料</a></li>
    <li><a href="${pageContext.request.contextPath}/settings/to_edit_photo">修改图像</a></li>
  </ul>
</div>