<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome-4.7.0/css/font-awesome.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
</head>
<body style="background-color: #f2f9fd;">

	<!-- 页面顶部Header -->
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1 style="font-size: 20px;">
				<img src="${pageContext.request.contextPath}/images/admin/user_pic.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />控制台
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="user_info.action" target="right"><span
				class="icon-home"></span> 首页</a>&nbsp;&nbsp; <a
				class="button button-little bg-red" href="logout.action"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>

	<!-- 页面左边导航栏 -->
	<div class="leftnav">
		<div class="leftnav-title">
			<span class="icon-list"></span>菜&nbsp;单&nbsp;列&nbsp;表
		</div>
		<h2>
			<span class="icon-user"></span>用户管理
		</h2>
		<ul style="display: block">
			<li><a href="user_info.action" target="right"><span
					class="icon-caret-right"></span>个人信息</a></li>
			<li><a href="alter_pass.action" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li>
			<li><a href="user_list.action" target="right"><span
					class="icon-caret-right"></span>用户列表</a></li>
			<li><a href="website_info.jsp" target="right"><span
					class="icon-caret-right"></span>网站设置</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>广告管理
		</h2>
		<ul>
			<li><a href="adslist.jsp" target="right"><span
					class="icon-caret-right"></span>广告管理</a></li>

			<li><a href="cate.jsp" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>

		<h2>
			<span class="fa fa-television"></span>设备管理
		</h2>
		<ul>
			<li><a href="deviceslist.jsp" target="right"><span
					class="icon-caret-right"></span>设备管理</a></li>

		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>

	<!-- 网页map，显示当前页面位置信息 -->
	<ul class="bread">
		<li><a href="user_info.action" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">个人信息</a></li>
		<li><b>当前语言：</b><span style="color: red;">中文</php></span></li>
	</ul>

	<!-- 主内容显示区 -->
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="user_info.action" name="right"
			width="100%" height="100%"></iframe>
	</div>

</body>
</html>