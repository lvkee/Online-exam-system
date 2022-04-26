<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8"/>
<title>在线考试后台管理系统</title>
<meta name="keywords"  content="设置关键词..." />
<meta name="description" content="设置描述..." />
<meta name="author" content="DeathGhost" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<link rel="icon" href="${pageContext.request.contextPath}/admin/images/icon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/style.css" />
<script src="${pageContext.request.contextPath}/admin/javascript/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/plug-ins/customScrollbar.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/plug-ins/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/plug-ins/layerUi/layer.js"></script>
<script src="${pageContext.request.contextPath}/admin/editor/ueditor.config.js"></script>
<script src="${pageContext.request.contextPath}/admin/editor/ueditor.all.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/plug-ins/pagination.js"></script>
<script src="${pageContext.request.contextPath}/admin/javascript/public.js"></script>
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
				<strong>在线考试后台管理系统</strong>
			</div>
		</div>
		
		<nav class="side-menu content mCustomScrollbar" data-mcs-theme="minimal-dark">
			<h2>
				<a href="./index.index.jsp" class="InitialPage"></i>用户管理</a>
			</h2>
			<ul>
				<li>
					<dl>
						<dt>
							</i>试卷管理<i class="icon-angle-right"></i>
						</dt>
					</dl>
				</li>
				<li>
					<dl>
						<dt>
							</i>试题管理<i class="icon-angle-right"></i>
						</dt>
						<dd>
							<a href="button.html">基础按钮</a>
						</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt>
							</i>学生成绩管理<i class="icon-angle-right"></i>
						</dt>
						<dd>
							<a href="table.html">基础表格</a>
						</dd>
					</dl>
				</li>
			</ul>
		</nav>
		<footer class="side-footer">© DeathGhost 版权所有</footer>
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
						<a><i class="icon-user"></i>管理员:<em>DeathGhost</em></a>
					</li>
					<li>
						<a><i class="icon-bell-alt"></i>系统消息</a>
					</li>
					<li>
						<a href="javascript:void(0)" id="JsSignOut"><i class="icon-signout"></i>安全退出</a>
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
						<p class="title-description">
							简约风模快化后台管理模板，自由打造个性化后台管理系统,
							<em class="text-primary">HTML5</em>+<em class="text-primary">CSS3</em>经典组合;
							该模板由<a class="text-primary" title="DeathGhost.cn">DeathGhost</a>个人提供,仅供参考。
						</p>
					</header>
					<hr>
				</section>
				<blockquote class="blockquote mb-20">
					<p class="text-success">原始模板为php文件格式，css为less分类编辑，您所看到的生成后的html版本</p>
					<p class="text-success">当前页面左侧导航根据根据路径而定，这里可能未产生效果</p>
					<p class="text-success">引入样式建议link的方式引入页面，避免使用css导入样式，特此说明</p>
					<p>本模板基于HTML5+CSS3的基础上进行设计制作，仅支持高版本浏览器，如果亲还在使用低版本浏览器，
					暂时只能i'm sorryO(∩_∩)O咯~望亲见谅！</p>
					<p>内容包含：页面基础排版（flex/column-count）布局、按钮系列组、表格系列、进度条、分页、表单、
					文本编辑器、统计图表、TAB选项卡、CSS3基础动画及第三方弹层插件等常见页面使用元素。</p>
				</blockquote>
				<div class="panel panel-default">
					<div class="panel-bd capitalize">
						浏览器兼容：google chrome、microsoft edge、360浏览器、火狐浏览器、uc浏览器等高版本浏览器。
					</div>
				</div>
			</div>
			
			
			<script>
				//分页
				$(".pagination").createPage({
			        pageCount:5,
			        current:1,
			        backFn:function(p){
			            console.log(p);
			        }
			    });
				//demo1
				var dom = document.getElementById("demo1");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
				function randomData() {
					now = new Date(+now + oneDay);
					value = value + Math.random() * 21 - 10;
					return {
						name: now.toString(),
						value: [
							[now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
							Math.round(value)
						]
					}
				}
			
				var data = [];
				var now = +new Date(1997, 9, 3);
				var oneDay = 24 * 3600 * 1000;
				var value = Math.random() * 1000;
				for (var i = 0; i < 1000; i++) {
					data.push(randomData());
				}
			
				option = {
					tooltip: {
						trigger: 'axis',
						formatter: function (params) {
							params = params[0];
							var date = new Date(params.name);
							return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
						},
						axisPointer: {
							animation: false
						}
					},
					xAxis: {
						type: 'time',
						splitLine: {
							show: false
						}
					},
					yAxis: {
						type: 'value',
						boundaryGap: [0, '100%'],
						splitLine: {
							show: false
						}
					},
					series: [{
						name: '模拟数据',
						type: 'line',
						showSymbol: false,
						hoverAnimation: false,
						data: data
					}]
				};
			
				setInterval(function () {
			
					for (var i = 0; i < 5; i++) {
						data.shift();
						data.push(randomData());
					}
			
					myChart.setOption({
						series: [{
							data: data
						}]
					});
				}, 1000);;
				if (option && typeof option === "object") {
					myChart.setOption(option, true);
				}
				
				//demo2
				var dom = document.getElementById("demo2");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
				option = {
					tooltip: {
						trigger: 'axis'
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: {
						type: 'category',
						boundaryGap: false,
						data: ['周一','周二','周三','周四','周五','周六','周日']
					},
					yAxis: {
						type: 'value'
					},
					series: [
						{
							name:'邮件营销',
							type:'line',
							stack: '总量',
							data:[120, 132, 101, 134, 90, 230, 210]
						},
						{
							name:'联盟广告',
							type:'line',
							stack: '总量',
							data:[220, 182, 191, 234, 290, 330, 310]
						},
						{
							name:'视频广告',
							type:'line',
							stack: '总量',
							data:[150, 232, 201, 154, 190, 330, 410]
						},
						{
							name:'直接访问',
							type:'line',
							stack: '总量',
							data:[320, 332, 301, 334, 390, 330, 320]
						},
						{
							name:'搜索引擎',
							type:'line',
							stack: '总量',
							data:[820, 932, 901, 934, 1290, 1330, 1320]
						}
					]
				};
				;
				if (option && typeof option === "object") {
					myChart.setOption(option, true);
				}	
			</script>
			<!--开始::结束-->
		</main>
	</div>
</div>
</body>
</html>
