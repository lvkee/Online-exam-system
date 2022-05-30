<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>在线考试后台管理</title>
    <meta name="keywords" content="设置关键词..."/>
    <meta name="description" content="设置描述..."/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link rel="icon" href="<%=contextPath%>/admin/images/icon/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/admin/css/style.css"/>
</head>
<body>
<div class="main-wrap">
    <div class="side-nav">
        <div class="side-logo">
            <div class="logo">
				<span class="logo-ico">
					<i class="i-l-1"></i>
					<i class="i-l-2"></i>
					<i class="i-l-3"></i>
				</span>
                <strong>在线考试后台管理</strong>
            </div>
        </div>

        <nav class="side-menu content mCustomScrollbar" data-mcs-theme="minimal-dark">
            <ul>
                <li>
                    <dl>
                        <dt>
                            </i>用户管理<i class="icon-angle-right"></i>
                        </dt>
                        <dd>
                            <a href="<%=contextPath%>/student/students">学生管理</a>
                        </dd>
                        <dd>
                            <a href="#">教师管理</a>
                        </dd>
                        <dd>
                            <a href="#">组织管理</a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <dl>
                        <dt>
                            </i>试卷管理<i class="icon-angle-right"></i>
                        </dt>
                        <dd>
                            <a href="<%=contextPath%>" class="a_questions">试题管理</a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <dl>
                        <dt>
                            <a href="<%=contextPath%>/student/students">学生管理</a>
                        </dt>
                    </dl>
                </li>
                <li>
                    <dl>
                        <dt>
                            </i>学生成绩管理<i class="icon-angle-right"></i>
                        </dt>
                    </dl>
                </li>
                <li>
                    <dl>
                        <dt>
                            <a href="<%=contextPath%>" class="a_files">文件管理</a>
                        </dt>
                    </dl>
                </li>
            </ul>
        </nav>
    </div>
    <div class="content-wrap">
        <header class="top-hd">
            <div class="hd-lt">
                <a class="icon-reorder"></a>
            </div>
            <div class="hd-rt">
                <ul>
                    <li>
                        <a href="#" target="_blank"><i class="icon-home"></i>前台访问</a>
                    </li>
                    <li>
                        <a><i class="icon-user"></i>欢迎您，<%=session.getAttribute("admin")%></a>
                    </li>
                    <li>
                        <a href="<%=contextPath%>/admin/logout" id="JsSignOut"><i class="icon-signout"></i>安全退出</a>
                    </li>
                </ul>
            </div>
        </header>
        <main class="main-cont content mCustomScrollbar">
            <!--开始::内容-->
            <div class="page-wrap">
                <section class="page-hd">
                    <header>
                        <h2 class="title"><i class="icon-home"></i>在线考试系统后台管理</h2>
                    </header>
                    <hr>
                </section>
            </div>
            <!--开始::结束-->
        </main>
        <form id="Form" action="" method="post">
            <input id="FormJson" name="FormJson" type="hidden"/>
        </form>
    </div>
</div>

<script src="<%=contextPath%>/admin/javascript/jquery.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/customScrollbar.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/echarts.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/layerUi/layer.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.config.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.all.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/pagination.js"></script>
<script src="<%=contextPath%>/admin/javascript/pages/index.js"></script>
<script src="<%=contextPath%>/admin/javascript/pages/file.js"></script>
<script src="<%=contextPath%>/admin/javascript/public.js"></script>


</body>

</html>
