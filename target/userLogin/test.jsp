<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2022/4/30
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试分页</title>
</head>
<body>
<!-- 分页功能 start -->
<div align="center">
    <c:forEach var="student" items="${students}">
        <tr>
            <td id="sName" colspan="2">用户名：${student.sName}</td>
        </tr>
        <tr>
            <td colspan="2">昵称：${student.sNickname }<td>
        </tr>
        <br>
    </c:forEach>

    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
    ${page.pageNow} 页</font> <a href="students?pageNow=1">首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="students?pageNow=${page.pageNow - 1}">上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
            <a href="students?pageNow=1">上一页</a>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="students?pageNow=${page.pageNow}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
            <a href="students?pageNow=${page.pageNow + 1}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
            <a href="students?pageNow=${page.totalPageCount}">下一页</a>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="students?pageNow=${page.pageNow}">尾页</a>
        </c:when>
        <c:otherwise>
            <a href="students?pageNow=${page.totalPageCount}">尾页</a>
        </c:otherwise>
    </c:choose>
</div>
<!-- 分页功能 End -->
</body>
</html>
