<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广告列表</title>
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
			<strong style="font-weight: bold;"><span class="fa fa-user"></span>&nbsp;&nbsp;广告列表</strong>
		</div>
		<table id="AdList" class="easyui-datagrid"
			style="width: 100%; height: 88%;" toolbar="#tb" rownumbers="true"
			pagination="true"
			data-options="emptyMsg: '无记录',singleSelect:true,url:'getAdsList.action',method:'get',striped: true,">
			<thead>
				<tr>
					<th field="adID" align="center" hidden="true">AdID</th>
					<th field="adName" width="10%" align="center">广告名</th>
					<th field="type" width="10%" align="center">广告类型</th>
					<th field="status" width="15%" align="center">当前状态</th>
					<th field="startTime" width="15%" align="center"
						data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">开始时间</th>
					<th field="endTime" width="15%" align="center"
						data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">结束时间</th>
					<th field="uploadPath" width="15%" align="center">上传路径</th>
					<th field="resieterTime" width="15%" align="center"
						data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">注册时间</th>
					
					<th field="viewNum" width="5%" align="center">查看次数</th>
				</tr>
			</thead>
		</table>
		<div id="tb" style="padding: 10px; vertical-align: middle;">
			<div class="search-toolbar" style="width: 15%;">
				<div class="search-toolbar-content">
					<div class="search-toolbar-key">&nbsp;广告名：</div>
					<input type="text" id="adName" class="input-sm form-control"
						placeholder="username">
				</div>
			</div>
			<div class="search-toolbar" style="margin-left: 3px; width: auto;">
				<div class="search-toolbar-content">
					<div class="search-toolbar-key">&nbsp;开始时间：</div>
					<input id="dateStart" class="easyui-datetimebox"
						style="width: 120px; height: 30px; border: 0;">
				</div>
			</div>
			<div class="search-toolbar" style="margin-left: 3px; width: auto;">
				<div class="search-toolbar-content">
					<div class="search-toolbar-key">&nbsp;结束时间：</div>
					<input id="dateEnd" class="easyui-datetimebox"
						style="width: 120px; height: 30px; border: 0;">
				</div>
			</div>
			<div style="display: inline-block; margin-left: 3px;">
				<div class="selectbox">
					<select id="adtype" class="easyui-combobox" panelHeight="auto"
						style="height: 30px; vertical-align: middle;">
						<option value="">--广告类型--</option>
						<option value="图片广告">图片广告</option>
						<option value="多图广告">多图广告</option>
						<option value="视频广告">视频广告</option>
					</select>
				</div>
				&nbsp; <a class="btn btn-sm btn-default" href="#" role="button"
					onclick="doSearch()" style="vertical-align: middle; height: 32px;">搜&nbsp;索</a>
				&nbsp;<a class="btn btn-sm btn-default" href="#" role="button"
					onclick="doCheck()" style="vertical-align: middle; height: 32px;">设备检测</a>
			</div>
		</div>


	</div>
</body>
</html>