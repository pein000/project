<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>购物车页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>

        var loadCal = function(){
            //总计
            var values = 0;
            var doms = $("[type='number']");
            for(var index =0; index < doms.size(); index++){
                values+=Number($(doms[index]).val());
            }
            $("#p_all_amount").text(values);
            $("#all_amount").val(values);
        }

        var calculate = function () {
            //小计
            var value = $(this).val();
            $(this).parent().siblings("td").children("#total_quantity").text(value);
            //单个商品人次
            $(this).parent().siblings("[var='quantity']").val(value);
            //总计
            var values = 0;
            var doms = $("[type='number']");
            for(var index =0; index < doms.size(); index++){
                values+=Number($(doms[index]).val());
            }
            $("#p_all_amount").text(values);
            $("#all_amount").val(values);
        }

        $(function(){
            loadCal();
            $("#index_button").bind("click",function(){
                location.href="${pageContext.request.contextPath}/index";
            });
            $("#pay_button").bind("click", function () {
                $("#pay_form").submit();
            });
            //输入人次，同步小计和总计
            $("[type='number']").bind({"click":calculate,"blur":calculate});
        })
    </script>
</head>
<body>
<div>
    <div class="cash_flow_content">
        <c:choose>
            <c:when test="${fullCarList == null || fullCarList == ''}">
                暂无购物车记录！
                <p>
                    点击
                    <a href="${pageContext.request.contextPath}/index">这里</a>
                    开始享受您的购物旅行吧！
                </p>
            </c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <form id="pay_form" action="${pageContext.request.contextPath}/pay/toPay" method="post">
                    <caption>您的购物车</caption>
                    <thead>
                    <tr>
                        <th>商品名称</th>
                        <th>商品描述</th>
                        <th>商品类型</th>
                        <th>商品价格</th>
                        <th>购买数量</th>
                        <th>商品状态</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${fullCarList}" var="fullCar" varStatus="status">

                        <tr>
                            <td><img class="outline" src="${fullCar.outlineUrl}"/>${fullCar.name}</td>
                            <td>
                                <p>${fullCar.description}</p><p></p>
                                <p>总需${fullCar.totalAmount}，当前参与${fullCar.curAmount}人次,</p>
                                <p> 剩余${fullCar.totalAmount - fullCar.curAmount}人次。</p>
                            </td>
                            <td>${fullCar.type}</td>
                            <td>${fullCar.price}</td>
                            <td><input type="number"  id="num_quantity" min="0" max="${fullCar.totalAmount - fullCar.curAmount}" value="${fullCar.quantity}" /></td>
                            <td>${fullCar.active}</td>
                            <td>￥<b id="total_quantity">${fullCar.quantity}</b></td>
                            <td><button onclick="return ">删除</button></td>
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
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>总计：<b id="p_all_amount"></b></td>
                        <input id="all_amount" type="hidden" name="allAmount" value="0"/>
                    </tr>
                    </tfoot>
                        </form>
                </table>
                <div id="divBuy" class="det_button">
                    <button id="index_button"  class="det_shop_but">返回首页</button>
                    <button id="pay_button"  class="det_cart"><i></i>立即快购</button>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</div>
</body>
</html>
