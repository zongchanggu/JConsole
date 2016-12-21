<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
#allmap {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}

#l-map {
	height: 100%;
	width: 78%;
	float: left;
	border-right: 2px solid #bcbcbc;
}

#r-result {
	height: 100%;
	width: 20%;
	float: left;
}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=imfAk7n5XsOaoytHGPaAcznNkrRCEp1z"></script>
<title>添加多个标注点</title>
<jsp:include page="../common.jsp" />
</head>
<body>
	<div id="allmap"></div>
	<script type="text/javascript">
    function dataView(result){
    	$("input[name='devName']").value =result.devName;
    	var a = $("input[name='devName']").val();
    	alert(a);
    }
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(120.04325, 30.230856);
	map.centerAndZoom(point, 13);
	var name2;
	function myFun(result) {
		cityName = result.name;
		name2 = cityName;
		map.setCenter(cityName);
	}
	var myCity = new BMap.LocalCity();
	myCity.get(myFun);
	map.enableScrollWheelZoom(true);
    $(function getJsonData(){
		$.ajax({
			url : '${pageContext.request.contextPath}/DevAction/getDevsAddressXY.action',
			type : 'post',
			data:{'name':name2},
			success : function(result) {
				for(var i=0;i<result.length;i++){
					var tmp = result[i];
					var array = new Array();
					array = tmp.addressXY.split(",");
					var point = new BMap.Point(array[0],array[1]);
					var marker = new BMap.Marker(point);
					marker.addEventListener('click',function attribute(e){
						var p = e.target;
						if(p instanceof BMap.Marker){
							alert("DevName:"+tmp.devName+"<br/>"+"Location:"+tmp.location);
//							alert("marker的位置:"+p.getPosition().lng+","+p.getPosition().lat);
						}
						else if(p instanceof BMap.Circle){
							alert("该覆盖物是圆，圆的半径是：" + p.getRadius() + "，圆的中心点坐标是：" + p.getCenter().lng + "," + p.getCenter().lat); 
						}
						else if(p instanceof BMap.Polyline){
							alert("该覆盖物是折线，所画点的个数是：" + p.getPath().length);
						}
						else
							alert("无法获知该覆盖物类型");
					});
					map.addOverlay(marker);
				}
			}
	    })
	})
</script>
</body>
</html>

