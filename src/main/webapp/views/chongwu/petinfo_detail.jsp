<%-- 剥离出来的新的首页 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shopel" uri="/WEB-INF/pagetag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<meta http-equiv="content-type" content="text/html; charset=utf-8">
  	<%-- <link type="image/x-icon" href="${pageContext.request.contextPath}/ico/maogou.ico" rel="shortcut icon"> --%>
  	<link type="image/x-icon" href="${pageContext.request.contextPath}/ico/maogou.ico" rel="shortcut icon" />
  	<title>${petSaleInfo.title}-${petSaleInfo.city}${petSaleInfo.adress}宠物狗-猫狗网</title>
	<meta name="keywords" content="${petSaleInfo.title}-${petSaleInfo.city}${petSaleInfo.adress}宠物狗-猫狗网" />
	<meta name="description" content="${petSaleInfo.title}-${petSaleInfo.city}${petSaleInfo.adress}宠物狗-猫狗网" />
	<%@include file="/views/commons/config.jsp" %>
	<%@include file="/views/commons/cssandscript.jsp" %>
  	<link rel="stylesheet" type="text/css" href="${domain_css}/css/licai/detail/detail.css?${version_css}">
  	<script type="text/javascript" src="${domain_js}/js/licai/highcharts.js?${version_js}"></script>
  	<script type="text/javascript" src="${domain_js}/js/licai/modules/exporting.js?${version_js}"></script>
  	<script type="text/javascript">
		</script>
	<style>
	.daohang{
		margin-top: 10px;
		margin-left: 140px;
	}
	.daohang a {
		color: #06c;
	}
	</style>
  </head>
  <body>
  <jsp:include page="/views/commons/chongwu_header_content.jsp"></jsp:include> 
  		<div class='daohang'>
  			<a href="http://www.51maogou.com">首页</a>> <a href="http://www.51maogou.com/dog--${petSaleInfo.pAdressId}---1.htm">猫狗网-${petSaleInfo.city}</a>> <a href="http://www.51maogou.com/dog-${petSaleInfo.adressId}-${petSaleInfo.pAdressId}---1.htm">猫狗网-${petSaleInfo.adress}</a>> <a href="http://www.51maogou.com/dog---${petSaleInfo.categoryId}--1.htm">猫狗网-${petSaleInfo.category}</a>
  		</div>
		<div style="padding-bottom: 25px;"></div>
        <div class="center">
          <div class="row-fluid">
            <div class="center-left" style="margin-top: 10px;">
              <div class="left-one">
              	<div id="bdshare" style="float: right;margin-top: 5px;" class="bdshare_t bds_tools get-codes-bdshare" data="{'text':'猫狗网   - ${petSaleInfo.title}}','url':'http://www.51maogou.com/chongwu/detail-${petSaleInfo.id}.htm','pic':'http://www.51maogou.com/img/maogou/maogou1.jpg'}">
			        <a class="bds_qzone"></a>
			        <a class="bds_tsina"></a>
			        <a class="bds_tqq"></a>
			        <!--<a class="bds_renren"></a> -->  
			        <span class="bds_more"></span>
			    </div>
                <div class="left-one-title">
                  <h2>
       ${petSaleInfo.title}-猫狗网       </h2>
                </div>
              </div>
              <hr class="dashed" style=" margin-bottom: 0;">
              <div class="left-five" style="padding-bottom:20px;">
                <div class="left-five-info1">
                      <div calss="info_wenzi" style="position: relative;">
                        <div class="span6">
                          <dl class="dl-horizontal">
                            <dt>价　　格：</dt>
                            <dd class="orangeinfo">${petSaleInfo.price}元 </dd>
                            <dt>宠物年龄：</dt>
                            <dd style="margin-left: 125px;">${petSaleInfo.age}
                            </dd>
                            <dt>宠物性别：</dt>
                            <dd style="margin-left: 125px;">${petSaleInfo.sex}
                            </dd>
                            <dt>卖家承诺：</dt>
                            <dd style="margin-left: 125px;">
                            ${petSaleInfo.yimiao}
                            </dd>
                            <dt>交易地点：</dt>
                            <dd style="margin-left: 125px;"> ${petSaleInfo.city},${petSaleInfo.adress}
                            </dd>
                            <dt>联系人：</dt>
                            <dd style="margin-left: 125px;">${petSaleInfo.nickName}</dd>
                            <dt>电　　话：</dt>
                            <dd class="orangeinfo">
                            <c:choose>
                             	<c:when test="${fn:contains(petSaleInfo.telephone, 'http')}">
                             	   <img src="${petSaleInfo.telephone}"></img>
                             	</c:when>
                             	<c:otherwise>
                             		${petSaleInfo.telephone}
                             	</c:otherwise>
                            </c:choose>
                            </dd>
                            <dt>QQ　 号：</dt>
                            <dd class="orangeinfo">
                            <c:choose>
                             	<c:when test="${fn:contains(petSaleInfo.qq, 'http')}">
                             	   <img src="${petSaleInfo.qq}"></img>
                             	</c:when>
                             	<c:otherwise>
                             		${petSaleInfo.qq}
                             	</c:otherwise>
                            </c:choose>
                            </dd>
                          </dl>
                        </div>
                        <div class="span6">
                          <dl class="dl-horizontal tipsinfo" style="width: 240px;">
                            <dd class="tipsdd">
                           	   狗狗购买全攻略:
				            </dd>
                            <dd class="tipsdd">
                            1.怎样识别狗狗是否健康
				            </dd>
				             <dd class="tipsdd">
                            2.买狗注意事项
				            </dd>
				             <dd class="tipsdd">
                            3.狗骗子常用骗术大揭密
				            </dd>
                          </dl>
                        </div>
                      </div>
                    </div>
                    <div class="left-five-info2" style="clear: both;">
                      <hr class="dashed">
                      <div style="font-size: 14px;
