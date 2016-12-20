<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备列表</title>
<jsp:include page="../common.jsp" />
<script type="text/javascript">
$(function(){
	$('#addWindow').window({
	    title: '添加设备',
	    width: 700,
	    modal: true,
	    shadow: true,
	    closed: true,
	    height: 300,
	    resizable:true,
	    onClose:function(){
	    	$('#addWindow').form('clear');
	    }
	});
	$("#btnReset").click(function(){
		$('#addWindow').form('clear');
	});
	$('#addForm').submit(function(){
            $('#addWindow').window('close');
	});
})
	function operationFormat(val, row, index) {
		return '<a href="DevDetail.action?id=' + row.devID + '">查看</a>'
	}

	function doAdd() {
		$('#addWindow').window('open'); 
	}
	function editAd(){
		var item = $('#AdList').datagrid('getSelections');
		if(item.length != 1)
			alert("please select one row");
		else{
			var row = $('#AdList').datagrid('getSelected')
			$('#addForm').form('load','${pageContext.request.contextPath}/DevAction/DevDetail.action?devID='+row['devID']);
			$('#addWindow').window('open');
		}
	}
    function deleteAd(){
    	var item = $('#AdList').datagrid('getSelections');
    	if(item.length < 1){
    		$.messager.show({
				title:'提示',
				msg:'请先选择资源记录，再进行删除！'
			});
    	}
    	else{
    		var ids=new Array();
        	for(var i =0 ;i<item.length;i++)
        		ids.push(item[i].devID);
    		$.messager.confirm({
    			title: 'Delete info',
    			msg: '确定删除设备信息吗？',
    			fn: function(r){
    				if (r){
    					$.ajax({
    						url:'${pageContext.request.contextPath}/DevAction/deleteDevsInfo.action',
    						data:{ids:ids},
    						type:'Post',
    						success:function(result){
    							$('#AdList').datagrid('reload');
    							$('#AdList').datagrid('uncheckAll');
    							if(result != null){
    								$.messager.show({
    									title:'Delete result',
    									msg:'删除成功',
    									timeout:1000,
    									showType:'slide'
    								});
    							}
    						}
    					})
    				}
    			}
    		});
    	}		
    }	
	function submitForm(){
		$('#addForm').form('submit',{
			url:'${pageContext.request.contextPath}/DevAction/insertDevInfo.action',
			onSubmit:function(){
				var isValid = $(this).form('validate');
				if(!isValid){
					alert("validate failed..");
				}
				return isValid;
			},
			success:function(data){
				 if (data!= null) { 
			       $.messager.show({ 
			              title: '提示消息', 
			              msg: '提交成功', 
			              showType: 'show', 
			              timeout: 1000, 
			              style: { 
			                right: '', 
			                bottom: ''
			              } 
			            }); 
			            $('#AdList').datagrid('reload');
			            $('#addWindow').window('close');
			          } 
			          else { 
			            $.messager.alert('提示信息', '提交失败，请联系管理员！', 'warning'); 
			        } 
			}
		});
	}
	
	function clearForm(){
		$('#addForm').form('clear');
	}
	function doSearch() {
		var startTime = $("#dateStart").val();
		var endTime = $("#dateEnd").val();
		var status =$("#status").val();
		var name = $("#name").val();
		var entity ={};
		entity.startTime=startTime;
		entity.endTime=endTime;
		entity.status=status;
		entity.DevName=name;
		$.ajax({
					url:'${pageContext.request.contextPath}/DevAction/doSearchDev.action',
					type:'POST',
					dataType:'json',
					data:entity,
					success:function(result) {
						if(result!=null){
							 $.messager.show({ 
					              title: '提示消息', 
					              msg: '搜索', 
					              showType: 'show', 
					              timeout: 1000, 
					              style: { 
					                right: '', 
					                bottom: ''
					              } 
					            }); 
							 $('#AdList').datagrid('loadData',result);
						}
					}
				})
	}
	function doDeliver(){
    	var item = $('#AdList').datagrid('getSelections');
    	if(item.length < 1){
    		$.messager.show({
				title:'Warning',
				msg:'请选好待投放设备！'
			});
    	}
    	else{
    		var ids=new Array();
        	for(var i =0 ;i<item.length;i++)
        		ids.push(item[i].devID);
    		$.messager.confirm({
    			title: 'Delete info',
    			msg: '确定投放？',
    			fn: function(r){
    				if (r){
    					$.ajax({
    						url:'${pageContext.request.contextPath}/DevAction/deliverAds.action',
    						data:{ids:ids},
    						type:'Post',
    						success:function(result){
    							$('#AdList').datagrid('reload');
    							$('#AdList').datagrid('uncheckAll');
    							if(result != null){
    								$.messager.show({
    									title:'Delete result',
    									msg:'投放成功',
    									timeout:1000,
    									showType:'slide'
    								});
    							}
    						}
    					})
    				}
    			}
    		});
    	}		
		
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
			data-options="url:'getDevsDataJson.action',method:'get',striped: true,">
			<thead>
				<tr>
					<th field="devID" width="3%" align="center" checkbox="true">DevID</th>
					<th field="devName" width="10%" align="center">DevName</th>
					<th field="province" width="10%" align="center">Provice</th>
					<th field="city" width="10%" align="center">City</th>
					<th field="district" width="10%" align="center">Distinct</th>
					<th field="street" width="10%" align="center">Street</th>
					<th field="location" width="10%" align="center">Location</th>
					<th field="type" width="3%" align="center">Type</th>
					<th field="status" width="3%" align="center">Status</th>
					<th field="deployTime" width="15%" align="center">DeployTime</th>
					<th field="currentTime" width="15%" align="center"
						data-options="formatter:function(value, row, index){
						var FormatterDate = new Date(value);return FormatterDate.Format('yyyy-MM-dd hh:mm:ss');}">CurrentTime</th>
					<th field="operator" formatter="operationFormat">修改</th>
				</tr>
			</thead>
		</table>
		<div id="tb" style="padding: 5px; height: auto">
			<div style="margin-bottom: 5px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="doAdd()"></a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editAd()"></a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAd()"></a>
			</div>
			<div>
				Date From: <input id="dateStart" class="easyui-datetimebox" style="width: 80px">
				To: <input id="dateEnd" class="easyui-datetimebox" style="width: 80px">
				Status: <select id="status" class="easyui-combobox" panelHeight="auto"
					style="width: 100px">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				DevName <input id="name" class="easyui-textbox"></input> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">Search</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-text" onclick="doDeliver()">Ad Deliver</a>
			</div>
		</div>
		<div id="addWindow" class="easyui-dialog" title="添加设备" closed="true"
			modal="true" buttons="#dlg-buttons"
			style="width: 700px; height: 300px;">
			<div style="padding-left: 100px; padding-top: 40px;">
				<div style="float: center">
					<form id='addForm' method="post">
					<table>
					   <tr>
					   	<td>DevName:</td>
					   	<td><input name="devName" class="easyui-textbox" type="text" data-options="required:true"/></td>
					   	 <td>Type:</td>
		 			     <td><input name="type" class="easyui-textbox" type="text" data-options="required:true"></td>	
					   </tr>
					   <tr>
					      <td>DeployTime</td>
  				      <td><input name="deployTime" type="text" class="easyui-datetimebox" required="required"></td>
					     <td>Status</td>
 				     <td><input name="status" class="easyui-textbox" type="text" data-options="required:true"></td>
					   </tr>
					   <tr>
					      <td>Province:</td>
					        <td><input class="easyui-combobox" name="province" data-options="valueField:'id',textField:'text',url:''" required="required">     
					      </td>
					      <td>City:</td>
					   	 <td><input class="easyui-combobox" name="city" data-options="valueField:'id',textField:'text',url:''" required="required"></td>  
					   </tr>
					   <tr>
					     <td>District:</td>
					     <td><input class="easyui-combobox" name="district" data-options="valueField:'id',textField:'text',url:''" required="required"></td>
					     <td>Street:</td>
					     <td><input class="easyui-combobox" name="street" data-options="valueField:'id',textField:'text',url:''" required="required"></td>
					   </tr>
					   <tr>
					   	  <td>Location:</td>
					   	  <td><input name="location" class="easyui-textbox" type="text" data-options="required:true"/ data-options="required:true"></td>
					   	  <td>AddressXY:</td>
					   	  <td><input name="addressXY" class="easyui-textbox" type="text" data-options="required:true"/ data-options="required:true"></td>
					   </tr>
					</table>		  
					</form>
				</div>
				<div style="clear: both"></div>
			</div>
			<div id="dlg-buttons" style="text-align: center;">
				<a id="btnEp" class="easyui-linkbutton" iconCls="icon-ok"
					onclick="submitForm()">确定</a>&nbsp;&nbsp; 
				<a id="btnReset" class="easyui-linkbutton" icon="icon-redo"
					onclick="clearForm()">重置</a>
			</div>
		</div>
		
	</div>
</body>
</html>