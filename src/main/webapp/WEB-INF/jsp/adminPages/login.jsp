<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, no-store">
<meta http-equiv="Expires" content="0">
<title>后台登录</title>
<link href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="logo">
		<img alt="" src="${pageContext.request.contextPath}/images/admin/logo.png">
	</div>

	<div class="login login_animation">
		<div class="message">浙工大广告传媒-管理登录</div>
		<div id="darkbannerwrap"></div>

		<form method="post" action="${pageContext.request.contextPath}/adminAction/login.action">
			<input name="action" value="login" type="hidden"> <input
				name="username" placeholder="用户名" required="" type="text">
			<hr class="hr15">
			<input name="password" placeholder="密码" required="" type="password">
			<hr class="hr15">
			<input value="登&nbsp;&nbsp;录" style="width: 100%;" type="submit">
			<hr class="hr20">
			<a onClick="alert('请联系管理员')">忘记密码？</a>
		</form>
		
	</div>
	
	<div class="footer"><span>Copyright © 2016</span> ZJUT All Rights Reserved.</div>
</body>
</html>