font-weight: bolder;padding-bottom: 10px;">详细描述:</div>
                      <div class="left-five-info2" style="clear: both;font-size: 14px;">
                    	${petSaleInfo.descrip}
            		</div>
             		<hr class="dashed">
                      <div class="left-five-info2" style="clear: both;">
                    	“猫狗网”是一个宠物分享平台，是一个中立的，致力于帮助广大网友找到最适合自己的宠物，分享自己的爱宠。每天为网友们提供各种宠物信息，保证数据的真实有效性。猫狗网信息大部分来自网友的分享，您也可以分享自己的萌宠照片，分享养宠经验。
                      </div>
                     <hr class="dashed">
                     <div style="font-size: 14px;
margin-bottom: 10px;
margin-left: 10px;
font-weight: bold;">宠物照片:</div>
                      <div class="left-five-info2" style="clear: both;padding-left: 80px;">
                    	<!-- <image src="http://scs.ganjistatic1.com/gjfs12/M06/B1/68/CgEHolT6U7,hvE1XAADe8Sry3uU787_600-0_6-0.jpg" ></image> -->
						<image src="${petSaleInfo.imageDetail2}" ></image>
						<image src="${petSaleInfo.imageDetail3}" ></image>
						<image src="${petSaleInfo.imageDetail4}" ></image>
                      </div>
                    </div>
                  </div>
            </div>
            <div class="center-right">
              <p>
                <i class="sign icon" style="margin-top:2px"></i>猫狗网提醒您：
              </p>
              <p style="margin-left: 15px;">让您提前汇款的都是骗子，请谨慎汇款！</p>
              <hr>
              <h3>更多同类宠物信息</h3>
              <div class="investmentedList">
              <c:forEach var="product" items="${relationPets}" varStatus="index">
                <div class="investments_area">
                	<div class="detail_right_img">
                		<a href="${_contextPath}/chongwu/detail-${product.id}.htm"><img src="${product.imageDetail1}" alt="${product.title}"  width="144px" height="108px" data-bd-imgshare-binded="1"></img> </a>
                	</div>
                	<div class="detail_right_desc detail_right_desc_bottom">
                		<span style="color: blue;"><a href="${_contextPath}/chongwu/detail-${product.id}.htm">${product.title}</a></span>
                	</div>
                	<div class="detail_right_desc">
                		<span class="detail_right_date"><fmt:formatDate value="${product.createTime }" pattern="MM月dd日"/></span>
                		<span  class="detail_right_price">${product.price}元</span>
                	</div>
                 </div>
               </c:forEach>
               </div>
            </div>
          </div>
        </div>
        <!-- 百度统计 -->
        <div class="none">
			<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F19d3582fea421029f25811115d6cdf0e' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
		<jsp:include page="/views/commons/taochongwu_footer.jsp"></jsp:include>
		<!-- 百度广告开始 -->
		<!-- <script type="text/javascript">
		    /*250*200 创建于 2014-07-29*/
		var cpro_id = "u1636408";
		</script>
		<script src="http://cpro.baidustatic.com/cpro/ui/f.js" type="text/javascript"></script> 
		<!-- 百度广告开始 结束>-->
  </body>
</html>