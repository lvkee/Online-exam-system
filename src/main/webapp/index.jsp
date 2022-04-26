<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh">
    <!--Answer回答题目页-->

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="pragma" content="no-cache" />
        <title>试卷管理系统</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/vendor/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/dist/nav/nav.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/dist/index/index.css" />
        <style type="text/css">
            body {
                background-color: #f7f7f7;
            }
            
            .btn-ap {
                background-color: transparent;
            }
        </style>
    </head>

    <body>
        <nav class="navbar navbar-default navbar-ap navbar-static-top animated fadeInDown">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" signout='{:U("Public/signOut")}' data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">在线考试</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="active">首页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/client/views/login.html">用户登录</a>
                        </li>
                        <li>
<!--                            <a href="./admin/html/login.jsp">管理员登录</a>-->
                            <a href="${pageContext.request.contextPath}/teacher/teacherLogin">管理员登录</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/client/views/login.html">答题者注册</a>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>
        <div class="content">
            <div class="content-head" style="background-image: url(${pageContext.request.contextPath}/client/image/index_bg.jpg);">
                <div class="mask">
                    <div class="title">
                        <p>便捷的在线考试</p>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </div>
                </div>

            </div>
            <div class="content-body">
                <div class="content-item">

                    <div class="content-info">
                        <div class="title">
                            <h2>编辑试卷</h2>
                            <div class="info text-muted">在线/离线编辑、富文本编辑、拖拽排序、快速生成试卷、一键设置答案、一键设置分数</div>
                            <a class="btn btn-default btn-lg btn-ap" href="client/views/edit.html" role="button">预览</a>
                        </div>
                        <div class="img-box">
                            <img src="${pageContext.request.contextPath}/client/image/info/paper_edit_1.png" />
                        </div>
                    </div>

                </div>

                <!---->

                <div class="content-item">

                    <div class="content-info">
                        <div class="title">
                            <h2>批改试卷</h2>
                            <div class="info text-muted">在线/离线批改、自动/手动批改、自动计算分数</div>
                            <a class="btn btn-default btn-lg btn-ap" href="client/views/correct.html" role="button">预览</a>
                        </div>
                        <div class="img-box">
                            <img src="${pageContext.request.contextPath}/client/image/info/correct_1.png" />
                        </div>
                    </div>

                </div>

                <!---->

                <div class="content-item">

                    <div class="content-info">
                        <div class="title">
                            <h2>在线答题</h2>
                            <div class="info text-muted">在线/离线答题、富文本编辑、更多玩法</div>
                            <a class="btn btn-default btn-lg btn-ap" href="client/views/answer.html" role="button">预览</a>
                        </div>
                        <div class="img-box">
                            <img src="${pageContext.request.contextPath}/client/image/info/answer_1.png" />
                        </div>
                    </div>

                </div>

                <!---->

                <div class="content-item">

                    <div class="content-info">
                        <div class="title">
                            <h2>批改总览</h2>
                        </div>
                        <div class="img-box">
                            <img src="${pageContext.request.contextPath}/client/image/info/correct.png" />
                        </div>
                    </div>

                </div>

                <!---->

            </div>
        </div>

        <script src="${pageContext.request.contextPath}/client/vendor/jquery/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath}/client/vendor/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
        </script>
    </body>

</html>