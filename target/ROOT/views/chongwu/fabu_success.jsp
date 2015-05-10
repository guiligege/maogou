<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/maogou.ico" rel="shortcut icon" />
		<title>理财么-自助理财平台，发现，分享好的理财产品，分享理财经验，让财富增长从理财开始。</title>
		<meta name="keywords" content="理财么,理财,自助理财,理财产品,银行理财,银行理财产品,互联网理财,互联网理财产品,理财知识,理财经验,互联网理财产品排行榜" />
		<meta name="description" content="理财么是自助理财平台，我们的提供互联网上能查到的各种银行的理财产品供大家选择适合自己的理财产品，" />
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<%@include file="/views/commons/cssandscript.jsp" %>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		<script type="text/javascript">
		</script>
		<style>
		.icon-succ01 {
			background: url(../../img/chongwu/icon_pubsucc.png) no-repeat;
			display: inline;
			height: 70px;
			margin: 35px 0 0 85px;
			width: 95px;
			}
			
			.release-success .publish01 {
padding-left: 20px;
}
.fl {
float: left;
}
.release-success {
font-size: 14px;
margin-left: 250px;
margin-bottom: 100px;
margin-top: 90px;
}
.clearfix:after {
content: "\0020";
display: block;
clear: both;
height: 0;
visibility: hidden;
}
.release-success h2 {
font-size: 24px;
padding: 7px 0 18px 0;
font-weight: bold;
color: #ec3701;
vertical-align: middle;
font-family: "Microsoft YaHei";
margin-bottom: 30px;
}
.release-success .publish01 p {
margin-top: 20px;
}
.release-success .st1 {
text-align: left;
height: 20px;
}
p {
display: block;
-webkit-margin-before: 1em;
-webkit-margin-after: 1em;
-webkit-margin-start: 0px;
-webkit-margin-end: 0px;
}
.link-tip {
margin-top: 20px;
height: 24px;
}
ol, ul, li {
list-style: none;
}
.link-tip li {
float: left;
}
.button-green {
color: #fff;
background: #6ba001;
background: -webkit-gradient(linear,left top,left bottom,from(#5e9d01),to(#75a201));
background: -moz-linear-gradient(top,#5e9d01,#75a201);
-pie-background: linear-gradient(top,#5e9d01,#75a201);
border: 1px solid #6ba001;
}
a.button-green, a.button-green:hover {
color: #fff;
}
#bdshare {
_overflow-x: hidden;
z-index: 999999;
padding-bottom: 2px;
font-size: 12px;
float: left;
text-align: left!important;
zoom: 1;
}
.button {
border-radius: 3px;
cursor: pointer;
font-size: 14px;
font-weight: bold;
outline: none !important;
text-align: center;
text-decoration: none;
position: relative;
-moz-box-sizing: border-box !important;
margin-right: 10px;
padding: 0 5px;
border: 1px solid #6ba001;
height: 24px;
line-height: 24px;
}
.button {
float: left;
font-size: 14px;
font-weight: bold;
display: inline-block;
height: 31px;
line-height: 30px;
margin-right: 15px;
padding-left: 2px;
}
		</style>
	</head>
	<body>
		<jsp:include page="/views/commons/chongwu_header_content.jsp"></jsp:include>
		<div class="release-success ">
			<div class="clearfix">
		        <div class="icon-succ01 fl"></div>
		        <div class="publish01 fl">
		            <h2>发布成功啦</h2>
		            <p class="st1">您的帖子"<a href="http://bj.ganji.com/gou/15033023_5046347.htm?_rtm=1">宠物狗售卖售卖</a>"已发布到"<a href="http://bj.ganji.com/gou/qinghe/a1/">清河-宠物狗</a>"类目下</p>
		            <ul class="link-tip">
		                <li><a class="button-green button" href="http://bj.ganji.com/gou/15033023_5046347.htm?_rtm=1">立即查看</a></li>
		                <li><a class="button-green button" href="/vip" target="_blank">管理信息</a></li>
		                <li><span class="button-green button" href="javascript:void(0);" title="猫狗网"  onclick="join_favorite('http://www.51maogou.com','猫狗网');">添加到收藏夹</span></li>
		                <li>
		                    <span id="bdshare" style="cursor:pointer;color:#24d;margin-top:4px;font-size:14px;" class="fa bdshare_b" data="{'url': 'http://bj.ganji.com/gou/15033023_5046347.htm?_rtm=1'}">分享&nbsp;&gt;&gt;</span>
		                </li>
		            </ul>
		        </div>
	      	</div> 
      </div>
		<jsp:include page="/views/commons/taochongwu_footer.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
	//定义加入收藏夹函数
	function join_favorite(siteUrl, siteName){ 
		//捕获加入收藏过程中的异常       
		try{      
			 //判断浏览器是否支持document.all         
			if(document.all){                      
			//如果支持则用external方式加入收藏夹                       
				window.external.addFavorite(siteUrl,siteName);                
			}else if(window.sidebar){                      
			  //如果支持window.sidebar，则用下列方式加入收藏夹    
				window.sidebar.addPanel(siteName, siteUrl,'');            
			}                
		}   
		//处理异常      
		catch (e)        {          
			alert("加入收藏夹失败，请使用Ctrl+D快捷键进行添加操作!");     
		}
	}
	//sleep后跳转
	/* $(function() {
		sleep();
		window.location.href="/chongwu/tofabu.htm";
	});
	
	function sleep(numberMillis) { 
		var now = new Date(); 
		var exitTime = now.getTime() + numberMillis; 
		while (true) { 
		now = new Date(); 
		if (now.getTime() > exitTime) 
		return; 
		} 
	} */
	</script>
</html>