<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/maogou.ico" rel="shortcut icon" />
		<title>${seoInfo.title}</title>
		<meta name="keywords" content="${seoInfo.keywords}"/>
		<meta name="description" content="${seoInfo.description}"/>
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<!--Javascript-->
		<jsp:include page="/views/commons/cssandscript.jsp"></jsp:include>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		<style>
		.daohang{
			margin-top: 10px;
			margin-left: 100px;
		}
		.daohang a {
			color: #06c;
		}
		</style>
	</head>
	<body>
		<jsp:include page="/views/commons/chongwu_header_content.jsp"></jsp:include> 
		<div class='daohang'>
  			<a href="http://www.51maogou.com">首页</a>> <a href="http://www.51maogou.com/dog.htm">猫狗网-宠物狗</a>
  		</div>
		<div style="padding-bottom: 20px;"></div>
		<jsp:include page="petinfo_common_list.jsp"></jsp:include>
		<jsp:include page="/views/commons/taochongwu_footer.jsp"></jsp:include>
		<div class="none">
			<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
		<!-- 百度广告开始 -->
		<!-- 百度广告结束-->
	</body>
	
</html>