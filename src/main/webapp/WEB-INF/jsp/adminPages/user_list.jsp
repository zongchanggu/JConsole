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
					<th field="userId" align="center" hidden="true"></th>
					<th field="username" width="20%" align="center">姓名</th>
					<th field="password" width="20%" align="center">密码</th>
					<th field="phone" width="20%" align="center">电话</th>
					<th field="currentTime" width="20%" align="center">注册时间</th>
					<th field="type" width="10%" align="center">用户类型</th>
					<th field="operator" width="10%" align="center"
						formatter="javascript:operationFormat">操作</th>

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
				onclick="doSearch()" style="vertical-align: inherit;">搜&nbsp;索</a>
		</div>
		<p></p>
		<script type="text/javascript">
		
			function doSearch() {
				$('#userlist_tab').datagrid('load', {
					username : $('#username').val(),
					name : $('#name').val()
				});
			};
			function operationFormat(val, row, index) {
				return '<a href="javascript:getUserInfo(' + row.userId
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
					shadow: true,
					maximizable: true,
					collapsible: false,
					title : '用户详情',
					width : '70%',
					height : 520,
					modal : true,
					show: 'slide',
				});
				query.messager.progress({
					title:'请等待...',
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