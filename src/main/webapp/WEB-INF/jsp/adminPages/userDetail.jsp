<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情页</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/formatterJs/common.js"></script>
</head>
<body>
	<div id="content" style="padding: 15px;">
		<div id="userDetail"
			style="border-radius: 4px 4px 4px 4px; border: solid 1px #ddd; padding: 5px;">
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
							<td>姓名：<span>${user.userName}</span></td>
							<td>手机：<span>${user.phone}</span></td>
						</tr>
						<tr>
							<td>注册时间：<span id="registTime">${user.currentTime}</span></td>
							<td>用户类型：<span>${user.type}</span></td>
						</tr>
					</tbody>
				</table>
			</div>
			<script type="text/javascript">
				$(document).ready(
						function() {
							var timeValue = $("#registTime").text();
							var formattime = new Date(timeValue);
							var formattedTime = formattime
									.Format('yyyy-MM-dd hh:mm:ss');
							$("#registTime").text(formattedTime);
						});
			</script>
			<div class="seperate-line"></div>
		</div>

		<div id="adlist"
			style="border-radius: 4px 4px 4px 4px; border: solid 1px #ddd; padding: 5px; margin-top: 20px;">
			<div class="welcome-info">
				<img src="${pageContext.request.contextPath}/images/admin/ads.png">
				<span>广告信息</span>
			</div>

			<table id="userlist_tab" class="easyui-datagrid"
				style="width: 100%; height: 220px;" rownumbers="true"
				data-options="nowrap:true, emptyMsg: '无记录',url:'../AdsManage/getAdsList.action',method:'get',singleSelect:true,striped: true">
				<thead>
					<tr>
						<th field="adID" align="center" hidden="true"></th>
						<th field="adName" width="20%" align="center">广告名称</th>
						<th field="startTime" width="20%" align="center" data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">开始时间</th>
						<th field="endTime" width="20%" align="center" data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">结束时间</th>
						<th field="type" width="20%" align="center">广告类型</th>
						<th field="operator" width="20%" align="center" formatter="javascript:operationFormat">操作</th>
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