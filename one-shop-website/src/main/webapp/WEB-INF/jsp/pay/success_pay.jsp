<%--
  Created by IntelliJ IDEA.
  User: pein
  Date: 2015/10/19
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>
        //加载后直接自动点击
        $(function(){
            $("#modal_div").click();
            $("#modal_check").bind("click",function(){
                location.href="${pageContext.request.contextPath}/index";
            });
        })
    </script>
</head>
<body>
<h2>上传图像成功</h2>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg modal_content" data-toggle="modal"
        data-target="#myModal" id="modal_div">
</button>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                   支付
                </h4>
            </div>
            <div class="modal-body">
                恭喜您，${user.name},您的支付操作已经成功！
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal" id="modal_check">确认
                </button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
