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
    <title>个人设置页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>
        function getFileUrl(sourceId) {
            var url;

            if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
                url = document.getElementById(sourceId).value;
            } else if(navigator.userAgent.indexOf("Trident") > 0){// IE
                url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
            }else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
                url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
            } else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
                url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
            }
            return url;
        }

        $(function () {
            $("#input_photo").bind("change", function () {
                var url = getFileUrl("input_photo");
                $("#photo_display_img").attr("src", url);
            });
        })

    </script>
</head>
<body>
<jsp:include page="../layout/settings_left.jsp" flush="true"/>
<div class="content">
    <jsp:include page="../layout/settings_nav.jsp"  flush="true"/>
    <div>

            <div class="edit_photo">
                <form action="${pageContext.request.contextPath}/settings/uploadPhoto" method="post" enctype="multipart/form-data">
                <label for="input_photo">支持 png, jpg, jpeg 图片上传</label>
                <input type="file" id="input_photo" name="file">

                <p class="help-block">
                    <img id="photo_display_img"/>
                </p>
                    <input type="submit" value="上传" class="btn btn-default" />
                </form>
            </div>

    </div>
</div>
</body>
</html>
