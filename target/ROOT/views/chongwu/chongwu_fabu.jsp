<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/maogou.ico" rel="shortcut icon" />
		<title>宠物信息发布-猫狗网</title>
		<meta name="keywords" content="宠物狗,宠物狗价格,宠物狗图片,宠物分享,猫狗网"/>
		<meta name="description" content="猫狗网是一个宠物分享平台，是一个中立的，致力于帮助广大网友找到最适合自己的宠物，分享自己的宠物，每天为网友们提供来自互联网的宠物信息，保证数据的真实有效性。猫狗网信息大部分来自网友的分享，您也可以分享自己的萌宠照片，分享养宠经验。"/>
		<!-- 公共setting配置 -->
		<%@include file="/views/commons/config.jsp" %>
		<%@include file="/views/commons/cssandscript.jsp" %>
		<link rel="stylesheet" href="${domain_css}/css/licai/style.css?${version_css}" />
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<jsp:include page="/views/commons/chongwu_header_content.jsp"></jsp:include> 
		<jsp:include page="fabu_detail.jsp"></jsp:include>
		<jsp:include page="/views/commons/taochongwu_footer.jsp"></jsp:include>
	</body>
</html>