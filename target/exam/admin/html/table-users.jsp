<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.sy.entity.enums.UserLevelEnum" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String contextPath = request.getContextPath();
    /*HashMap<String, String> levelMap = new HashMap<>();
    HashMap<String, String> sexMap = new HashMap<>();
    levelMap.put("1", "一年级");
    levelMap.put("2", "二年级");
    levelMap.put("3", "三年级");
    levelMap.put("4", "四年级");
    levelMap.put("5", "五年级");
    levelMap.put("6", "六年级");
    levelMap.put("7", "初一");
    levelMap.put("8", "初二");
    levelMap.put("9", "初三");
    levelMap.put("10", "高一");
    levelMap.put("11", "高二");
    levelMap.put("12", "高三");
    sexMap.put("1", "男");
    sexMap.put("2", "女");
    session.setAttribute("levelMap", levelMap);
    session.setAttribute("sexMap", sexMap);*/
%>
<%!
    HashMap<Integer, String> levelMap = new HashMap<>();
    HashMap<Integer, String> sexMap = new HashMap<>();
%>
<%
    levelMap.put(1, "一年级");
    levelMap.put(2, "二年级");
    levelMap.put(3, "三年级");
    levelMap.put(4, "四年级");
    levelMap.put(5, "五年级");
    levelMap.put(6, "六年级");
    levelMap.put(7, "初一");
    levelMap.put(8, "初二");
    levelMap.put(9, "初三");
    levelMap.put(10, "高一");
    levelMap.put(11, "高二");
    levelMap.put(12, "高三");
    sexMap.put(1, "男");
    sexMap.put(2, "女");
    request.setAttribute("levelMap", levelMap);
    request.setAttribute("sexMap", sexMap);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content=" no-cache">
    <meta http-equiv="expires" content="0">
    <title>在线考试后台管理</title>
    <meta name="keywords" content="设置关键词..."/>
    <meta name="description" content="设置描述..."/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link rel="icon" href="<%=contextPath%>/admin/images/icon/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/admin/css/style.css"/>
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
                            <a href="<%=contextPath%>/admin/main">主页</a>
                        </dt>
                    </dl>
                </li>
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
                        <a><i class="icon-user"></i>欢迎您，<%=session.getAttribute("admin")%>
                        </a>
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

                <div style="margin-bottom: 30px;margin-left: 10px">
                    <div class="form-cont" style="margin-bottom: 20px">
                        <label>用户名：</label>
                        <input id="input_userName" class="form-control form-boxed" type="text" autocomplete="off"
                               placeholder="请输入用户名" style="width:200px; margin-right: 20px">
                        <button class="layui-btn layui-btn-normal"
                                onclick="user_show('<%=contextPath%>', 1, document.getElementById('input_userName').value, 1)"
                                style="margin-right: 20px">
                            <span>查询</span>
                        </button>

                        <button class="layui-btn layui-btn-primary JopenMaskPanel_addUser"
                                onclick="user_window()"
                                style="margin-right: 20px">
                            <span>添加</span>
                        </button>

                    </div>
                </div>

                <table class="layui-table">
                    <colgroup>
                        <col width="100">
                        <col width="200">
                        <col width="100">
                        <col width="100">
                        <col width="100">
                        <col width="200">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>年级</th>
                        <th>性别</th>
                        <th>手机号</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="v" items="${page.list}">
                        <tr class="cen">
                            <td>${v.id}</td>
                            <td>${v.userName}</td>
                            <td>${v.realName}</td>
                            <td>${levelMap.get(v.userLevel)}</td>
                            <td>${sexMap.get(v.sex)}</td>
                            <td>${v.phone}</td>
                            <td>${v.createTime}</td>
                            <td>
                                <div class="layui-btn-container">
                                    <a href="<%=contextPath%>/#" class="layui-btn layui-btn-sm layui-btn-primary">
                                        编辑
                                    </a>

                                    <button type="button" class="layui-btn layui-btn-sm layui-btn-danger"
                                            onclick="">
                                        <span>删除</span>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="panel panel-default">
                    <div class="panel-bd">
                        <div class="pagination"></div>
                    </div>
                </div>
                <!--开始::结束-->
            </div>
        </main>
    </div>
    <form id="Form" action="" method="post">
        <input id="FormJson" name="FormJson" type="hidden"/>
    </form>
