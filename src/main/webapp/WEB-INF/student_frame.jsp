<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/15
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="jsp/include/front/head.jsp" %>
</head>
<body>
<!--导航-->
<%@include file="jsp/include/header.jsp" %>
<!--菜单-->
<%@include file="jsp/include/front/menu.jsp" %>
<!--内容开始 -->
<div class="container">
    <div class="line">
        <div class="xm3 xb3 fadein-left">
            <div class="doc-siderbar">
                <div class="panel margin-big-bottom">
                    <div class="panel-head">
                        <strong class="icon-search"> 数据查询</strong>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="<%= request.getContextPath()%>/StudentList?style=table" name="searchForm" id="searchForm" >
                            <div class="form-group">
                                <div class="field">
                                    <div class="input-group">
                                        <input type="text" class="input" name="sno" size="50" placeholder="请输入要搜索的学号" /><span class="addbtn">
                                                    <input type="submit" class="button" value="查询" />
                                                </span>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="photo"></div>
                <%@include file="jsp/include/front/friendship_link.jsp" %>
            </div>
        </div>
        <div class="xl12 xs12 xm9 xb9">
            <div class="padding-large-left padding-large-right">
                <!--学生列表开始-->
                <div class="panel margin-big-bottom text-center">
                    <div class="panel-body">
                        <h1 class="text-main text-center padding-big-top icon-calendar"> 学生基本信息列表</h1>
                        <div class="media-inline">
                            <div class="line-big">
                                <c:forEach var="stu" items="${students}" varStatus="status">
                                    <div class="xl12 xs6 xm4 xb4">
                                        <div class="doc-studentframe">
                                            <div class="media clearfix text-center">
                                                <!--<img src="<%= request.getContextPath()%>/ShowPic?sno=${stu.sno}" alt="${stu.sname}的照片" title="${stu.sname}的照片" />-->
                                                <img src="/static/photo/${stu.photo_url}" alt="${stu.sname}的照片" title="${stu.sname}的照片" />
                                                <div class="media-body">
                                                    <p>学生学号：&nbsp;&nbsp;${stu.sno}</p>
                                                    <p>学生姓名：&nbsp;&nbsp;${stu.sname}</p>
                                                    <p>学生性别：&nbsp;&nbsp;${stu.ssex}</p>
                                                    <p>学生年龄：&nbsp;&nbsp;${stu.sage}</p>
                                                    <p>学生系部：&nbsp;&nbsp;${stu.sdept}</p>
                                                    <p>平均成绩：&nbsp;&nbsp;${stu.savgGrade}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <!--学生列表结束-->
                <!-- 分页开始 -->
                <%@include file="jsp/include/pagging.jsp" %>
                <!-- 分页结束 -->
            </div>
        </div>
    </div>
</div>
<!-- 内容结束 -->
<!--底部-->
<%@include file="jsp/include/footer.jsp" %>
</body>
</html>
