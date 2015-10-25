<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>支付页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>
        $(function(){
            $("#pay_desk_button").bind("click",function(){
                $("#pay_form").submit();
            })
        })

    </script>
</head>
<body>
<div class="cash_flow_content">
    <form id="pay_form" action="${pageContext.request.contextPath}/pay/executePay" method="post">
    <table class="table table-hover">
            <thead>
            <tr>
                <th>商品名称</th>
                <th>商品描述</th>
                <th>商品价格</th>
                <th>参与总人次</th>
                <th>已参与人次</th>
                <th>购买数量</th>
                <th>商品状态</th>
                <th>小计</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${fullCarList}" var="fullCar" varStatus="status">

                <tr>
                    <td><img class="outline" src="${fullCar.outlineUrl}"/>${fullCar.name}</td>
                    <td>
                        <p>${fullCar.description}</p>

                        <p></p>

                        <p>总需${fullCar.totalAmount}，当前参与${fullCar.curAmount}人次,</p>

                        <p> 剩余${fullCar.totalAmount - fullCar.curAmount}人次。</p>
                    </td>
                    <td>${fullCar.price}</td>
                    <td>${fullCar.totalAmount}</td>
                    <td>${fullCar.curAmount}</td>
                    <td>${fullCar.quantity}</td>
                    <td>${fullCar.active}</td>
                    <td>￥<b id="total_quantity">${fullCar.quantity}</b></td>
                </tr>
                <input type="hidden" name="fullCars[${status.index}].id" value="${fullCar.id}" />
                <input type="hidden" name="fullCars[${status.index}].userId" value="${fullCar.userId}" />
                <input type="hidden" name="fullCars[${status.index}].goodsId" value="${fullCar.goodsId}" />
                <input type="hidden" name="fullCars[${status.index}].quantity" var="quantity" value="${fullCar.quantity}" />
                <input type="hidden" name="fullCars[${status.index}].active" value="${fullCar.active}" />
                <input type="hidden" name="fullCars[${status.index}].name" value="${fullCar.name}" />
                <input type="hidden" name="fullCars[${status.index}].description" value="${fullCar.description}" />
                <input type="hidden" name="fullCars[${status.index}].outlineUrl" value="${fullCar.outlineUrl}" />
                <input type="hidden" name="fullCars[${status.index}].type" value="${fullCar.type}" />
                <input type="hidden" name="fullCars[${status.index}].price" value="${fullCar.price}" />
                <input type="hidden" name="fullCars[${status.index}].totalAmount" value="${fullCar.totalAmount}" />
                <input type="hidden" name="fullCars[${status.index}].curAmount" value="${fullCar.curAmount}" />
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td>
                    <button id="car_button" class="car_shop_but">返回购物车</button>
                </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>总计：<b id="p_all_amount">${allAmount}</b></td>
            </tr>
            </tfoot>
    </table>
    <table class="table table-hover pay_account">
        <tbody>
        <tr>
            <td>
                <b><input id="cash_check" type="checkbox" checked="checked">使用账户余额支付，账户余额： ${cashAccount.amount}元</b>
            </td>
            <td>
                <b>余额支付金额：<input type="number" value="${cashAccount.amount}" min="0" max="${cashAccount.amount}">元</b>
            </td>
        </tr>
        <tr>
            <td>
                <b><input id="point_check" type="checkbox" checked="checked">使用积分抵扣，您的当前积分： ${pointAccount.amount}</b>
            </td>
            <td>
                <b>积分抵扣金额：${pointAccount.amount / 100}元</b>
            </td>
        </tr>
        </tbody>
    </table>

    <div class="table table-hover pay_platform">
        <div><b>第三方支付平台支付</b></div>
        <ul>
            <li>
                <input type="radio" checked="checked" name="platform">
                <button class="pay_alipay">支付宝支付</button>
            </li>
            <li>
                <input type="radio" name="platform">
                <button class="pay_wechatpay">微信支付</button>
            </li>
        </ul>
    </div>
        <input type="hidden" name="pointAccount.id" value="${pointAccount.id}" />
        <input type="hidden" name="pointAccount.userId" value="${pointAccount.userId}" />
        <input type="hidden" name="pointAccount.amount" value="${pointAccount.amount}" />

        <input type="hidden" name="cashAccount.id" value="${cashAccount.id}" />
        <input type="hidden" name="cashAccount.userId" value="${cashAccount.userId}" />
        <input type="hidden" name="cashAccount.amount" value="${cashAccount.amount}" />

        <input type="hidden" name="payAmount.allAmount" value="${allAmount}" />
        <input type="hidden" name="payAmount.pointAmount" value="${pointAccount.amount/100}" />
        <input type="hidden" name="payAmount.cashAmount" value="${cashAccount.amount}" />
        <input type="hidden" name="payAmount.platformAmount" value="${allAmount - cashAccount.amount - pointAccount.amount/100}" />
    </form>
</div>
<div id="divBuy" class="det_button">

    <button id="pay_desk_button" class="det_cart"><i></i>立即支付</button>
</div>

</body>
</html>
