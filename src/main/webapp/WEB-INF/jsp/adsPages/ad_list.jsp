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
			<strong style="font-weight: bold;"><span class="fa fa-buysellads"></span>&nbsp;&nbsp;广告列表</strong>
		</div>
		<table id="adList_tab" class="easyui-datagrid"
			style="width: 100%; height: 88%;" toolbar="#tb" rownumbers="true"
			pagination="true"
			data-options="emptyMsg: '无记录',singleSelect:true,url:'getPageAdsList.action',method:'get',striped: true,">
			<thead>
				<tr>
					<th field="adID" align="center" hidden="true">AdID</th>
					<th field="adName" width="10%" align="center">广告名</th>
					<th field="type" width="10%" align="center" data-options="formatter:function(value, row, index){
					return value.comment}">广告类型</th>
					<th field="status" width="15%" align="center" data-options="formatter:function(value, row, index){
					return value.comment}">当前状态</th>
					<th field="startTime" width="15%" align="center">开始时间</th>
					<th field="endTime" width="15%" align="center">结束时间</th>
					
					<th field="resieterTime" width="15%" align="center">注册时间</th>
					
					<th field="viewNum" width="10%" align="center">查看次数</th>
					<th field="operator" width="10%" align="center"
					formatter="javascript:operationFormat">操作</th>
				</tr>
			</thead>
		</table>
		<div id="tb" style="padding: 10px; vertical-align: middle;">
			<div class="search-toolbar" style="width: 15%;">
				<div class="search-toolbar-content">
					<div class="search-toolbar-key">&nbsp;广告名：</div>
					<input type="text" id="adName" class="input-sm form-control"
						placeholder="adName">
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
						<option value="图片">图片广告</option>
						<option value="视频">多图广告</option>
						<option value="文本">视频广告</option>
					</select>
				</div>
				&nbsp; <a class="btn btn-sm btn-default" href="#" role="button"
					onclick="doSearch()" style="vertical-align: middle; height: 32px;">搜&nbsp;索</a>
				&nbsp;<a class="btn btn-sm btn-default" href="#" role="button"
					onclick="doCheck()" style="vertical-align: middle; height: 32px;">设备检测</a>
			</div>
		</div>
		
		<script type="text/javascript">
			function doSearch() {
				var adName = $('#adName').val();
				var dateStart = $('#dateStart').val();
				var dateEnd = $('#dateEnd').val();
				var adtype = $('#adtype').val();
				$('#adList_tab').datagrid('load', {
					adName : adName,
					dateStart : dateStart,
					dateEnd : dateEnd,
					adtype : adtype
				});
			};
			function operationFormat(val, row, index) {
				return '<a href="javascript:getAdInfo(' + row.adID
						+ ')">查看</a>'
			};

			function getUserInfo(id) {
				var query = parent.$;
				var userDetail_dlg = query('#userDetail_dlg');
				if (userDetail_dlg.length == 0) {
					query('<div id="userDetail_dlg"></div>').appendTo("body");
				}
				var mis_page = query('#userDetail_dlg');
				mis_page.dialog({
					shadow : true,
					closed : true,
					maximizable : true,
					collapsible : false,
					title : '用户详情',
					width : '70%',
					height : 520,
					modal : true,
					show : 'slide',
				});
				query.messager.progress({
					title : '请等待...',
					msg : '加载中...'
				});
				query.ajax({
					type : "POST",
					data : {
						id : id
					},
					url : 'getUserDetail.action',
					success : function(htm) {
						mis_page.html(htm);
						query.parser.parse(mis_page);
						query.messager.progress('close');
						mis_page.dialog('open');
					},
					error : function() {
						query.messager.progress('close');
						query.messager.alert('提示', '请求失败', 'error');
					}
				});
			};
		</script>

	</div>
</body>
</html>