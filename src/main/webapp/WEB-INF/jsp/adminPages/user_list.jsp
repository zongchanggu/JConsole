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
<script type="text/javascript">
	function doSearch() {
		$('#userlist_tab').datagrid('load', {
			username : $('#username').val(),
			name : $('#name').val()
		});
	}
</script>
</head>
<body>
	<div class="mypanel admin-panel">
		<div class="panel-head">
			<strong style="font-weight: bold;"><span class="fa fa-user"></span>&nbsp;&nbsp;用户列表</strong>
		</div>
		<table id="userlist_tab" class="easyui-datagrid"
			style="width: 100%; height: 88%;" toolbar="#tb" rownumbers="true"
			pagination="true"
			data-options="singleSelect:true,url:'getdata.action',method:'get',striped: true,">
			<thead>
				<tr>
					<th field="userid" align="center" hidden="true">编号</th>
					<th field="username" width="20%" align="center">用户名</th>
					<th field="name" width="15%" align="center">姓名</th>
					<th field="phonenum" width="15%" align="center">电话</th>
					<th field="email" width="30%" align="center">Email</th>
					<th field="operator" width="20%" align="center">操作</th>
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
	</div>
</body>
</html>