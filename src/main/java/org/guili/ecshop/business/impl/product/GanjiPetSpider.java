package org.guili.ecshop.business.impl.product;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.exception.RemoteServiceException;
import org.guili.ecshop.util.AbstractResponseHandler;
import org.guili.ecshop.util.FileTools;
import org.guili.ecshop.util.HttpComponent;
import org.guili.ecshop.util.SpiderRegex;
import org.guili.ecshop.util.chongwu.PetUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 赶集，宠物抓取
 * @author Administrator
 */
public class GanjiPetSpider extends PetSpiderParent{

	private static Logger logger=Logger.getLogger(GanjiPetSpider.class);
	private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";
	//http请求组件封装
	private HttpComponent httpComponent;
	
	private PetUtil petUtil;
	
	//pet信息列表handler
	private final PetInfoListHandler petInfoListHandler = new PetInfoListHandler();
	//pet信息详细handler
	private final PetInfoDetailHandler petInfoDetailHandler = new PetInfoDetailHandler();
	//58list
	private class PetInfoListHandler extends AbstractResponseHandler<List<PetSaleInfo>> {
        @Override
        public List<PetSaleInfo> handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
            if(entityStr==null || entityStr.length()<20384){
            	logger.error("connect Exception----entityStr.length() is so short");
            }
            FileTools.write("E:/spiderfile/ganjitestlist1.txt", entityStr);
            Document doc = Jsoup.parse(entityStr);
            Elements pics_ele =doc.select(".picside img");
            Elements detailurl_ele =doc.select(".picside a");
            Elements category_ele =doc.select(".list-word");
            String baseurl =doc.select(".fc-city").attr("href");
            
