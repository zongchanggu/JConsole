<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<title>广告展示页面</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../../css/bottomAD.css" />
<link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../../css/willesPlay.css" />
<script src="../../js/jquery-1.11.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../../js/willesPlay.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>



	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div id="willesPlay">
					<div class="playHeader">
						<div class="videoName">广告标题</div>
					</div>
					<div class="playContent">
						<div class="turnoff">
							<ul>
								<li><a href="javascript:;" title="喜欢"
									class="glyphicon glyphicon-heart-empty"></a></li>
								<li><a href="javascript:;" title="关灯"
									class="btnLight on glyphicon glyphicon-sunglasses"></a></li>
								<li><a href="javascript:;" title="分享"
									class="glyphicon glyphicon-share"></a></li>
							</ul>
						</div>
						<video width="100%" height="100%" id="playVideo" preload="preload">
						<source
							src="http://220.167.105.121/170/2/11/acloud/151672/letv.v.yinyuetai.com/he.yinyuetai.com/uploads/videos/common/6609014F06AE1C8E99DE142502A2B157.flv?crypt=95aa7f2e98550&b=1314&nlh=3072&nlt=45&bf=6000&p2p=1&video_type=flv&termid=0&tss=no&geo=CN-23-323-1&platid=0&splatid=0&its=0&qos=5&fcheck=0&proxy=3062324601,2101603530,3683272595&uid=3063271287.rp&keyitem=GOw_33YJAAbXYE-cnQwpfLlv_b2zAkYctFVqe5bsXQpaGNn3T1-vhw..&ntm=1447949400&nkey=55c24f4c47dd315085c383e07750f67e&nkey2=3344c026a5c147651522c75bc51fb700&sc=0e90a16b75f7bc55&br=3136&vid=782863&aid=1559&area=KR&vst=0&ptp=mv&rd=yinyuetai.com?sc=0e90a16b75f7bc55&errc=0&gn=1065&buss=106551&cips=182.149.207.119&lersrc=MTI1Ljg5Ljc0LjE3MQ==&tag=yinyuetai&cuhost=letv.v.yinyuetai.com&cuid=151672&flw3x=0&sign=coopdown&fext=.flv&br=3136&ptp=mv&rd=yinyuetai.com"
							type="video/mp4"></source> 当前浏览器不支持 video直接播放，点击这里下载视频： <a
							href="/">下载视频</a> </video>
						<div class="playTip glyphicon glyphicon-play"></div>
					</div>
					<div class="playControll">
						<div class="playPause playIcon"></div>
						<div class="timebar">
							<span class="currentTime">0:00:00</span>
							<div class="progress">
								<div
									class="progress-bar progress-bar-danger progress-bar-striped"
									role="progressbar" aria-valuemin="0" aria-valuemax="100"
									style="width: 0%"></div>
							</div>
							<span class="duration">0:00:00</span>
						</div>
						<div class="otherControl">
							<span class="volume glyphicon glyphicon-volume-down"></span> <span
								class="fullScreen glyphicon glyphicon-fullscreen"></span>
							<div class="volumeBar">
								<div class="volumewrap">
									<div class="progress">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuemin="0" aria-valuemax="100"
											style="width: 8px; height: 40%;"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>



	<!-- 底部广告Banner -->
	<div class="bottomAD" id="bottomAD">
		<div class="bottom-con">
			<div class="bottom-pic">
				<img src="./images/HM2.jpg" alt="" />
			</div>
			<div class="logo_title">HM</div>
			<div class="bottom-text" id="bottomText">潮流时尚资讯，尽在HM！</div>
			<div class="bottom-btn bottom_btn_hover">
				<a id="bottomLink"
					href="https://mp.weixin.qq.com/mp/profile_ext?action=home&scene=110&__biz=MzA5MzUwODczOA==#wechat_redirect"></a>
				关&nbsp;注	
			</div>
			<div class="close_btn"><img alt="" src="../../images/close.png"  style="width:22px;height:22px;float:right" onclick="bottomAD.style.display='none'"></div>
		</div>

	</div>
    
</body>
</html>