<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>用户信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/admin.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-user"></span>&nbsp;&nbsp;个人信息</strong>
		</div>
		<div class="body-content" style="margin: 0px 10px;">
			<div class="welcome-info">
				<img src="${pageContext.request.contextPath}/images/admin/sun.png">
				<span>您好：${sessionScope.username}，欢迎使用管理控制台</span>
			</div>

			<div class="welcome-info">
				<img src="${pageContext.request.contextPath}/images/admin/time.png">
				<span style="font-weight: normal; font-size: 12px;">当前系统时间：<%=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())%></span>
			</div>

			<div class="seperate-line"></div>

			<div class="welcome-info">
				<img
					src="${pageContext.request.contextPath}/images/admin/personal-information.png">
				<span>基本信息</span>
			</div>

			<div class="basic-info">
				<table>
					<tbody>
						<tr>
							<td>姓名：<span>${sessionScope.username}</span></td>
							<td>手机：<span></span></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="seperate-line"></div>
		</div>
	</div>
</body>
</html>