            //解析
//            //解析多个单独的宠物资源
            if(detailurl_ele==null || detailurl_ele.size()==0){
    			return null;
    		}
            //获取url的所有宠物信息
            List<PetSaleInfo> petSaleInfoList=new ArrayList<PetSaleInfo>();
            for(int i=0;i<detailurl_ele.size();i++){
            	PetSaleInfo petSaleInfo=new PetSaleInfo();
            	String detailurl = detailurl_ele.get(i).attr("href");
            	if(!detailurl.startsWith("http://click.ganji.com/click.php")){
            		detailurl=baseurl+detailurl;
            	}
            	//防止传入错误url
            	if(detailurl.lastIndexOf("http://")>0){
            		continue;
            	}
            	logger.debug("detail url-->"+detailurl);
            	try {
            		logger.info("detail url-->"+detailurl);
            		//跳过风控
					Thread.sleep(3000);
            		//调用单个抓取
            		petSaleInfo=petDetailHttp(detailurl);
				} catch (Exception e) {
					logger.error("detail url crawal error:"+e.getStackTrace());
				}
            	if(petSaleInfo==null){
            		continue;
            	}
            	if(i<=4){
            		logger.debug(pics_ele.get(i).attr("src"));
                	petSaleInfo.setImageDetail1(pics_ele.get(i).attr("src"));
            	}else{
            		logger.debug(pics_ele.get(i).attr("data-original"));
                	petSaleInfo.setImageDetail1(pics_ele.get(i).attr("data-original"));
            	}
            	petSaleInfo.setCategory(category_ele.get(i).getElementsByTag("a").get(1).text().trim());
            	petSaleInfo.setCategoryId(petUtil.getPetCategory(petSaleInfo.getCategory()));
//            	petSaleInfo.setAdressId(PetUtil.getPetAddressId(citys[0],address[1]));
            	petSaleInfoList.add(petSaleInfo);
            }
            return petSaleInfoList;
        }
    }
	
	//ganji detail
	private class PetInfoDetailHandler extends AbstractResponseHandler<PetSaleInfo> {
        @Override
        public PetSaleInfo handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
//            FileTools.write("E:/spiderfile/ganjitestdetail1.txt", entityStr);
            if(entityStr==null || entityStr.length()<20384){
            	logger.error("connect Exception----entityStr.length() is so short");
            }
            //解析
            Document doc = Jsoup.parse(entityStr);
            Element titleEle =doc.select(".title-name").first();
            Element priceEle =doc.select(".dog-price").first();
            Elements chengnuoEle =doc.select(".cn-items");
            Elements all_lis =doc.select(".det-infor li");
            Elements detail_all =doc.select(".dog-description div");
            Elements image_all =doc.select(".pics img");
            Elements category_all =doc.select(".dog-cate-col a");
            Elements addressA;
            if(all_lis.get(1).getElementsByTag("label").text().equals("交易地点：")){
            	addressA=all_lis.get(1).getElementsByTag("a");
            }else{
            	addressA=all_lis.get(0).getElementsByTag("a");
            }
//            addressA =doc.select(".det-infor li").get(0).getElementsByTag("a");
            Element telEle =doc.select(".phoneNum-style").first();
            Element qqEle =doc.select(".phoneNum-style").last();
            //详细
//            Element detailEle =doc.select(".col-cont");
            //title
            String title = titleEle.text();
            String price = priceEle.text();
            
            Element div1=detail_all.get(0);
            Element div2=detail_all.get(1);
            Element div3=detail_all.get(2);
            //宠物描述
            String detail="";
    		if(div3.html().trim().length()>30){
    			detail=div3.html().trim().substring(0, div3.html().trim().length()-29);
    		}
            //解析
            SpiderRegex regex = new SpiderRegex();
            String reg = "<i class=\"dog-price\">(.*?)<li>";
            String maijiareg = "class=\"f-gap01\"></i>人：</label>(.*?)<span class=\"fc-orange b-pet-ver\">";
            String[] doginfos = regex.htmlregex(entityStr,reg,false);
            String[] maijia = regex.htmlregex(entityStr,maijiareg,false);
            String[] infos=doginfos[0].split("\\|");
            logger.debug("title:"+title+"--price:"+price+"--");
            logger.debug("价格:"+infos[0]+"--性别："+infos[1]+"--岁数："+infos[2]);
            String yimiao="";
            if(chengnuoEle!=null && chengnuoEle.size()>0){
            	if(chengnuoEle.size()==3){
            		logger.debug(chengnuoEle.get(0).text()+"--"+chengnuoEle.get(1).text()+"--"+chengnuoEle.get(2).text());
            		yimiao=chengnuoEle.get(0).text().trim()+"--"+chengnuoEle.get(1).text().trim()+"--"+chengnuoEle.get(2).text().trim();
            	}else if(chengnuoEle.size()==2){
            		logger.debug(chengnuoEle.get(0).text()+"--"+chengnuoEle.get(1).text());
            		yimiao=chengnuoEle.get(0).text().trim()+"--"+chengnuoEle.get(1).text().trim();
            	}else{
            		logger.debug(chengnuoEle.get(0).text());
            		yimiao=chengnuoEle.get(0).text().trim();
            	}
            	 
            }
            logger.debug("市:"+addressA.get(0).text()+"--区县："+addressA.get(1).text());
            logger.debug("卖家:"+maijia[0]+"--");
            logger.debug("手机:"+telEle.text()+"--");
            logger.debug("qq:"+qqEle.text()+"--");
            logger.debug("detail:"+div3.html()+"--");
            logger.debug("image1:"+image_all.get(0).attr("src")+"--");
            logger.debug("image2:"+image_all.get(1).attr("src")+"--");
            logger.debug("image3:"+image_all.get(2).attr("src")+"--");
            logger.debug("种类:"+category_all.get(0).text()+"--");
//    		//构造返回对象
    		PetSaleInfo petSaleInfo=new PetSaleInfo();
    		petSaleInfo.setTitle(title);
    		petSaleInfo.setTitlehash(new Long(title.hashCode()));
    		//设置统一宠物狗类别
//    		petSaleInfo.setCategory(category_all.get(0).text().trim());
    		//设置宠物类别
//    		petSaleInfo.setCategoryId(petUtil.getPetCategory(petSaleInfo.getCategory()));
    		//设置宠物地址
    		petSaleInfo.setAdress(addressA.get(1).text().trim());
        	petSaleInfo.setCity(addressA.get(0).text().trim());
        	petSaleInfo.setpAdressId(petUtil.getPetPAddressId(petSaleInfo.getCity()));
        	if(petUtil.getPetAddressId(petSaleInfo.getCity(), petSaleInfo.getAdress())==0){
        		petSaleInfo.setAdressId(petUtil.getPetPAddressId(petSaleInfo.getCity()));
        	}else{
        		petSaleInfo.setAdressId(petUtil.getPetAddressId(petSaleInfo.getCity(), petSaleInfo.getAdress()));
        	}
    		//大图
    		if(image_all!=null && image_all.size()>0){
    			if(image_all.size()>=3){
    				petSaleInfo.setImageDetail2(image_all.get(0).attr("src").trim());
            		petSaleInfo.setImageDetail3(image_all.get(1).attr("src").trim());
            		petSaleInfo.setImageDetail4(image_all.get(2).attr("src").trim());
    			}else if(image_all.size()==2){
    				petSaleInfo.setImageDetail2(image_all.get(0).attr("src").trim());
            		petSaleInfo.setImageDetail3(image_all.get(1).attr("src").trim());
    			}else{
    				petSaleInfo.setImageDetail2(image_all.get(0).attr("src").trim());
    			}
    		}
    		petSaleInfo.setPrice(Integer.parseInt(price.trim()));
    			petSaleInfo.setQq(qqEle.text().trim());
        		petSaleInfo.setTelephone(telEle.text().trim());
    		if(maijia!=null ){
    			petSaleInfo.setNickName(maijia[0].trim());
    		}
    		//防止描述结尾带标签
    		String descrip=getDescription(detail);
    		petSaleInfo.setDescrip(descrip);
    		petSaleInfo.setAge(infos[2].trim());
    		petSaleInfo.setYimiao(yimiao);
    		petSaleInfo.setSex(infos[1].trim());
            return petSaleInfo;
        }
    }
	//获取详细信息
		private static String getDescription(String detail){
			if(StringUtils.isEmpty(detail)){
				return null;
			}
			String descrip=detail.length()>1000?detail.substring(0, 999):detail;
			if(descrip.endsWith("<br /")){
				descrip=descrip.substring(0, descrip.length()-"<br /".length());
			}else if(descrip.endsWith("<br ")){
				descrip=descrip.substring(0, descrip.length()-"<br ".length());
			}else if(descrip.endsWith("<br")){
				descrip=descrip.substring(0, descrip.length()-"<br".length());
			}else if(descrip.endsWith("<b")){
				descrip=descrip.substring(0, descrip.length()-"<b".length());
			}
			return descrip;
		}
		
	
	public PetSaleInfo petDetailHttp(String detailUrl)throws URISyntaxException, IOException {
		httpComponent=new HttpComponent();
		HttpGet httpGet = new HttpGet(detailUrl);
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		httpGet.addHeader("Cookie", "ganji_xuuid=b6913ed3-78b3-459e-a62c-aad15001574f; friend_tip=1; citydomain=sh; SiftRecord['1427045685']=%E4%BB%8A%E6%97%A5%E7%89%B9%E4%BB%B7%E5%A4%A7%E4%BF%83%E9%94%80%E5%90%84%E7%B1%BB%E5%90%8D...%7C%7C%2Fchongwu%2Fs%2F_%25E4%25BB%258A%25E6%2597%25A5%25E7%2589%25B9%25E4%25BB%25B7%25E5%25A4%25A7%25E4%25BF%2583%25E9%2594%2580%25E5%2590%2584%25E7%25B1%25BB%25E5%2590%258D%25E7%258A%25AC%25E8%2590%25A8%25E6%2591%25A9%2F; vip_version=new; __utmt=1; statistics_clientid=me; lg=1; __utma=32156897.804794746.1427045724.1427045724.1427122310.2; __utmb=32156897.3.10.1427122310; __utmc=32156897; __utmz=32156897.1427045724.1.1.utmcsr=sh.ganji.com|utmccn=(referral)|utmcmd=referral|utmcct=/gou/; ganji_uuid=4762348307934438583103; _gl_tracker=%7B%22ca_source%22%3A%22-%22%2C%22ca_name%22%3A%22-%22%2C%22ca_kw%22%3A%22-%22%2C%22ca_id%22%3A%22-%22%2C%22ca_s%22%3A%22self%22%2C%22ca_n%22%3A%22-%22%2C%22ca_i%22%3A%22-%22%2C%22sid%22%3A82309737884%7D");
		//设置user-Agent
		httpGet.addHeader("User-Agent", USER_AGENT);
//		httpComponent.setProxy("116.66.40.220",8080 );
		PetSaleInfo petSaleInfo=httpComponent.execute(httpGet, petInfoDetailHandler);
		return petSaleInfo;
	}
	@Override
	public List<PetSaleInfo> getPetListInfo(String listurl)
			throws URISyntaxException, IOException {
		httpComponent=new HttpComponent();
		HttpGet httpGet = new HttpGet(listurl);
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		httpGet.addHeader("Cookie", "ganji_xuuid=b6913ed3-78b3-459e-a62c-aad15001574f; friend_tip=1; citydomain=sh; SiftRecord['1427045685']=%E4%BB%8A%E6%97%A5%E7%89%B9%E4%BB%B7%E5%A4%A7%E4%BF%83%E9%94%80%E5%90%84%E7%B1%BB%E5%90%8D...%7C%7C%2Fchongwu%2Fs%2F_%25E4%25BB%258A%25E6%2597%25A5%25E7%2589%25B9%25E4%25BB%25B7%25E5%25A4%25A7%25E4%25BF%2583%25E9%2594%2580%25E5%2590%2584%25E7%25B1%25BB%25E5%2590%258D%25E7%258A%25AC%25E8%2590%25A8%25E6%2591%25A9%2F; vip_version=new; __utmt=1; statistics_clientid=me; lg=1; __utma=32156897.804794746.1427045724.1427045724.1427122310.2; __utmb=32156897.3.10.1427122310; __utmc=32156897; __utmz=32156897.1427045724.1.1.utmcsr=sh.ganji.com|utmccn=(referral)|utmcmd=referral|utmcct=/gou/; ganji_uuid=4762348307934438583103; _gl_tracker=%7B%22ca_source%22%3A%22-%22%2C%22ca_name%22%3A%22-%22%2C%22ca_kw%22%3A%22-%22%2C%22ca_id%22%3A%22-%22%2C%22ca_s%22%3A%22self%22%2C%22ca_n%22%3A%22-%22%2C%22ca_i%22%3A%22-%22%2C%22sid%22%3A82309737884%7D");
		//设置user-Agent
		httpGet.addHeader("User-Agent", USER_AGENT);
		return httpComponent.execute(httpGet, petInfoListHandler);
	}
	public HttpComponent getHttpComponent() {
		return httpComponent;
	}
	public void setHttpComponent(HttpComponent httpComponent) {
		this.httpComponent = httpComponent;
	}

	public PetUtil getPetUtil() {
		return petUtil;
	}
	public void setPetUtil(PetUtil petUtil) {
		this.petUtil = petUtil;
	}
	public static void main(String[] args) throws InterruptedException {
		GanjiPetSpider ganjiPetSpider=new GanjiPetSpider();
		try {
//			for(int i=0;i<1000;i++){
//				Thread.sleep(3000);
//				System.out.println("执行第："+i+"次");
//				productService.testHttp("http://sh.58.com/dog/pn2/");
//			ganjiPetSpider.petDetailHttp("http://tj.ganji.com/gou/1128738672x.htm");
////			ganjiPetSpider.getPetListInfo("http://sh.ganji.com/gou/");
////			}
//			System.out.println("联系我时，请说明是在上海赶集网看到的拉布拉多犬信息，谢谢！".length());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		String temp="http://gz.ganji.comhttp://gz.ganji.com/gou/1486983791x.htm";
		String temp1="http://gz.ganji.com/gou/1486983791x.htm";
		System.out.println(temp.lastIndexOf("http://"));
		System.out.println(temp1.lastIndexOf("http://"));
	}


	@Override
	public PetSaleInfo petDetail(String detailUrl) throws URISyntaxException,
			IOException {
		httpComponent=new HttpComponent();
		HttpGet httpGet = new HttpGet(detailUrl);
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		httpGet.addHeader("Cookie", "ganji_xuuid=b6913ed3-78b3-459e-a62c-aad15001574f; friend_tip=1; citydomain=sh; SiftRecord['1427045685']=%E4%BB%8A%E6%97%A5%E7%89%B9%E4%BB%B7%E5%A4%A7%E4%BF%83%E9%94%80%E5%90%84%E7%B1%BB%E5%90%8D...%7C%7C%2Fchongwu%2Fs%2F_%25E4%25BB%258A%25E6%2597%25A5%25E7%2589%25B9%25E4%25BB%25B7%25E5%25A4%25A7%25E4%25BF%2583%25E9%2594%2580%25E5%2590%2584%25E7%25B1%25BB%25E5%2590%258D%25E7%258A%25AC%25E8%2590%25A8%25E6%2591%25A9%2F; vip_version=new; __utmt=1; statistics_clientid=me; lg=1; __utma=32156897.804794746.1427045724.1427045724.1427122310.2; __utmb=32156897.3.10.1427122310; __utmc=32156897; __utmz=32156897.1427045724.1.1.utmcsr=sh.ganji.com|utmccn=(referral)|utmcmd=referral|utmcct=/gou/; ganji_uuid=4762348307934438583103; _gl_tracker=%7B%22ca_source%22%3A%22-%22%2C%22ca_name%22%3A%22-%22%2C%22ca_kw%22%3A%22-%22%2C%22ca_id%22%3A%22-%22%2C%22ca_s%22%3A%22self%22%2C%22ca_n%22%3A%22-%22%2C%22ca_i%22%3A%22-%22%2C%22sid%22%3A82309737884%7D");
		//设置user-Agent
		httpGet.addHeader("User-Agent", USER_AGENT);
//		httpComponent.setProxy("116.66.40.220",8080 );
		PetSaleInfo petSaleInfo=httpComponent.execute(httpGet, petInfoDetailHandler);
		return petSaleInfo;
	}


	@Override
	public SpiderType[] getSpiderType() {
		 return new SpiderType[] {SpiderType.GANJI};
	}
	
}
