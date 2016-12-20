<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<title>注册用户管理</title>
<jsp:include page="../common.jsp" />
</head>
<body>
	<div class="mypanel admin-panel">
		<div class="panel-head">
			<strong style="font-weight: bold;"><span class="fa fa-user"></span>&nbsp;&nbsp;用户列表</strong>
		</div>
		<table id="userlist_tab" class="easyui-datagrid"
			style="width: 100%; height: 88%;" toolbar="#tb" rownumbers="true"
			pagination="true"
			data-options="nowrap:true, emptyMsg: '无记录', singleSelect:true,url:'getUserList.action',method:'post',striped: true,pageSize:20">
			<thead>
				<tr>
					<th field="userID" align="center" hidden="true"></th>
					<th field="userName" width="20%" align="center">姓名</th>
					<th field="phone" width="25%" align="center">电话</th>
					<th field="currentTime" width="25%" align="center">注册时间</th>
					<th field="type" width="15%" align="center"
						data-options="formatter:function(value, row, index){
					return value.comment;}">用户类型</th>
					<th field="operator" width="15%" align="center"
						formatter="javascript:operationFormat">操作</th>

				</tr>
			</thead>
		</table>
		<div id="tb" style="padding: 10px; vertical-align: middle;">
			<div class="search-toolbar">
				<div class="search-toolbar-content">
					<div class="search-toolbar-key">&nbsp;用户名：</div>
					<input type="text" id="username" class="input-sm form-control"
						placeholder="username">
				</div>
			</div>
			<div class="search-toolbar" style="margin-left: 3px;">
				<div class="search-toolbar-content">
					<div class="search-toolbar-key">&nbsp;电话：</div>
					<input type="text" id="phone" class="input-sm form-control"
						placeholder="phone">
				</div>
			</div>
			<div style="display: inline-block; margin-left: 3px;">
				<div class="selectbox">
					<select id="type" class="easyui-combobox" panelHeight="auto"
						style="height: 30px; vertical-align: middle;">
						<option value="">--用户类型--</option>
						<option value="普通用户">普通用户</option>
						<option value="信誉用户">信誉用户</option>
					</select>
				</div>
				&nbsp; <a class="btn btn-sm btn-default" href="#" role="button"
					onclick="doSearch()"
					style="vertical-align: middle; height: inherit;">搜&nbsp;索</a>

			</div>
		</div>
		<script type="text/javascript">
			function doSearch() {
				var username = $('#username').val();
				var phone = $('#phone').val();
				var usertype = $('#type').val();
				$('#userlist_tab').datagrid('load', {
					username : username,
					phone : phone,
					usertype : usertype
				});
			};
			function operationFormat(val, row, index) {
				return '<a href="javascript:getUserInfo(' + row.userID
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