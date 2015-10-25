<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left">
  <div class="list-group">
    <div href="#" class="list-group-item ">
      <img src="${user.photoUrl}"/>

      <div>
        <a href="${pageContext.request.contextPath}/settings/to_edit_photo" class="list-group-item-text">修改图像</a>
        <a href="${pageContext.request.contextPath}/settings/toSettings" class="list-group-item-text">编辑资料</a>
      </div>
    </div>
    <div class="list-group">
      <a href="${pageContext.request.contextPath}/cash/toCashAccount" class="list-group-item active">
        <h4 class="list-group-item-heading">
          现金账户
        </h4>
      </a>
      <a href="${pageContext.request.contextPath}/cash/toCashFlow" class="list-group-item">
        <h6 class="list-group-item-heading">
          账户明细
        </h6>
      </a>
    </div>
    <div class="list-group">
      <a href="${pageContext.request.contextPath}/point/toPointAccount" class="list-group-item active">
        <h4 class="list-group-item-heading">
          积分账户
        </h4>
      </a>
      <a href="${pageContext.request.contextPath}/point/toPointFlow" class="list-group-item">
        <h6 class="list-group-item-heading">
          积分明细
        </h6>
      </a>
    </div>
    <a href="#" class="list-group-item active">
      <h4 class="list-group-item-heading">
        我的快购
      </h4>
    </a>
    <a href="${pageContext.request.contextPath}/goods/toGoodsFlow" class="list-group-item">
      <h6 class="list-group-item-heading">
        快购记录
      </h6>
    </a>
    <a href="#" class="list-group-item">
      <h6 class="list-group-item-heading">
        获得商品
      </h6>
    </a>
  </div>

</div>
