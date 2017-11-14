<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>数据库系统实现课程教学演示系统</title>
    <jsp:include page="jsp/include/front/head.jsp"/>
</head>
<body>
<!--头部开始 ctrl+/-->
<jsp:include page="jsp/include/header.jsp"/>
<!--头部结束-->
<!--菜单-->
<jsp:include page="jsp/include/front/menu.jsp"/>
<!--内容开始-->
<div class="container">
    <div class="line">
        <div class="xm3 xb3 fadein-left">
            <div class="doc-siderbar">
                <div class="panel margin-big-bottom">
                    <div class="panel-head">
                        <strong class="icon-file-text"> 文章分类</strong>
                    </div>
                    <ul class="list-group">
                        <c:forEach var="category" items="${categories}" varStatus="status">
                            <li><span class="float-right badge bg-main">${category.count}</span><a href="ArticleList?cid=${category.cid}">${category.catename}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <!--友情链接-->
                <jsp:include page="jsp/include/front/friendship_link.jsp"/>
            </div>
        </div>
        <div class="xl12 xs12 xm9 xb9">
            <div class="padding-large-left padding-large-right">
                <!--轮播开始-->
                <div class="margin-big-bottom">
                    <div class="banner" data-interval="10">
                        <div class="carousel">
                            <div class="item"><img class="img-responsive img-border" src="../static/images/1.jpg" alt="1.jpg" width="100%" /></div>
                            <div class="item"><img class="img-responsive img-border" src="../static/images/2.jpg" alt="2.jpg" width="100%" /></div>
                            <div class="item"><img class="img-responsive img-border" src="../static/images/3.jpg" alt="3.jpg" width="100%" /></div>
                            <div class="item"><img class="img-responsive img-border" src="../static/images/4.jpg" alt="4.jpg" width="100%" /></div>
                            <div class="item"><img class="img-responsive img-border" src="../static/images/5.jpg" alt="5.jpg" width="100%" /></div>
                            <div class="item"><img class="img-responsive img-border" src="../static/images/6.jpg" alt="6.jpg" width="100%" /></div>
                        </div>
                    </div>
                </div>
                <!--轮播结束-->

                <!--实验室简介-->
                <jsp:include page="jsp/include/front/lab_resume.jsp"/>
                <div class="doc-articlelist margin-big-bottom">
                    <div class="panel">
                        <div class="panel-head">
                            <strong class="icon-list"> 文章列表</strong>
                        </div>
                        <div class="table-responsive">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--内容结束-->

<!--尾部开始-->
<jsp include page="include/footer.jsp"/>
<!--尾部结束-->
</body>
</html>