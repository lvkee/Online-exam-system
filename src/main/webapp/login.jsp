<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>登录-后台管理系统</title>
    <meta name="keywords" content="设置关键词..."/>
    <meta name="description" content="设置描述..."/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name='apple-touch-fullscreen' content='yes'>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="address=no">
    <link rel="icon" href="admin/images/icon/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/style.css"/>
</head>
<body class="login-page">
<section class="login-contain">
    <header>
        <h1>在线考试后台管理</h1>
        <p>management system</p>
    </header>
    <div class="form-content">
        <%--@elvariable id="teacher" type="com.sy.entity"--%>
        <form:form action="${pageContext.request.contextPath}/admin/home" method="post">
            <table>
                <tr class="form-group">
                    <td class="control-label">用户名:</td>
                    <td><label for="username"></label><input id="username" name="tName" type="text" placeholder="管理员账号..."
                                                             class="form-control form-underlined"/></td>
                </tr>
                <tr class="form-group">
                    <td class="control-label">密码:</td>
                    <td><label for="password"></label><input id="password" name="tPwd" type="password" placeholder="管理员密码..."
                                                             class="form-control form-underlined"/></td>
                </tr>
                <tr>
                    <td><input type="submit" class="btn btn-lg btn-block" value="登录"></td>
                </tr>
            </table>
        </form:form>
    </div>
</section>
<div class="mask"></div>
<div class="dialog">
    <div class="dialog-hd">
        <strong class="lt-title">标题</strong>
        <a class="rt-operate icon-remove JclosePanel" title="关闭"></a>
    </div>
    <div class="dialog-bd">
        <!--start::-->
        <p>这里是基础弹窗,可以定义文本信息，HTML信息这里是基础弹窗,可以定义文本信息，HTML信息。</p>
        <!--end::-->
    </div>
    <div class="dialog-ft">
        <button class="btn btn-info JyesBtn">确认</button>
        <button class="btn btn-secondary JnoBtn">关闭</button>
    </div>
</div>
<script src="${pageContext.request.contextPath}/admin/javascript/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/plug-ins/layerUi/layer.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/public.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/plug-ins/customScrollbar.min.js"></script>
<script>
    var s = <%=session.getAttribute("admin")%>;
    if (!s) {
        layer.msg("身份验证失败，请重新登陆")
    }
    console.log(s)
</script>
</body>
</html>
