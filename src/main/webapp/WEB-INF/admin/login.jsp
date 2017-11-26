<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/26
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/static/css/pintuer.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/static/css/admin.css">
    <script src="<%= request.getContextPath()%>/static/js/jquery.js"></script>
    <script src="<%= request.getContextPath()%>/static/js/pintuer.js"></script>
    <style>
        body {background: #f5f5f5;}
        .form-group {padding-bottom: 20px;}
    </style>
</head>
<c:if test="${!(empty sessionScope.message)}">
    <script type="text/javascript">
        alert('<c:out value="${sessionScope.message}"/>');
    </script>
    <c:remove var="message" scope="session"/>
</c:if>
<body>
<div align="center" style="margin-top: 150px;">
    <form action="<%= request.getContextPath()%>/Admin/AdminLoginServlet" method="post">
        <div class="panel padding" style="width: 450px;text-align: left;">
            <div class="text-center margin-big-top">
                <h2><strong>管理员登录</strong></h2></div>
            <div style="padding:30px 30px 0 30px;">
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="text" class="input" name="sno" placeholder="登录学号" data-validate="required:请填写学号,length#==7:学号号长度为7" />
                        <span class="icon icon-user"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field field-icon-right">
                        <input type="password" class="input" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                        <span class="icon icon-key"></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <input type="submit" class="button button-block bg-main text-big input" value="立即登录">
                    </div>
                </div>
                <div class="form-group">
                    <div class="field text-center">
                        <p class="text-muted text-center"><a class="" href="<%= request.getContextPath()%>/Index"><small>返回首页</small></a></p>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>

