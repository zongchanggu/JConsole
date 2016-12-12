<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<meta name="app-mobile-web-app-capable" content="yes">
<title>图片广告</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/banner.css" />
<link rel="stylesheet" type="text/css" href="/JConsoleGroup/css/header.css" />
<link rel="stylesheet" type="text/css" href="/JConsoleGroup/css/ads_container.css" />
<link rel="stylesheet" type="text/css" href="/JConsoleGroup/css/swiper.min.css" />
<script src="/JConsoleGroup/js/jquery-3.1.1.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/JConsoleGroup/js/jquery.banner.js" type="text/javascript" charset="utf-8"></script>

<style>
.swiper-container {
	width: 100%;
	height: 180px;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
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
}

.swiper_slide_ad {
	width: 80%;
}
</style>

</head>

<body>
	<div class="all" style="background-color: #ECECEC;">
		<div class="header">

			<img alt="" src="/JConsoleGroup/images/ads/logo3.png" height="50px" />
			<div class="logo_title">
				<a>推广平台</a>
			</div>

		</div>

		<!-- Banner -->
		<!-- Swiper -->
		<div class="swiper-container swiper-container2">
			<div class="swiper-wrapper">
				<div class="swiper-slide"
					style="background-image: url(/JConsoleGroup/images/ads/1.jpg); background-size: 100% 100%;"></div>
				<div class="swiper-slide"
					style="background-image: url(/JConsoleGroup/images/ads/2.jpg); background-size: 100% 100%;"></div>
				<div class="swiper-slide"
					style="background-image: url(/JConsoleGroup/images/ads/3.jpg); background-size: 100% 100%;"></div>
			</div>
			<!-- Add Pagination -->
			<div class="swiper-pagination"></div>

		</div>
		<!-- Swiper JS -->
		<script src="/JConsoleGroup/js/swiper.jquery.min.js"></script>

		<!-- Initialize Swiper -->
		<script>
			var swiper = new Swiper('.swiper-container2', {
				pagination : '.swiper-pagination',
				paginationClickable : true,
				spaceBetween : 30,
				centeredSlides : true,
				autoplay : 2500,
				autoplayDisableOnInteraction : false
			});
		</script>

		<!-- 图文广告推广 -->
		<div class="ad_container">
			<div class="ad_top">
				<p class="ad_top_text">推广</p>
				<img class="ad_top_more" src="/JConsoleGroup/images/ads/more.png" />
			</div>

			<div class="ad_logo">
				<div class="ad_logo_pic">
					<img alt="" src="/JConsoleGroup/images/ads/HM.png" />
				</div>
				<div class="ad_logo_name">H&M</div>
			</div>
			<div class="ad_title">情人节你准备了吗？为TA挑选</div>

			<div class="ad_pic">
				<img alt="" src="/JConsoleGroup/images/ads/hmprod.jpg">
			</div>

			<div class="ad_bottom">
				<div class="ad_bottom_text">近期热门推荐</div>
				<div class="ad_bottom_btn">
					<a href="" class="">去看看</a>
				</div>
			</div>
		</div>

		<!-- 视频广告推广 -->
		<div class="ad_container">
			<div class="ad_top">
				<p class="ad_top_text">推广</p>
				<img class="ad_top_more" src="/JConsoleGroup/images/ads/more.png" />
			</div>

			<div class="ad_logo">
				<div class="ad_logo_pic">
					<img alt="" src="/JConsoleGroup/images/ads/apple_logo.png" />
				</div>
				<div class="ad_logo_name">Apple</div>
			</div>
			<div class="ad_title">改变世界不如改变自己，你简单世界就简单，你精彩每天都精彩。</div>

			<div class="ad_pic">
				<video width="100%" height="180px" id="playVideo" preload="preload"
					controls="controls" poster="/JConsoleGroup/images/ads/apple.png"> <source
					src="/JConsoleGroup/videos/iphone.mp4" type="video/mp4">当前浏览器不支持
				video直接播放，点击这里下载视频： <a href="/">下载视频</a></video>
			</div>

			<div class="ad_bottom">
				<div class="ad_bottom_text">近期热门推荐</div>
				<div class="ad_bottom_btn">
					<a href="" class="">去看看</a>
				</div>
			</div>
		</div>

		<!-- 公众号推广 -->
		<div class="ad_container">
			<div class="ad_top">
				<p class="ad_top_text">推广</p>
				<img class="ad_top_more" src="/JConsoleGroup/images/ads/more.png" />
			</div>

			<div class="ad_logo">
				<div class="ad_logo_pic">
					<img alt="" src="/JConsoleGroup/images/ads/vip_logo.jpg" />
				</div>
				<div class="ad_logo_name">唯品会</div>
			</div>
			<div class="ad_title">一家专门做特卖的网站,关注赢豪礼！</div>

			<div class="ad_pic">
				<!-- Swiper -->
				<div class="swiper-container swiper-container1">
					<div class="swiper-wrapper">
						<div class="swiper-slide swiper_slide_ad"
							style="background-image: url(/JConsoleGroup/images/ads/vip.jpg); background-size: 100% 100%;">
						</div>
						<div class="swiper-slide swiper_slide_ad"
							style="background-image: url(/JConsoleGroup/images/ads/vip-2.jpg); background-size: 100% 100%;"></div>
						<div class="swiper-slide swiper_slide_ad"
							style="background-image: url(/JConsoleGroup/images/ads/vip-3.jpg); background-size: 100% 100%;"></div>

					</div>
					<!-- Add Pagination -->
					<div class="swiper-pagination"></div>
				</div>

				<!-- Swiper JS -->
				<script src="/JConsoleGroup/js/swiper.jquery.min.js"></script>

				<!-- Initialize Swiper -->
				<script>
					var swiper = new Swiper('.swiper-container1', {
						pagination : '.swiper-pagination',
						slidesPerView : 'auto',
						paginationClickable : true,
						spaceBetween : 30
					});
				</script>
			</div>

			<div class="ad_bottom">
				<div class="ad_bottom_text">近期热门推荐</div>
				<div class="ad_bottom_btn">
					<a
						href="https://mp.weixin.qq.com/mp/profile_ext?action=home&scene=110&__biz=MjM5NTAwOTQwMA==#wechat_redirect"
						class="">关&nbsp;注</a>
				</div>
			</div>
		</div>

		<!-- 分割线 -->
		<div class="separate"></div>
	</div>
</body>
</html>