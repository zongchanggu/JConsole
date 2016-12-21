<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/gray/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/formatterJs/common.js"></script>
<script type="text/javascript">
	function operationFormat(val, row, index) {
		return '<a href="javascript:getAdInfo(' + row.adID + ')">详情</a>'
	};
</script>
</head>
<body>
	<div id="content" style="padding: 15px;">
		<form action="">
			<div id="devDetail"
				style="border-radius: 4px 4px 4px 4px; border: solid 1px #ddd; padding: 5px;">
				<div class="welcome-info">
					<img
						src="${pageContext.request.contextPath}/images/admin/personal-information.png" />
					<span>基本信息</span>
				</div>
				<div class="seperate-line" style="margin-bottom: 0px;"></div>
				<div class="basic-info">
					<div class="basic-info">
						<table>
							<tbody>
								<tr>
									<td>DevID:<span>${dev.devID}</span></td>
									<td>DevName:<span>${dev.devName}</span></td>
									<td>Type:<span>${dev.type}</span></td>
									<td>Status:<span>${dev.status}</span></td>
								</tr>
								<tr>
									<td>Province:<span>${dev.province}</span></td>
									<td>City:<span>${dev.city}</span></td>
									<td>District:<span>${dev.district}</span></td>
									<td>Street:<span>${dev.street}</span></td>
								</tr>
								<tr>
									<td>Location:<span>${dev.location}</span></td>
									<td>AddressXY:<span>${dev.addressXY}</span></td>
									<td>DeployTime:<span>${dev.deployTime}</span></td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
		<div id="adlist"
			style="border-radius: 4px 4px 4px 4px; border: solid 1px #ddd; padding: 5px; margin-top: 20px;">
			<div class="welcome-info">
				<img src="${pageContext.request.contextPath}/images/admin/ads.png">
				<span>广告信息</span>
			</div>

			<table id="userlist_tab" class="easyui-datagrid"
				style="width: 98%; height: 220px;" rownumbers="true"
				data-options="nowrap:true, emptyMsg: '无记录',url:'../AdsManage/getAdsList.action',method:'get',singleSelect:true,striped: true">
				<thead>
					<tr>
						<th field="adID" align="center" hidden="true"></th>
						<th field="adName" width="20%" align="center">广告名称</th>
						<th field="startTime" width="20%" align="center"
							data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">开始时间</th>
						<th field="endTime" width="20%" align="center"
							data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">结束时间</th>
						<th field="type" width="20%" align="center">广告类型</th>
						<th field="operator" width="20%" align="center"
							formatter="javascript:operationFormat">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>