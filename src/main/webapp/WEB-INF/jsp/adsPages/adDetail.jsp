<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<title>广告详情页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/swiper.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/banner.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/formatterJs/common.js"></script>
<script src="/JConsoleGroup/js/jquery.banner.js" type="text/javascript"
	charset="utf-8"></script>

<style>
.swiper-container {
	width: 100%;
	height: 220px;
	box-shadow: 0px 0px 0.8px;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	width: 100%;
	height: 100%;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
	display: -webkit-box;
	display: -webkit-box
}
</style>
</head>
<body>



	<div id="ad-content" style="padding: 15px;">

		<!-- 广告基本信息区 -->
		<div id="adDetail" class="basicinfo_container">
			<div class="welcome-info">
				<img src="${pageContext.request.contextPath}/images/admin/ads.png">
				<span>基本信息</span>
			</div>

			<div class="seperate-line" style="margin-bottom: 0px;"></div>

			<div class="basic-info">
				<table>
					<tbody>
						<tr>
							<th>广告名：</th>
							<td><span>${adInfo.adName}</span></td>
							<th>广告类型：</th>
							<td><span>${adInfo.type.comment}</span></td>
							<th>当前状态：</th>
							<td><span>${adInfo.status.comment}</span></td>
						</tr>
						<tr>
							<th>广告主：</th>
							<td><span>${userinfo.userName}</span></td>
							<th>联系方式：</th>
							<td><span>${userinfo.phone}</span></td>
							<th>用户类型：</th>
							<td><span>${userinfo.type.comment}</span></td>
						</tr>
						<tr>
							<th>提交时间：</th>
							<td><span id="registerTime">${adInfo.resieterTime}</span></td>
							<th>开始时间：</th>
							<td><span id="startTime">${adInfo.startTime}</span></td>
							<th>结束时间：</th>
							<td><span id="endTime">${adInfo.endTime}</span></td>
						</tr>
						<tr>
							<th>最后修改时间：</th>
							<td><span id="currentTime">${adInfo.currentTime}</span></td>
							<th>查看次数：</th>
							<td><span>${adInfo.viewNum}</span></td>
						</tr>
					</tbody>
				</table>
			</div>

			<!-- 对日期进行格式化 -->
			<!-- 
			<script type="text/javascript">
				$(document).ready(
						function() {
							var registerTime = new Date($("#registerTime").text());
							$("#registerTime").text(registerTime.Format('yyyy-MM-dd hh:mm:ss'));
							var startTime = new Date($("#startTime").text());
							$("#startTime").text(startTime.Format('yyyy-MM-dd hh:mm:ss'));
							var endTime = new Date($("#endTime").text());
							$("#endTime").text(endTime.Format('yyyy-MM-dd hh:mm:ss'));
							var currentTime = new Date($("#currentTime").text());
							$("#currentTime").text(currentTime.Format('yyyy-MM-dd hh:mm:ss'));
						});
			</script> -->

			<div class="seperate-line"></div>
		</div>

		<!-- 素材下载区 -->
		<div id="ad-material" class="basicinfo_container"
			style="margin-top: 20px;">
			<div class="welcome-info">
				<img
					src="${pageContext.request.contextPath}/images/admin/download.png">
				<span>素材下载</span>
			</div>

			<div class="seperate-line" style="margin-bottom: 0px;"></div>

			<!-- 根据广告类型的不同，动态使用不同的html标签进行数据展示 -->
			<div id="ad-material-content" style="padding: 10px;">
				<!-- 广告内容描述区 -->
				<fieldset>
					<legend style="font-size: 14px; padding: 10px;">广&nbsp;告&nbsp;描&nbsp;述</legend>
					<textarea rows="" cols=""
						style="width: 100%; resize: none; height: 80px; font-size: 14px; line-height: 2.0; padding: 3px;">${adInfo.description}</textarea>
				</fieldset>

				<!-- 广告素材展示区 -->
				<fieldset>
					<legend style="font-size: 14px; padding: 10px;">素&nbsp;材&nbsp;预&nbsp;览</legend>
					<!-- 图片广告的展示方式 -->
					<c:if test='${adInfo.type.comment eq "图片"}'>

						<!-- 展示方式一：jquery.banner.js 默认隐藏 -->
						<div class="banner" style="display: none;">
							<ul class="banList">
								<c:forEach items="${picNames}" var="picname" varStatus="status">
									<c:if test='${status.index == 0}'>
										<li class="active"><img
											src="${pageContext.request.contextPath}/images/ads/${picname}" /></li>
									</c:if>
									<c:if test='${status.index != 0}'>
										<li><img
											src="${pageContext.request.contextPath}/images/ads/${picname}" /></li>
									</c:if>
								</c:forEach>
							</ul>
							<div class="fomW">
								<div class="jsNav">
									<a href="javascript:;" class="trigger current"></a> <a
										href="javascript:;" class="trigger"></a> <a
										href="javascript:;" class="trigger"></a>
								</div>
							</div>
						</div>
						<script type="text/javascript">
							$(function() {
								$(".banner").swBanner();
							});
						</script>

						<!-- 展示方式二：Swiper -->
						<div class="swiper-container swiper-container2">
							<div class="swiper-wrapper">
								<c:forEach items="${picNames}" var="picname">
									<div class="swiper-slide"
										style="background-image: url(${pageContext.request.contextPath}/images/ads/${picname}); background-size: 100% 100%;"></div>
								</c:forEach>
							</div>
							<!-- Add Pagination -->
							<div class="swiper-pagination"></div>
						</div>
						<!-- Swiper JS -->
						<script
							src="${pageContext.request.contextPath}/js/swiper.jquery.min.js"></script>

						<!-- Initialize Swiper -->
						<script>
							$(document).ready(function() {
								var swiper = new Swiper('.swiper-container2', {
									pagination : '.swiper-pagination',
									paginationClickable : true,
									direction : 'vertical',
									spaceBetween : 30,
									centeredSlides : true,
									loop : true,
									autoplay : 2500,
									autoplayDisableOnInteraction : false
								});
							});
						</script>
					</c:if>

					<!-- 视频广告的展示方式 -->
					<c:if test='${adInfo.type.comment eq "视频"}'>
						<video width="100%" height="180px" id="playVideo"
							preload="preload" controls="controls"
							poster="${pageContext.request.contextPath}/images/ads/apple.png">
						<source
							src="${pageContext.request.contextPath}/videos/${videoName}">当前浏览器不支持
						video直接播放，点击这里下载视频： <a
							href="${pageContext.request.contextPath}/videos/${videoName}">下载视频</a></video>
					</c:if>
				</fieldset>

				<!-- 素材下载按钮区 -->
				<fieldset>
					<legend style="font-size: 14px; padding: 10px;">素&nbsp;材&nbsp;下&nbsp;载</legend>
					<!-- 图片广告素材下载展示方式 -->
					<c:if test='${adInfo.type.comment eq "图片"}'>
						<ul>
							<c:forEach items="${picNames}" var="picname">
								<li
									style="font-size: 14px; list-style-type: square; list-style-position: inside; line-height: 2.0; margin-left: 1%;">${picname}
									<a
									href="${pageContext.request.contextPath}/downloadAction/download.action?filePath=${pathPrefix}${picname}&fileType=image"
									style="width: 50px; float: right;">下&nbsp;&nbsp;载</a>
									<div class="seperate-line"></div>
								</li>
							</c:forEach>
						</ul>
					</c:if>

					<!-- 视频广告素材下载展示方式 -->
					<c:if test='${adInfo.type.comment eq "视频"}'>
						<a href="${pageContext.request.contextPath}/downloadAction/download.action?filePath=${pathPrefix}${videoName}&fileType=video" class="easyui-linkbutton"
							style="height: 32px; width: 18%; margin: 0 auto; display: block;">一&nbsp;&nbsp;键&nbsp;&nbsp;下&nbsp;&nbsp;载</a>
					</c:if>

				</fieldset>

			</div>
			<div class="seperate-line"></div>
		</div>

		<!-- 素材上传区 -->
		<div id="ad" class="basicinfo_container" style="margin-top: 20px;">
			<div class="welcome-info">
				<img
					src="${pageContext.request.contextPath}/images/admin/upload.png">
				<span>素材上传</span>
			</div>

			<div class="seperate-line" style="margin-bottom: 0px;"></div>
			<form action="uploadAd.action">
				<div style="padding: 10px 5px 10px 15px;">
					<input id="uploadfile" class="easyui-filebox" name="attachment"
						value=""
						data-options="required:true, prompt:'选择文件，点击上传...', buttonText:'&nbsp;选&nbsp;择&nbsp;文&nbsp件', accept:'.png, .jpg, .jpeg, .gif, .mp4, .mpeg, .mpg, .ogg'"
						style="width: 50%; height: 32px; font-size: 14px;"> <a
						href="#" onclick="upload();" class="easyui-linkbutton"
						style="height: 32px; width: 8%; margin: 0 auto;">上&nbsp;&nbsp;传</a>
				</div>
			</form>
			<!-- 在common.css中重新设置了easyui中css名为textbox的border属性，所以这里需要对其重新设置 -->
			<script type="text/javascript">
				$(document).ready(
						function() {
							$("span.textbox")
									.css("border", "1px solid #D4D4D4").css(
											"vertical-align", "middle");
						});
			</script>
			<div class="seperate-line"></div>
		</div>

	</div>
</body>
</html>