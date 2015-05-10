<%-- 剥离出来的内容部分 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shopencode" uri="http://www.licaime.com/brandstore/shopel"%>
<style>
.relatedList{
	width: 300px;
margin-top: 10px;
}
.investments_area{
width: 144px;
/* display: inline-block; */
}
.marginleft8{
margin-left: 8px;
}
.detail_right_price {
color: #ff6c00;
margin-left: 30px;
}
.detail_right_desc_bottom {
padding-bottom: 5px;
}
.detail_right_desc {
width: 144px;
}
.detail_right_img {
padding-top: 10px;
padding-bottom: 5px;
}
</style>
<div class="container">
		<div class="left">
			<div class="well">
				<ul class="nav nav-pills">
                    <li class="disabled">
                       <a href="${_contextPath}/dog.htm" style="font-size: larger;">所有宠物狗</a>
                    </li>
                </ul>
                <!-- 宠物类别 -->
                <c:forEach var="firstMap" items="${categoryPetMap}">
                	<ul class="nav nav-pills" style="margin-left: 5px;">
	                    <li class="disabled">
	                       <a href="${_contextPath}/dog.htm">${firstMap.key}</a>
	                    </li>
                	</ul>
	                <ul class="nav nav-pills" style="margin-left: 40px;">
	                    	<c:forEach var="secondMap" items="${firstMap.value}">
	                    	<li class="${pageParam.categoryId==secondMap.id ?'active':''}">
	                    		<a href="${_contextPath}/dog-${pageParam.adressId}-${pageParam.pAdressId}-${secondMap.id}-${pageParam.status}-1.htm">
	                    			${secondMap.name}
	                    			<c:if test="${secondMap.refname!=null and  secondMap.refname ne ''}">
	                    			(${secondMap.refname})
	                    			</c:if>
	                    		</a>
	                    	</li>
	                    	</c:forEach>
	                </ul>
                </c:forEach>
                <c:if test="${pageParam.adressId==null}">
	                <!-- 宠物地址-->
	               	<ul class="nav nav-pills" style="margin-left: 5px;">
	                    <li class="disabled">
	                       <a href="">地址</a>
	                    </li>
	               	</ul>
	               	<ul class="nav nav-pills" style="margin-left: 40px;">
	                <c:forEach var="petAddress" items="${petAddressList}">
		                    <li class="${petAddress.id==pageParam.pAdressId ?'active':''}">
		                       <a href="${_contextPath}/dog-${pageParam.adressId}-${petAddress.id}-${pageParam.categoryId}-${pageParam.status}-1.htm">${petAddress.city}</a>
		                    </li>
	                </c:forEach>
	                </ul>
                </c:if>
            </div>
			<c:forEach var="product" items="${bList}" varStatus="index">
				<div style="position: relative;" class="project-summary wall">
				            <div class="row-fluid">
				       <div class="listimage">
				            <a target="_blank" href="${_contextPath}/chongwu/detail-${product.id}.htm">
				            	<img src="${product.imageDetail1}" alt="${product.title}" width="120" height="90">
				            </a>
				        </div>
				        <div class="span6 " style="vertical-align: top;padding-top: 15px;">
				            <div class="pet">
				                <h4 style=" line-height:45px;">
				                    <a href="${_contextPath}/chongwu/detail-${product.id}.htm" target="_blank" style="display: block;color: #15c; ">
				                    	<%-- ${product.productName} --%>
				                    	${product.title}
				                    </a>
				                </h4>
				                <p class="project-tags">
				                    <span class="tag">
				                        <i class="icon-retweet"></i>
				                      性别：${product.sex}
				                    </span>
									<span class="tag">
			                            <i class="icon-certificate"></i>
			                            年龄：${product.age}
			                        </span>
									<span class="tag">
			                            <i class="icon-certificate"></i>
			                            犬种：<a href="${_contextPath}/dog-${pageParam.adressId}-${pageParam.pAdressId}-${product.categoryId}-${pageParam.status}-1.htm">${product.category}</a>
			                        </span>
			                        <span class="tag">
			                            <i class="icon-certificate"></i>
			                            地址：<a href="${_contextPath}/dog-${product.adressId}-${pageParam.pAdressId}-${pageParam.categoryId}-${pageParam.status}-1.htm">${product.adress}</a>
			                        </span>
				                </p>
				            </div>
				        </div>
				        <div >
				            <ul class="project-summary-items">
					                <li>
					                	<span class="important">${product.price}</span>元
					               	</li>
					               	<li>
					                	<fmt:formatDate value="${product.createTime }" pattern="MM月dd日"/>
					               	</li>
				            </ul>
				        </div>
				    </div>
				</div>
			</c:forEach>
		    <jsp:include page="/views/commons/page.jsp"></jsp:include>
		</div>
		<div class="right post-thumbnail">
			<!-- <section>
		        <a class="more" href="#">更多</a>
		        <h3>媒体报道</h3>
		        <ul>
	                <li><a target="_blank" href="http://www.gzmama.com/thread-3443921-1-1.html">十年理财经验调研各大银行理财产品利率</a></li>
	                <li><a target="_blank" href="http://www.yinhang123.net/wangdian/licaichanpin/2014/0623/25422.html">6月23日宝宝军团收益排名</a></li>
		        </ul>
		    </section> -->
		   <!--  <hr> -->
		   <!--  <div>
		    百度广告
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636420";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div> -->
		    <div class="relatedList">
                <!-- <div class="investments_area">
                	<div class="detail_right_img">
                		<img src="http://pic1.58cdn.com.cn/p1/tiny/n_s12455861782709658025.jpg" alt="微笑天使萨摩耶大雪山精灵签协议送用品全场7折青子衿"  width="144px" height="108px" data-bd-imgshare-binded="1"></img>
                	</div>
                	<div class="detail_right_desc detail_right_desc_bottom">
                		<span style="color: blue;">微笑天使萨摩耶大雪山精灵签协议送用品全场7折青子衿</span>
                	</div>
                	<div class="detail_right_desc">
                		<span class="detail_right_date">03月23日</span>
                		<span  class="detail_right_price">1000元</span>
                	</div>
                 </div>
                 <div class="investments_area marginleft8">
                	<div class="detail_right_img">
                		<img src="http://pic1.58cdn.com.cn/p1/tiny/n_s12455861782709658025.jpg" alt="微笑天使萨摩耶大雪山精灵签协议送用品全场7折青子衿"  width="144px" height="108px" data-bd-imgshare-binded="1"></img>
                	</div>
                	<div class="detail_right_desc detail_right_desc_bottom">
                		<span style="color: blue;">微笑天使萨摩耶大雪山精灵签协议送用品全场7折青子衿</span>
                	</div>
                	<div class="detail_right_desc">
                		<span class="detail_right_date">03月23日</span>
                		<span  class="detail_right_price">1000元</span>
                	</div>
                 </div> -->
                 <c:forEach var="product" items="${relationPets}" varStatus="status">
                 <div class="investments_area">
                	<div class="detail_right_img">
                		<a href="${_contextPath}/chongwu/detail-${product.id}.htm"><img src="${product.imageDetail1}" alt="${product.title}"   width="144px" height="108px" data-bd-imgshare-binded="1"></img></a>
                	</div>
                	<div class="detail_right_desc detail_right_desc_bottom">
                		<span style="color: blue;"><a href="${_contextPath}/chongwu/detail-${product.id}.htm">${product.title}</a></span>
                	</div>
                	<div class="detail_right_desc">
                		<span class="detail_right_date"><fmt:formatDate value="${product.createTime }" pattern="MM月dd日"/></span>
                		<span  class="detail_right_price">${product.price}元</span>
                	</div>
                 </div>
                 <%-- <c:if test="${status.index%2==0}">
                  <div class="investments_area">
                	<div class="detail_right_img">
                		<a href="${_contextPath}/chongwu/detail-${product.id}.htm"><img src="${product.imageDetail1}" alt="${product.title}"   width="144px" height="108px" data-bd-imgshare-binded="1"></img></a>
                	</div>
                	<div class="detail_right_desc detail_right_desc_bottom">
                		<span style="color: blue;"><a href="${_contextPath}/chongwu/detail-${product.id}.htm">${product.title}</a></span>
                	</div>
                	<div class="detail_right_desc">
                		<span class="detail_right_date"><fmt:formatDate value="${product.createTime }" pattern="MM月dd日"/></span>
                		<span  class="detail_right_price">${product.price}元</span>
                	</div>
                 </div>
                 </c:if>
                 <c:if test="${status.index%2==1}">
                  <div class="investments_area marginleft8">
                	<div class="detail_right_img">
                		<a href="${_contextPath}/chongwu/detail-${product.id}.htm"><img src="${product.imageDetail1}" alt="${product.title}"   width="144px" height="108px" data-bd-imgshare-binded="1"></img></a>
                	</div>
                	<div class="detail_right_desc detail_right_desc_bottom">
                		<span style="color: blue;"><a href="${_contextPath}/chongwu/detail-${product.id}.htm">${product.title}</a></span>
                	</div>
                	<div class="detail_right_desc">
                		<span class="detail_right_date"><fmt:formatDate value="${product.createTime }" pattern="MM月dd日"/></span>
                		<span  class="detail_right_price">${product.price}元</span>
                	</div>
                 </div>
                 </c:if> --%>
                 </c:forEach>
		    </div>
		   <!--  <div>
		    tanx广告
		    <script type="text/javascript">
			     document.write('<a style="display:none!important" id="tanx-a-mm_48124372_7062997_23960588"></a>');
			     tanx_s = document.createElement("script");
			     tanx_s.type = "text/javascript";
			     tanx_s.charset = "gbk";
			     tanx_s.id = "tanx-s-mm_48124372_7062997_23960588";
			     tanx_s.async = true;
			     tanx_s.src = "http://p.tanx.com/ex?i=mm_48124372_7062997_23960588";
			     tanx_h = document.getElementsByTagName("head")[0];
			     if(tanx_h)tanx_h.insertBefore(tanx_s,tanx_h.firstChild);
			</script> 
			sogou
		    </div>
		    淘宝组件
		    <div>
		    百度广告
		    <script type="text/javascript">
			    /*300*250 创建于 2014-07-29*/
			    var cpro_id = "u1636443";
			</script>
			<script src="http://cpro.baidustatic.com/cpro/ui/c.js" type="text/javascript"></script>
		    </div> -->
		</div>
	</div>
<!-- 加入百度分享 -->
	<script>window._bd_share_config={"common":{"bdSnsKey":{"tsina":"4149632123","tqq":"801527859"},"bdText":"","bdMini":"1","bdMiniList":["qzone","tsina","weixin","tqq","douban","sqq"],"bdPic":"","bdStyle":"0","bdSize":"24"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>