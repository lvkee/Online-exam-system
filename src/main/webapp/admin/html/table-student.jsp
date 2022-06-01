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
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content=" no-cache" >
  <meta http-equiv="expires" content="0" >
  <title>在线考试后台管理</title>
  <meta name="keywords"  content="设置关键词..." />
  <meta name="description" content="设置描述..." />
  <meta name="author" content="DeathGhost" />
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
  <link rel="icon" href="<%=contextPath%>/admin/images/icon/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/admin/css/style.css" />
  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/admin/static/layui/css/layui.css">

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
              <a id="<%=contextPath%>" class="a_questions">试题管理</a>
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
            <a><i class="icon-random"></i>清除缓存</a>
          </li>
          <li>
            <a><i class="icon-user"></i>欢迎您，<%=session.getAttribute("admin")%></a>
          </li>
          <li>
            <a><i class="icon-bell-alt"></i>系统消息</a>
          </li>
          <li>
            <a href="<%=contextPath%>/admin/logout" id="JsSignOut"><i class="icon-signout"></i>安全退出</a>
          </li>
        </ul>
      </div>
    </header>
    <main class="main-cont content mCustomScrollbar">
      <div class="page-wrap">
        <!--开始::内容-->
        <section class="page-hd">
          <header>
            <h2 class="title">学生管理</h2>
          </header>
          <hr>
        </section>

        <%--    end 侧边栏 --%>

        <%-- 对不同功能指定不同 class ， 在 public.js 中定义不同函数 --%>
        <%--
        实验九 6 增加
         将 admin/css 和 admin/static 、student.js 复制到你的项目中并在该页面引入
         因为 class="btn btn-secondary JopenMaskPanel_addStudent mr-10" 有对应样式和函数
        --%>
        <button class="btn btn-secondary JopenMaskPanel_addStudent mr-10" style="margin-bottom: 20px; margin-left: 20px;">添加</button>

        <table class="layui-table">
          <thead>
          <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>生日</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <%--实验十 7 表头和下面的属性需要修改为自己实体类中需要展示的属性--%>
          <c:forEach var="student" items="${students}">
          <tr class="cen">
            <td id="s_id">${student.sId}</td>
            <td id="s_name"><a href="#">${student.sName}</a></td>
            <td id="s_nickname">${student.sNickname}</td>
            <td id="s_email">${student.sEmail}</td>
            <td id="s_birth">${student.sBirth}</td>
            <td>
              <%-- 对不同功能指定不同 class ， 在 public.js 中定义不同函数 --%>
            <%--  实验九 6 修改
            JopenMaskPanel_updateStudent 对应函数在 student.js 中 需导入后修改
            --%>
              <a title="编辑" id="${student.sId}" class="JopenMaskPanel_updateStudent mr-5">编辑</a>
                <%--
                实验九 6 删除
                del_student() 在 student.js 中 对应修改
                --%>
              <a title="删除" onclick="del_student(this, ${student.sId})">删除</a>
            </td>
          </tr>
          </c:forEach>
          </tbody>
        </table>
        <%--实验十 8 分页组件 放在 table 后面--%>
        <div class="panel panel-default">
          <div class="panel-bd">
            <div class="pagination"></div>
          </div>
        </div>
      </div>
    </main>
  </div>
</div>

<%--
  实验九 6 增加和修改的弹窗
  需要引入 public.js、
  至此实验九增删改完成
--%>
<%-- 增改查学生表单 动态修改 方法定义在 public.js --%>
<form:form name="form_student" method="post">
<div class="mask"></div>
<div class="dialog">
  <div class="dialog-hd">
    <strong class="lt-title"></strong></strong>
    <a class="rt-operate icon-remove JclosePanel" title="关闭"></a>
  </div>
  <div class="dialog-bd">
    <!--start::-->
    <div class="form-group-col-2">
      <div id="label_id" class="form-label">ID：</div>
      <div class="form-cont">
        <input type="text" name="sId" contenteditable="false" class="form-control form-boxed"  style="width:300px;">
      </div>
    </div>
    <div class="form-group-col-2">
      <div class="form-label">用户名：</div>
      <div class="form-cont">
        <input type="text" name="sName" placeholder="请在此输入用户名" class="form-control form-boxed"  style="width:300px;">
      </div>
    </div>
    <div class="form-group-col-2">
      <div class="form-label">姓名：</div>
      <div class="form-cont">
        <input type="text" name="sNickname" placeholder="请在此输入姓名" class="form-control form-boxed" style="width:300px;">
      </div>
    </div>
    <div class="form-group-col-2">
      <div class="form-label">密码：</div>
      <div class="form-cont">
        <input type="text" name="sPwd" placeholder="请在此输入密码" class="form-control form-boxed" style="width:300px;">
      </div>
    </div>
    <div class="form-group-col-2">
      <div class="form-label">电子邮箱：</div>
      <div class="form-cont">
        <input type="email" name="sEmail" placeholder="请在此输入电子邮箱" class="form-control form-boxed" style="width:300px;">
      </div>
    </div>
    <div class="form-group-col-2">
      <div class="form-label">生日：</div>
      <div class="form-cont">
        <input type="date" name="sBirth" placeholder="请在此输入生日" class="form-control form-boxed" style="width:300px;">
      </div>
    </div>
    <!--end::-->
  </div>
  <div class="dialog-ft">
    <button class="btn btn-info JyesBtn" type="submit">提交</button>
    <button class="btn btn-secondary JnoBtn" type="button">关闭</button>
  </div>
</div>
</form:form>

<script src="<%=contextPath%>/admin/static/layui/layui.js"></script>
<script src="<%=contextPath%>/admin/javascript/jquery.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/customScrollbar.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/echarts.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/layerUi/layer.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.config.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.all.js"></script>
<%--实验十 9 分页 JS 将 pagination.js 导入到你的项目里 再在对应页面引入
 至此分页已实现 --%>
<script src="<%=contextPath%>/admin/javascript/plug-ins/pagination.js"></script>
<script src="<%=contextPath%>/admin/javascript/public.js"></script>
<script src="<%=contextPath%>/admin/javascript/pages/student.js"></script>
<script src="<%=contextPath%>/admin/javascript/pages/index.js"></script>
<%-- 实验十 8 分页组件对应 JS
 放在 </body> 前
 pageCount 为分页后总页数
 pageNow 为当前页
 p 为点击按钮对应页面索引--%>
<script>
  $(".pagination").createPage({
    pageCount:${page.totalPageCount},
    current:${page.pageNow},
    backFn:function(p){
      window.location.href="students?pageNow=" + p;
    }
  });
</script>
</body>
</html>