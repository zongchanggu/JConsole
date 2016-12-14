<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广告列表</title>
<jsp:include page="../common.jsp" />
</head>
<body>
	<div class="mypanel admin-panel">
		<div class="panel-head">
			<strong style="font-weight: bold;"><span class="fa fa-user"></span>&nbsp;&nbsp;广告列表</strong>
		</div>
		<table id="AdList" class="easyui-datagrid"
			style="width: 100%; height: 88%;" toolbar="#tb" rownumbers="true"
			pagination="true"
			data-options="singleSelect:true,url:'getdata.action',method:'get',striped: true,">
			<thead>
				<tr>
					<th field="DevID" width="5%" align="center">DevID</th>
					<th field="DevName" width="10%" align="center">DevName</th>
					<th field="Provice" width="10%" align="center">Provice</th>
					<th field="City" width="10%" align="center">City</th>
					<th field="Distinct" width="10%" align="center">Distinct</th>
					<th field="Street" width="10%" align="center">Street</th>
					<th field="Type" width="5%" align="center">Type</th>
					<th field="Status" width="5%" align="center">Status</th>
					<th field="DeployTime" width="20%" align="center">DeployTime</th>
					<th field="CurrentTime" width="15%" align="center">CurrentTime</th>
				</tr>
			</thead>
		</table>
		<div id="SearchTB" style="padding: 10px;">
			<span style="font-size: 14px;">用户名：</span> 
			  	<input type="text" id="username" class="input-sm form-control" placeholder="username" style="width: 15%; display: inline-block;">
			<span style="font-size: 14px;">&nbsp;&nbsp;姓名：</span> 
				<input type="text" id="name" class="input-sm form-control" placeholder="name" style="width: 15%; display: inline-block;">&nbsp;&nbsp; 
				<a class="btn btn-sm btn-default" href="#" role="button" onclick="doSearch()" style="vertical-align: inherit;">搜&nbsp;索</a>
		</div>
	</div>
</body>
</html>