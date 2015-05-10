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

/**
 * 58同城，宠物抓取
 * @author Administrator
 */
public class WubaPetSpider extends PetSpiderParent{

	private static Logger logger=Logger.getLogger(WubaPetSpider.class);
	private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";
	//http请求组件封装
	private HttpComponent httpComponent;
	//http请求组件封装
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
//            FileTools.write("E:/spiderfile/58testlist.txt", entityStr);
            //解析
            SpiderRegex regex = new SpiderRegex();
            //正则解析宠物资源列表
            String reg = "<table class=\"tbimg\" cellpadding=\"0\" cellspacing=\"0\">(.*?)</table>";
            String[] clcontent = regex.htmlregex(entityStr,reg,true);
            if(clcontent==null || clcontent.length==0){
    			return null;
    		}
            String regcity = ";city=(.*?);";
            String[] citys = regex.htmlregex(entityStr,regcity,true);
            String regtr = "<tr(.*?)</tr>";
            //解析多个单独的宠物资源
            String[] trs;
            if(clcontent.length==2){
            	trs = regex.htmlregex(clcontent[1],regtr,true);
            }else{
            	trs = regex.htmlregex(clcontent[0],regtr,true);
            }
            if(trs==null || trs.length==0){
    			return null;
    		}
            //获取url的所有宠物信息
            List<PetSaleInfo> petSaleInfoList=new ArrayList<PetSaleInfo>();
            for(int i=0;i<trs.length;i++){
            	PetSaleInfo petSaleInfo=new PetSaleInfo();
            	String reg_detailurl = "<td class=\"t\"><a href=\"(.*?)\"";
            	String reg_title = "target=\"_blank\" class=\"t\">(.*?)</a>";
            	String reg_address = "<p class=\"pet-post-detail clearfix\">(.*?)<span>";
            	String[] detailurl = regex.htmlregex(trs[i],reg_detailurl,true);
//            	String[] title = regex.htmlregex(trs[i],reg_title,true);
            	String[] address = regex.htmlregex(trs[i],reg_address,false);
            	if(detailurl==null || detailurl.length==0){
            		continue;
            	}
            	try {
            		logger.info("detail url-->"+detailurl[0]);
            		//跳过风控
					Thread.sleep(2000);
            		//调用单个抓取
            		petSaleInfo=petDetailHttp(detailurl[0]);
				} catch (URISyntaxException e) {
					logger.error("detail url crawal error:"+e.getStackTrace());
				} 
            	catch (InterruptedException e) {
					logger.error("InterruptedException:"+e.getStackTrace());
				}
            	if(petSaleInfo==null){
            		continue;
            	}
            	logger.debug(citys[0]+"--"+detailurl[0]+"--"+address[1]);
            	petSaleInfo.setAdress(address[1].trim());
            	petSaleInfo.setCity(citys[0].trim());
            	petSaleInfo.setpAdressId(petUtil.getPetPAddressId(citys[0].trim()));
            	if(petUtil.getPetAddressId(citys[0].trim(), address[1].trim())==0){
            		petSaleInfo.setAdressId(petUtil.getPetPAddressId(citys[0].trim()));
            	}else{
            		petSaleInfo.setAdressId(petUtil.getPetAddressId(citys[0].trim(), address[1].trim()));
            	}
            	petSaleInfoList.add(petSaleInfo);
            }
            return petSaleInfoList;
        }
    }
	
	//58detail
	private class PetInfoDetailHandler extends AbstractResponseHandler<PetSaleInfo> {
        @Override
        public PetSaleInfo handle(HttpEntity entity) throws IOException {
            String entityStr = EntityUtils.toString(entity);

            if (StringUtils.isBlank(entityStr)) {
                throw new RemoteServiceException();
            }
//            FileTools.write("E:/spiderfile/58testdetail.txt", entityStr);
            //解析
            SpiderRegex regex = new SpiderRegex();
            String reg = "<div class=\"gallery\">(.*?)<li class=\"baozhang_t\">";
    		String[] clcontent = regex.htmlregex(entityStr,reg,true);
    		if(clcontent==null || clcontent.length==0){
    			return null;
    		}
    		//对各个信息的正则解析
    		String regtitle = "alt=\"(.*?)\"";
    		String regimgs = "img src=\"(.*?)\"/>";
    		String regprice = "price c_f50\">(.*?)</";
    		String regcategory = "<div class=\"su_con\"><span>(.*?)</span>";
    		String regqq = "\"<img src='(.*?)'";
    		String regmaijia = "<p class=\"c_666\">(.*?)<span class=\"datu-xb\">";
    		String regdetail  = "<article class=\"description_con\">(.*?)</article>";
    		String regBigimg="<div class=\"descriptionImg\" id=\"sub_2\">(.*?)</div>";
    		String regBigimgs="src=(.*?) />";
    		
    		String[] titles = regex.htmlregex(clcontent[0],regtitle,true);
    		String[] images = regex.htmlregex(clcontent[0],regimgs,true);
    		String price = regex.htmlregex(clcontent[0],regprice,true)[0];
    		String category = regex.htmlregex(clcontent[0],regcategory,true)[0];
    		String[] qqs = regex.htmlregex(entityStr,regqq,true);
    		String maijia = regex.htmlregex(entityStr,regmaijia,true)[0];
    		String detail  = regex.htmlregex(entityStr,regdetail,true)[0];
    		String reg1 = "<ul class=\"ulDec clearfix\">(.*?)</ul>";
    		String[] clcontent1 = regex.htmlregex(entityStr,reg1,true);
    		String regmiaoshu = "<span class=\"it_r\">(.*?)</span>";
    		String[] miaoshu = regex.htmlregex(clcontent1[0],regmiaoshu,true);
    		String[] bigImagestext = regex.htmlregex(entityStr,regBigimg,true);
    		String[] bigImages = regex.htmlregex(bigImagestext[0],regBigimgs,true);
    		
    		String age=miaoshu[0];
    		String yimiao=miaoshu[1];
    		String sex=miaoshu[4];
    		logger.debug("title:"+titles[0]);
    		logger.debug(images[0]);
    		logger.debug(images[1]);
    		logger.debug(images[2]);
    		logger.debug(images[3]);
    		logger.debug(price);
    		logger.debug(category);
    		if(qqs!=null && qqs.length==2){
    			logger.debug("tel:"+qqs[1]);
    			logger.debug("qq:"+qqs[0]);
    		}
    		logger.debug(maijia);
    		logger.debug("----------------");
    		logger.debug("detail:"+detail);
    		logger.debug("----------------");
    		logger.debug("age:"+age);
    		logger.debug("yimiao:"+yimiao);
    		logger.debug("sex:"+sex);
    		//构造返回对象
    		PetSaleInfo petSaleInfo=new PetSaleInfo();
    		petSaleInfo.setTitle(titles[0].trim());
    		petSaleInfo.setTitlehash(new Long(titles[0].hashCode()));
    		//设置统一宠物狗类别
    		category=convertCategory(category.trim());
    		petSaleInfo.setCategory(category.trim());
    		//设置宠物类别
    		petSaleInfo.setCategoryId(petUtil.getPetCategory(category));
    		petSaleInfo.setImageDetail1(images[0].trim());
    		//大图
    		if(bigImages!=null && bigImages.length>0){
    			if(bigImages.length>=3){
    				petSaleInfo.setImageDetail2(bigImages[0].trim());
            		petSaleInfo.setImageDetail3(bigImages[1].trim());
            		petSaleInfo.setImageDetail4(bigImages[2].trim());
    			}else if(bigImages.length==2){
    				petSaleInfo.setImageDetail2(bigImages[0].trim());
            		petSaleInfo.setImageDetail3(bigImages[1].trim());
    			}else{
    				petSaleInfo.setImageDetail2(bigImages[0].trim());
    			}
    		}
    		petSaleInfo.setPrice(Integer.parseInt(price.trim()));
    		if(qqs!=null && qqs.length==2){
    			petSaleInfo.setQq(qqs[0].trim());
        		petSaleInfo.setTelephone(qqs[1].trim());
    		}
    		if(maijia!=null ){
    			petSaleInfo.setNickName(maijia.replace("卖家：", "").trim());
    		}
    		//防止描述结尾带标签
    		String descrip=getDescription(detail);
    		petSaleInfo.setDescrip(descrip);
    		
    		petSaleInfo.setAge(age.trim());
    		petSaleInfo.setYimiao(yimiao.trim());
    		petSaleInfo.setSex(sex.trim());
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
		HttpGet httpGet = new HttpGet(detailUrl);
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
		//设置user-Agent
		httpGet.addHeader("User-Agent", USER_AGENT);
		PetSaleInfo petSaleInfo=httpComponent.execute(httpGet, petInfoDetailHandler);
		return petSaleInfo;
	}
	@Override
	public List<PetSaleInfo> getPetListInfo(String listurl)
			throws URISyntaxException, IOException {
		HttpGet httpGet = new HttpGet(listurl);
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
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
	
	/**
	 * 58转换类别方法
	 * @param category
	 * @return
	 */
	private static String  convertCategory(String category){
		if(category==null ||category.isEmpty()){
			return "";
		}
		//58类别兼容
		if(category.trim().equals("萨摩耶")){
			return "萨摩耶犬";
		}
		if(category.trim().equals("泰迪熊")){
			return "泰迪犬";
		}
		if(category.trim().equals("贵宾")){
			return "贵宾犬";
		}
		if(category.trim().equals("比熊")){
			return "比熊犬";
		}
		if(category.trim().equals("约克夏")){
			return "约克夏犬";
		}
		if(category.trim().equals("巴哥")){
			return "巴哥犬";
		}
		if(category.trim().equals("可卡")){
			return "可卡犬";
		}
		if(category.trim().equals("腊肠")){
			return "腊肠犬";
		}
		if(category.trim().equals("比熊")){
			return "比熊犬";
		}
		if(category.trim().equals("马尔济斯犬")){
			return "马尔济斯";
		}
		if(category.trim().equals("杜宾犬")){
			return "杜宾";
		}
		if(category.trim().equals("松狮")){
			return "松狮犬";
		}
		if(category.trim().equals("金毛")){
			return "金毛犬";
		}
		if(category.trim().equals("拉布拉多")){
			return "拉布拉多犬";
		}
		if(category.trim().equals("杜高犬")){
			return "杜高";
		}
		if(category.trim().equals("阿拉斯加")){
			return "阿拉斯加雪橇犬";
		}
		if(category.trim().equals("比特犬")){
			return "比特";
		}
		if(category.trim().equals("冠毛")){
			return "冠毛犬";
		}
		return category;
	}

	@Override
	public PetSaleInfo petDetail(String detailUrl) throws URISyntaxException,
			IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderType[] getSpiderType() {
		return new SpiderType[] {SpiderType.WUBA};
	}
	
}
