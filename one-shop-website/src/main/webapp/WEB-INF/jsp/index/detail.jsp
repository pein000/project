<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#shop_sub").bind("click", function () {
                var value = $("#num_dig").val();
                if (value == null || value == "" || value <= 1) {
                    value = 1;
                } else {
                    value--;
                }

                $("#num_dig").val(value);
            });
            $("#shop_add").bind("click", function () {
                var value = $("#num_dig").val();
                var maxValue = ${goods.totalAmount - goods.curAmount};
                if (value == null || value == "") {
                    value = 1;
                } else if (value >= maxValue) {
                    value = maxValue;
                } else {
                    value++;
                }
                $("#num_dig").val(value);
            });
        })
    </script>

    <title>${goods.name}</title>

</head>
<body>
<div class=="pro_details">
    <div>商品描述：${goods.description}</div>
    <div>商品名称：${goods.name}</div>
    <div>商品价值：￥${goods.price}</div>
    <script>
        var totalAmount = ${goods.totalAmount};
        var curAmount = ${goods.curAmount};
        var progress = curAmount / totalAmount;
        $(".progress-bar .sr-only").innerHTML = progress;
        if (progress < 0.1) {
            $(".progress-bar").attr("style", "width:" + progress + "%");
        }

    </script>
    <!--进度条-->
    <div class="progress">
        <div class="progress-bar progress-bar-success" role="progressbar"
             aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
             style="width: ${goods.curAmount/goods.totalAmount*100}%;">
            <span class="sr-only">90% 完成（成功）</span>
        </div>
    </div>

    <table style="height: 70px; width:100%;">
        <tr>
            <td>
                <dt>${goods.curAmount}</dt>
                <em>已参与人次</em>
            </td>
            <td>
                <dt>${goods.totalAmount}</dt>
                <em>总参与人次</em>
            </td>
            <td>
                <dt>${goods.totalAmount - goods.curAmount}</dt>
                <em>剩余人次</em>
            </td>
        </tr>
    </table>
    <div>
    <p class="Pro_Detsingle" id="shop_amount" style="font-size:14px;">快购单价：<b style="color:#999;">1.00</b></p>
    </div>
    <div id="divNumber" class="Pro_number">
        我要快购
        <input style="border: 1px solid rgb(207, 207, 207);" type="button" id="shop_sub" value="-"/>
        <input style="border: 1px solid rgb(207, 207, 207); width:50px; text-align: center;" type="text" value="1"
               maxlength="7" onkeyup="value=value.replace(/\D/g,'')" class="num_dig" id="num_dig">
        <input style="border: 1px solid rgb(207, 207, 207);" type="button" id="shop_add" value="+"/>人次
        <span id="chance" class="gray03">购买人次越多获得几率越大哦！</span>
    </div>

    <div id="divBuy" class="det_button">
        <a href="javascript:;" class="det_shop_but">立即快购</a>
        <a href="javascript:;" class="det_cart"><i></i>加入购物车</a>
    </div>

    <div>
        <p>商品详情</p>
        <c:forEach items="${pictureGoodsURLList}" var="picUrl" varStatus="status">
            <p>
                <img src="${pageContext.request.contextPath}/static/image/${picUrl.url}">
            </p>
        </c:forEach>
    </div>
</div>

</body>
</html>
