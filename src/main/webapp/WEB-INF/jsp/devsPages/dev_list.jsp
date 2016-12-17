<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备列表</title>
<jsp:include page="../common.jsp" />
<script type="text/javascript">
	function doCheck() {
		$.ajax({
					url : '${pageContext.request.contextPath}/devCheck/doHealthCheck.action',
					type : 'get',
					dataType : 'json',
					success : function() {

					},
					error : function() {
						alert('request error')
					}
				})
	}
</script>
</head>
<body>
	<div class="mypanel admin-panel">
		<div class="panel-head">
			<strong style="font-weight: bold;"><span class="fa fa-user"></span>&nbsp;&nbsp;设备列表</strong>
		</div>
		<table id="AdList" class="easyui-datagrid"
			style="width: 100%; height: 88%;" toolbar="#tb" rownumbers="true"
			pagination="true"
			data-options="singleSelect:true,url:'getDevsDataJson.action',method:'get',striped: true,">
			<thead>
				<tr>
					<th field="devID" width="5%" align="center">DevID</th>
					<th field="devName" width="10%" align="center">DevName</th>
					<th field="provice" width="10%" align="center">Provice</th>
					<th field="city" width="10%" align="center">City</th>
					<th field="distinct" width="10%" align="center">Distinct</th>
					<th field="street" width="10%" align="center">Street</th>
					<th field="location" width="10%" align="center">Location</th>
					<th field="type" width="5%" align="center">Type</th>
					<th field="status" width="5%" align="center">Status</th>
					<th field="deployTime" width="15%" align="center"
						data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">DeployTime</th>
					<th field="currentTime" width="15%" align="center"
						data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">CurrentTime</th>
				    <th field="devID">设备详情</th>
				</tr>
			</thead>
		</table>
		<div id="tb" style="padding: 10px;">
			<span style="font-size: 14px;">用户名：</span> <input type="text"
				id="username" class="input-sm form-control" placeholder="username"
				style="width: 15%; display: inline-block;"> <span
				style="font-size: 14px;">&nbsp;&nbsp;姓名：</span> <input type="text"
				id="name" class="input-sm form-control" placeholder="name"
				style="width: 15%; display: inline-block;">&nbsp;&nbsp; <a
				class="btn btn-sm btn-default" href="#" role="button"
				onclick="doSearch()" style="vertical-align: inherit;">搜&nbsp;索</a> <a
				class="btn btn-sm btn-default" href="#" role="button"
				onclick="doCheck()" style="vertical-align: inherit;">设备检测</a>
		</div>

	</div>
</body>
</html>