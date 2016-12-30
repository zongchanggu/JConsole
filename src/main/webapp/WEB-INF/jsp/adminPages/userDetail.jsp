<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/formatterJs/common.js"></script>
	
</head>
<body>
	<div id="content" style="padding: 15px;">
		<form action="">
			<div id="userDetail" class="basicinfo_container">
				<div class="welcome-info">
					<img
						src="${pageContext.request.contextPath}/images/admin/personal-information.png">
					<span>基本信息</span>
				</div>

				<div class="seperate-line" style="margin-bottom: 0px;"></div>

				<div class="basic-info">
					<table>
						<tbody>
							<tr>
								<td>姓名：<span>${userDetail.userName}</span></td>
								<td>手机：<span>${userDetail.phone}</span></td>
							</tr>
							<tr>
								<td>注册时间：<span>${userDetail.currentTime}</span></td>
								<td>用户类型：<span>${userDetail.type.comment}</span></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="seperate-line"></div>
			</div>
		</form>
		<div id="adlist"
			style="border-radius: 4px 4px 4px 4px; border: solid 1px #ddd; padding: 5px; margin-top: 20px;">
			<div class="welcome-info">
				<img src="${pageContext.request.contextPath}/images/admin/ads.png">
				<span>广告信息</span>
			</div>

			<table id="userlist_tab" class="easyui-datagrid"
				style="width: 100%;vertical-align: middle; height: 230px;" rownumbers="true"
				pagination="true"
				data-options="nowrap:true, singleSelect:true, url:'${pageContext.request.contextPath}/AdsManage/getUserToAdsList.action?id='+${userDetail.userID},method:'get',striped: true">
				<thead>
					<tr>
						<th field="adID" align="center" hidden="true">广告ID</th>
						<th field="adName" width="20%" align="center">广告名称</th>
						<th field="startTime" width="20%" align="center"
							data-options="">开始时间</th>
						<th field="endTime" width="20%" align="center"
							data-options="">结束时间</th>
						<th field="realPath" width="20%" align="center">路径</th>
						<th field="operator" width="20%" align="center"
							formatter="javascript:operationFormat">操作</th>
					</tr>
				</thead>
			</table>
			<script type="text/javascript">
				function operationFormat(val, row, index) {
					return '<a href="javascript:getAdInfo(' + row.adID
							+ ')">详情</a>'
				};
			</script>
		</div>
	</div>
</body>
</html>