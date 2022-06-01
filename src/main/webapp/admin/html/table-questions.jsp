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
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
  <link rel="icon" href="<%=contextPath%>/admin/images/icon/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/admin/css/style.css" />
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
              <a id="<%=contextPath%>/admin/questions/page" class="a_questions">试题管理</a>
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
            <h2 class="title">试题管理</h2>
          </header>
          <hr>
        </section>

<%--        <button class="btn btn-secondary JopenMaskPanel_addStudent mr-10" style="margin-bottom: 20px; margin-left: 20px;">添加</button>--%>

        <table class="table table-bordered table-striped table-hover">
          <thead>
          <tr>
            <th>ID</th>
            <th>学科</th>
            <th>题型</th>
            <th>题干</th>
            <th>分数</th>
            <th>难度</th>
            <th>创建时间</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="question" items="${page.list}">
          <tr class="cen">
            <td id="id">${question.id}</td>
            <td id="subject_id">${question.subjectId}</td>
            <td id="question_type">${question.questionType}</td>
            <td id="shortTitle">${question.shortTitle}</td>
            <td id="score">${question.score}</td>
            <td id="difficult">${question.difficult}</td>
            <td id="createTime">${question.createTime}</td>
            <td>
              <a title="编辑" id="${question.id}" class="JopenMaskPanel_updateQuestion mr-5">编辑</a>
<%--              <a title="详情" class="mr-5">详情</a>--%>
              <a title="删除" class="a_delete">删除</a>
            </td>
          </tr>
          </c:forEach>
          </tbody>
        </table>
<%--        <p>${studentSingle.sId}</p>--%>
        <div class="panel panel-default">
          <div class="panel-bd">
            <div class="pagination"></div>
          </div>
        </div>
        <!--开始::结束-->
      </div>
    </main>
  </div>
  <form id="questionForm" action="" method="post">
    <input id="questionFormJson" name="questionFormJson" type="hidden"/>
  </form>
</div>

<%-- 增改查学生表单 动态修改 方法定义在 public.js --%>
<%--<form:form name="form_student" method="post">
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
</form:form>--%>

<script src="<%=contextPath%>/admin/javascript/jquery.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/customScrollbar.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/echarts.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/layerUi/layer.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.config.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.all.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/pagination.js"></script>
<%--<script src="<%=contextPath%>/admin/javascript/public.js"></script>--%>
<script src="<%=contextPath%>/admin/javascript/pages/index.js"></script>
<script>
  <%-- 分页 --%>
  $(".pagination").createPage({
    pageCount:${page.pages},
    current:${page.pageNum},
    backFn:function(p){
      console.log("p : " + p)
      toPage(p);
      // console.log(p);
      // window.location.href="page?pageIndex=" + p;
    }
  });
</script>
</body>
</html>