</div>

<div class="mask"></div>
<div class="dialog">
    <div class="dialog-hd">
        <strong class="lt-title"></strong></strong>
        <a class="rt-operate icon-remove JclosePanel" title="关闭"></a>
    </div>
    <div class="dialog-bd">
        <!--start::-->
        <div class="form-group-col-2">
            <div class="form-label">用户名：</div>
            <div class="form-cont">
                <input type="text" name="userName" id="userName" placeholder="请在此输入用户名" class="form-control form-boxed"  style="width:300px;">
            </div>
        </div>
        <div class="form-group-col-2">
            <div class="form-label">密码：</div>
            <div class="form-cont">
                <input type="text" name="password" id="password" placeholder="请在此输入密码" class="form-control form-boxed" style="width:300px;">
            </div>
        </div>
        <div class="form-group-col-2">
            <div class="form-label">真实姓名：</div>
            <div class="form-cont">
                <input type="text" name="realName" id="realName" placeholder="请在此输入您的真实姓名" class="form-control form-boxed" style="width:300px;">
            </div>
        </div>
        <div class="form-group-col-2">
            <div class="form-label">年龄：</div>
            <div class="form-cont">
                <input type="text" name="age" id="age" placeholder="请在此输入您的年龄" class="form-control form-boxed" style="width:300px;">
            </div>
        </div>
        <div class="form-group-col-2">
            <div class="form-label">性别：</div>
            <div class="form-cont">
                <select id="select_sex" style="width:auto;margin-right: 20px">
                    <option value="" disabled selected>性别</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select>
            </div>
        </div>
        <div class="form-group-col-2">
            <div class="form-label">生日：</div>
            <div class="form-cont">
                <input type="date" name="birthDay" id="birthDay" placeholder="请在此输入生日" class="form-control form-boxed" style="width:300px;">
            </div>
        </div>
        <div class="form-group-col-2">
            <div class="form-label">手机：</div>
            <div class="form-cont">
                <input type="text" name="phone" id="phone" placeholder="请在此输入电话" class="form-control form-boxed" style="width:300px;">
            </div>
        </div>
        <div class="form-group-col-2">
            <div class="form-label">年级：</div>
            <div class="form-cont">
                <select id="select_level" style="width:auto;margin-right: 20px">
                    <option value="" disabled selected>年级</option>
                    <option value="1">一年级</option>
                    <option value="2">二年级</option>
                    <option value="3">三年级</option>
                    <option value="4">四年级</option>
                    <option value="5">五年级</option>
                    <option value="6">六年级</option>
                    <option value="7">初一</option>
                    <option value="8">初二</option>
                    <option value="9">初三</option>
                    <option value="10">高一</option>
                    <option value="11">高二</option>
                    <option value="12">高三</option>
                </select>
            </div>
        </div>
        <!--end::-->
    </div>
    <div class="dialog-ft">
        <button class="btn btn-info JyesBtn"
                onclick="userAdd('<%=contextPath%>',
                        $('#userName').val(),
                        $('#password').val(),
                        $('#realName').val(),
                        $('#select_sex option:selected').val(),
                        $('#birthDay').val(),
                        $('#phone').val(),
                        $('#select_level option:selected').val(),1)">
            提交
        </button>
        <button class="btn btn-secondary JnoBtn" type="button">关闭</button>
    </div>
</div>

<script src="<%=contextPath%>/admin/static/layui/layui.js"></script>
<script src="<%=contextPath%>/admin/javascript/jquery.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/customScrollbar.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/echarts.min.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/layerUi/layer.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.config.js"></script>
<script src="<%=contextPath%>/admin/editor/ueditor.all.js"></script>
<script src="<%=contextPath%>/admin/javascript/plug-ins/pagination.js"></script>
<script src="<%=contextPath%>/admin/javascript/pages/user.js"></script>
<script src="<%=contextPath%>/admin/javascript/public.js"></script>
<script>
    // 题目分页视图中分页组件对应
    <%-- 分页 --%>
    $(".pagination").createPage({
        pageCount:${page.pages},
        current:${page.pageNum},
        backFn: function (p) {
            console.log("p : " + p)
            user_show("<%=contextPath%>", p);
        }
    });
</script>
</body>
</html>