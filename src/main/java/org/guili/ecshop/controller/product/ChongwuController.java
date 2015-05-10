package org.guili.ecshop.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.guili.ecshop.bean.ResultBean;
import org.guili.ecshop.bean.chongwu.CwPageParam;
import org.guili.ecshop.bean.chongwu.PetAddress;
import org.guili.ecshop.bean.chongwu.PetCategory;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.bean.chongwu.SeoInfo;
import org.guili.ecshop.bean.chongwu.Status;
import org.guili.ecshop.business.product.IPetAddressService;
import org.guili.ecshop.business.product.IPetCategoryService;
import org.guili.ecshop.business.product.IPetDetailService;
import org.guili.ecshop.business.product.IProductService;
import org.guili.ecshop.controller.common.BaseProfileController;
import org.guili.ecshop.util.chongwu.RandomUtil;
import org.guili.ecshop.util.chongwu.ResourceUtils;
import org.guili.ecshop.util.common.UrlHelper;
import org.guili.ecshop.util.common.page.Pager;
import org.guili.ecshop.util.common.page.PagerHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 控制宠物信息展示
 * @author Administrator
 *
 */
@Controller
public class ChongwuController extends BaseProfileController {
	
	@Resource(name="petDetailService")
	private IPetDetailService petDetailService;
	@Resource(name="petCategoryService")
	private IPetCategoryService petCategoryService;
	@Resource(name="petAddressService")
	private IPetAddressService petAddressService;
	//58抓取类
	@Resource(name="wubaPetSpider")
	private IProductService wubaPetSpider;
	//赶集抓取类
	@Resource(name="ganjiPetSpider")
	private IProductService ganjiPetSpider;
	private static final int pagesize=15;
	private static final int RELATION_SIZE=6;
	private static final int TUIJIAN_SIZE=12;
	//上传文件主目录
    private  String UPLOAD_FOLDER=ResourceUtils.getFolderPath();
    private static final String SEP="/";
    
    private static final String title="宠物狗图片| 宠物狗价格|宠物分享网站- 猫狗网";
    private static final String keywords="宠物狗,宠物狗价格,宠物狗图片,宠物狗分享,猫狗网";
    private static final String description="猫狗网是一个宠物分享平台，是一个中立的，致力于帮助广大网友找到最适合自己的宠物，分享自己的宠物，每天为网友们提供来自互联网的宠物信息，保证数据的真实有效性。猫狗网信息大部分来自网友的分享，您也可以分享自己的萌宠照片，分享养宠经验。";
	//测试宠物抓取
	@RequestMapping(value={ "/petadd_ganji.htm"},method={RequestMethod. GET})
	public String testyinhang(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
							@RequestParam(value = "urlStr", required = false) String urlStr) throws Exception{
		if(urlStr==null ||urlStr.isEmpty()){
			return "redirect:/errors/404.htm";
		}
		if(!urlStr.contains("ganji.com")){
			return "redirect:/errors/404.htm";
		}
		String url="";
		if(urlStr.startsWith("http://")){
			url=urlStr;
		}else{
			url="http://"+urlStr;
		}
//		wubaPetSpider.batCrawlPet(url);
		ganjiPetSpider.batCrawlPet(url);
		return "redirect:/chongwu/fabu_success.htm";
	}
	//测试宠物抓取
	@RequestMapping(value={ "/petadd_58.htm"},method={RequestMethod. GET})
	public String test58(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
							@RequestParam(value = "urlStr", required = false) String urlStr) throws Exception{
		if(urlStr==null ||urlStr.isEmpty()){
			return "redirect:/errors/404.htm";
		}
		if(!urlStr.contains("58.com")){
			return "redirect:/errors/404.htm";
		}
		String url="";
		if(urlStr.startsWith("http://")){
			url=urlStr;
		}else{
			url="http://"+urlStr;
		}
		wubaPetSpider.batCrawlPet(url);
//		ganjiPetSpider.batCrawlPet(url);
		return "redirect:/chongwu/fabu_success.htm";
	}
	
	//测试宠物抓取
		@RequestMapping(value={ "/petadd.htm"},method={RequestMethod. GET})
		public String petadd(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
								@RequestParam(value = "geturl", required = false) String geturl) throws Exception{
			if(geturl==null ||geturl.isEmpty()){
				return "redirect:/errors/404.htm";
			}
			if(!geturl.contains("ganji.com")&&  !geturl.contains("58.com")){
				return "redirect:/errors/404.htm";
			}
			String url="";
			if(geturl.startsWith("http://")){
				url=geturl;
			}else{
				url="http://"+geturl;
			}
			if(geturl.contains("ganji.com")){
				ganjiPetSpider.batCrawlPet(url);
			}else if(geturl.contains("58.com")){
				wubaPetSpider.batCrawlPet(url);
			}
			return "redirect:/chongwu/fabu_success.htm";
		}
	
	@RequestMapping(value={ "/petaddtest.htm"},method={RequestMethod. GET})
	public void test(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		String url="http://sh.58.com/dog/pn2/";
		System.out.println(url);
		wubaPetSpider.batCrawlPet(url);
		return ;
	}
	/**
	 * 理财产品首页
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/dog.htm"},method={RequestMethod. GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam(value = "adressId", required = false) Long adressId,
			@RequestParam(value = "pAdressId", required = false) Long pAdressId,
			@RequestParam(value = "categoryId", required = false) Long categoryId,
			@RequestParam(value = "status", required = false) Integer status,
			@RequestParam(value = "pageNum", required = false) Integer pageNum
			) throws Exception{
		List<PetSaleInfo> goodProductList=new ArrayList<PetSaleInfo>();
		CwPageParam cwPageParam=new CwPageParam();
		//用于回显的url部分
		String urlParam=this.setParams(adressId,pAdressId,categoryId, status,cwPageParam);
		int totalRow = petDetailService.selectPetInfoCount(cwPageParam);
		Pager pager=null;
		String basePath=UrlHelper.getRealPath(request); 			  //基础绝对路径
		if(pageNum!=null){
			pager = PagerHelper.getPager(pageNum, totalRow,pagesize); //初始化分页对象  
		}else{
			pager = PagerHelper.getPager(1, totalRow,pagesize); 	  //初始化分页对象  
		}
		pager.setLinkUrl(basePath+request.getRequestURI()); 		  //设置跳转路径  
		request.setAttribute("pager", pager); 						  //将分页信息保存在Request对象  
		//分页参数
		request.setAttribute("urlParam", urlParam);
		goodProductList=petDetailService.selectPetInfoPage(pager.getStartRow(), pager.getPageSize(), cwPageParam);
		
//		List<LcProductYinHang> lcProductYinHangList=lcProductLogService.selectLcProductYinHang();
		//分类信息
		Map<String, List<PetCategory>> categoryPetMap=petCategoryService.initCategoryPetMap();
		
		Map<String, Map<String, PetAddress>> addressPetMap=petAddressService.initAddressPetMap();
		List<PetAddress> petAddressList=petAddressService.selectAllPetAddress();
		//商品列表信息回显
		request.setAttribute("bList", goodProductList);
		//宠物狗分类信息
//		request.setAttribute("lcProductYinHangList", lcProductYinHangList);
//		List<PetSaleInfo>  relationPets=petDetailService.selectLikeThis(RELATION_SIZE*2, cwPageParam);
		List<PetSaleInfo>  tuijianPets=petDetailService.selectTuijian(TUIJIAN_SIZE);
		request.setAttribute("relationPets", tuijianPets);
		//回传seoinfo
		request.setAttribute("seoInfo", this.setSeoInfo((goodProductList==null || goodProductList.size()==0)?null :goodProductList.get(0),adressId, pAdressId));
		request.setAttribute("categoryPetMap", categoryPetMap);
		request.setAttribute("petAddressList", petAddressList);
		request.setAttribute("pageParam", cwPageParam);
		request.setAttribute("menu", "dog");
		return "chongwu/petinfo_list";
	}
	
	//设置seo信息
	private SeoInfo setSeoInfo(PetSaleInfo petSaleInfo,Long adressId,Long pAdressId){
		SeoInfo seoInfo=new SeoInfo(title,keywords,description);
		//如果为null
		if(petSaleInfo==null){
			return seoInfo;
		}
		//如果有类别
		if(StringUtils.isNotEmpty(petSaleInfo.getCategory()) && pAdressId==null){
			seoInfo.setTitle(petSaleInfo.getCategory()+"|"+petSaleInfo.getCategory()+"图片|"+petSaleInfo.getCategory()+"价格|"+petSaleInfo.getCategory()+"分享网站-猫狗网");
			seoInfo.setDescription(petSaleInfo.getCategory()+"图片、"+petSaleInfo.getCategory()+"价格频道为网民提供最新"+petSaleInfo.getCategory()+"图片、"+petSaleInfo.getCategory()+"价格信息,在这里我们每天为网友们提供"+petSaleInfo.getCategory()+"价格，"+petSaleInfo.getCategory()+"图片信息。您也可以分享自己的"+petSaleInfo.getCategory()+"照片，分享饲养"+petSaleInfo.getCategory()+"经验。");
			seoInfo.setKeywords(petSaleInfo.getCategory()+","+petSaleInfo.getCategory()+"价格,"+petSaleInfo.getCategory()+"图片,"+petSaleInfo.getCategory()+"分享");
		}
		//地区
		if(StringUtils.isNotEmpty(petSaleInfo.getCity()) && pAdressId!=null){
			seoInfo.setTitle(petSaleInfo.getCity()+"宠物狗图片|"+petSaleInfo.getCity()+" 宠物狗价格|"+petSaleInfo.getCity()+"宠物分享网站- 猫狗网");
			seoInfo.setDescription(petSaleInfo.getCity()+"宠物狗图片、"+petSaleInfo.getCity()+"宠物狗价格频道为网民提供最新"+petSaleInfo.getCity()+"宠物狗图片、"+petSaleInfo.getCity()+"宠物狗价格信息,在这里我们每天为网友们提供"+petSaleInfo.getCity()+"宠物狗价格，"+petSaleInfo.getCity()+"宠物狗图片信息。您也可以分享自己的宠物狗照片，宠物狗分享。");
			seoInfo.setKeywords(petSaleInfo.getCity()+"宠物狗,"+petSaleInfo.getCity()+"宠物狗价格,"+petSaleInfo.getCity()+"宠物狗图片,"+petSaleInfo.getCity()+"宠物狗分享");
		}
		//市和类
		if(StringUtils.isNotEmpty(petSaleInfo.getCity()) && StringUtils.isNotEmpty(petSaleInfo.getCategory()) && pAdressId!=null && adressId==null){
			seoInfo.setTitle(petSaleInfo.getCity()+petSaleInfo.getCategory()+"图片|"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"价格|"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"分享网站- 猫狗网");
			seoInfo.setDescription(petSaleInfo.getCity()+petSaleInfo.getCategory()+"图片、"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"价格频道为网民提供最新"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"图片、"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"价格信息,在这里我们每天为网友们提供"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"价格，"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"图片信息。您也可以分享自己的"+petSaleInfo.getCategory()+"照片，"+petSaleInfo.getCategory()+"分享");
			seoInfo.setKeywords(petSaleInfo.getCity()+petSaleInfo.getCategory()+","+petSaleInfo.getCity()+petSaleInfo.getCategory()+"价格,"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"图片,"+petSaleInfo.getCity()+petSaleInfo.getCategory()+"分享");
		}
		//区和类
		if(StringUtils.isNotEmpty(petSaleInfo.getAdress()) && StringUtils.isNotEmpty(petSaleInfo.getCategory()) && adressId!=null){
			String address=getAddress(petSaleInfo.getAdress());
			seoInfo.setTitle(address+petSaleInfo.getCategory()+"图片|"+address+petSaleInfo.getCategory()+"价格|"+address+petSaleInfo.getCategory()+"分享网站- 猫狗网");
			seoInfo.setDescription(address+petSaleInfo.getCategory()+"图片、"+address+petSaleInfo.getCategory()+"价格频道为网民提供最新"+address+petSaleInfo.getCategory()+"图片、"+address+petSaleInfo.getCategory()+"价格信息,在这里我们每天为网友们提供"+address+petSaleInfo.getCategory()+"价格，"+address+petSaleInfo.getCategory()+"图片信息。您也可以分享自己的"+petSaleInfo.getCategory()+"照片，"+petSaleInfo.getCategory()+"分享");
			seoInfo.setKeywords(address+petSaleInfo.getCategory()+","+address+petSaleInfo.getCategory()+"价格,"+address+petSaleInfo.getCategory()+"图片,"+address+petSaleInfo.getCategory()+"分享");
		}
		//其他特殊处理
		return seoInfo;
	}
	
	public  String getAddress(String preAdress){
		if(preAdress.contains("区")){
			preAdress=preAdress.replace("区", "");
			return preAdress;
		}
		if(preAdress.contains("市")){
			preAdress=preAdress.replace("市", "");
			return preAdress;
		}
		if(preAdress.contains("县")){
			preAdress=preAdress.replace("县", "");
			return preAdress;
		}
		return preAdress;
	}
	
	//设置回显参数
	private String setParams(Long adressId,Long pAdressId,Long categoryId,Integer status,CwPageParam cwPageParam){
		StringBuffer urlParam=new StringBuffer();
		urlParam.append("dog-");
		//构造二级地址
		if(adressId!=null){
			urlParam.append(adressId+"-");
			cwPageParam.setAdressId(adressId);
		}else{
			urlParam.append("-");
		}
		//构造一级地址
		if(pAdressId!=null){
			urlParam.append(pAdressId+"-");
			cwPageParam.setpAdressId(pAdressId);
		}else{
			urlParam.append("-");
		}
		//构造类别id
		if(categoryId!=null){
			urlParam.append(categoryId+"-");
			cwPageParam.setCategoryId(categoryId);
		}else{
			urlParam.append("-");
		}
		//构造不同业务
		if(status!=null){
			urlParam.append(status+"-");
			cwPageParam.setStatus(status);
		}else{
			urlParam.append("-");
		}
        return urlParam.toString();
	}
	
	@RequestMapping(value={"/chongwu/detail.htm"},method={RequestMethod. GET})
	public String detail(HttpServletRequest request,HttpServletResponse response,
					ModelMap modelMap,@RequestParam(value = "id", required = false) Long id 
					) throws Exception{
		//宠物详细信息
		PetSaleInfo petSaleInfo=petDetailService.selectPetSaleInfoById(id);
		//相关宠物
		if(petSaleInfo==null){
			request.setAttribute("petSaleInfo", petSaleInfo);
			return "redirect:/errors/404.htm";
		}
		CwPageParam cwPageParam=new CwPageParam();
		cwPageParam.setAdressId(petSaleInfo.getAdressId());
		cwPageParam.setCategoryId(petSaleInfo.getCategoryId());
		cwPageParam.setpAdressId(petSaleInfo.getpAdressId());
//		cwPageParam.setStatus(status)
		List<PetSaleInfo>  relationPets=petDetailService.selectLikeThis(RELATION_SIZE, cwPageParam);
		request.setAttribute("relationPets", relationPets);
		request.setAttribute("petSaleInfo", petSaleInfo);
		return "chongwu/petinfo_detail";
	}
	
	/**
	 * 发布消息
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value={"/chongwu/tofabu.htm"},method={RequestMethod. GET})
	public String tofabu(HttpServletRequest request,HttpServletResponse response,
					ModelMap modelMap,@RequestParam(value = "id", required = false) Long id 
					) throws Exception{
		
		request.setAttribute("folder", RandomUtil.getUUID());
		//宠物详细信息
		return "chongwu/chongwu_fabu";
	}
	/**
	 * 发布成功消息
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value={"/chongwu/fabu_success.htm"},method={RequestMethod. GET})
	public String fabu_success(HttpServletRequest request,HttpServletResponse response,
					ModelMap modelMap,@RequestParam(value = "id", required = false) Long id 
					) throws Exception{
		//宠物详细信息
		return "chongwu/fabu_success";
	}
	
	/**
	 * 发布成功消息
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value={ "/index.htm", "/" })
	public String home(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//宠物详细信息
		return "chongwu/chongwu_home";
	}
	
	 /**
     * 功能描述：文件上传
     * @author 作者 zhengdong.xiao@vip.com
     * @throw 异常描述
     * @see 需要参见的其它内容
     */
    @RequestMapping(value = { "/chongwu/upload"})
    @ResponseBody
    public Boolean uploadFile(HttpServletResponse response,HttpServletRequest request,
                                    @RequestParam(value="file", required=false) MultipartFile file,
                                    @RequestParam(value="folder", required=false) String folder) throws IOException{  
        byte[] bytes = file.getBytes();
      //检查文件
        if (StringUtils.isBlank(folder)) {
        }
        //文件内容为空
        if (file.isEmpty()) {
            response.setStatus(701);
            return false;
        }
        //上传文件
        //创建文件夹
        String uploadDir = UPLOAD_FOLDER+folder; 
        File upload_dirPath = new File(UPLOAD_FOLDER);  
        if (!upload_dirPath.exists()) {  
            upload_dirPath.mkdirs();  
        }
        File dirPath = new File(uploadDir);  
        if (!dirPath.exists()) {
            dirPath.mkdirs();  
        }
        System.out.println(uploadDir +SEP+file.getOriginalFilename());
        File uploadedFile = new File(uploadDir +SEP+file.getOriginalFilename());  
        FileCopyUtils.copy(bytes, uploadedFile);  
        return true;  
    }
    
    /**
	 * 发布消息
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value={"/chongwu/fabu.htm"},method={RequestMethod.POST})
	@ResponseBody
	public ResultBean fabu(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
											@RequestParam(value = "title", required = false) String title,
											@RequestParam(value = "nickName", required = false) String nickName,
											@RequestParam(value = "qq", required = false) String qq,
											@RequestParam(value = "telephone", required = false) String telephone,
											@RequestParam(value = "city", required = false) String city,
											@RequestParam(value = "address", required = false) String address,
											@RequestParam(value = "age", required = false) String age,
											@RequestParam(value = "yimiao", required = false) String yimiao,
											@RequestParam(value = "category", required = false) String category,
											@RequestParam(value = "price", required = false) int price,
											@RequestParam(value = "sex", required = false) String sex,
											@RequestParam(value = "descrip", required = false) String descrip,
											@RequestParam(value = "imageDetail", required = false) String imageDetail
																) throws Exception{
		//宠物详细信息
		PetSaleInfo petSaleInfo=new PetSaleInfo();
		petSaleInfo.setTitle(title);
		//设置hash值，防止重复标题
		petSaleInfo.setTitlehash(new Long(title.hashCode()));
		petSaleInfo.setAge(age);
		petSaleInfo.setCreateTime(new Date());
		petSaleInfo.setDescrip(descrip);
		petSaleInfo.setNickName(nickName);
		petSaleInfo.setPrice(price);
		petSaleInfo.setQq(qq);
		petSaleInfo.setSex(sex);
		petSaleInfo.setTelephone(telephone);
		petSaleInfo.setYimiao(yimiao);
		//类别
		if(StringUtils.isNotEmpty(category)){
			String[] categorys=category.split(",");
			if(categorys.length==2){
				petSaleInfo.setCategoryId(Long.parseLong(categorys[0]));
				petSaleInfo.setCategory(categorys[1]);
			}
		}
		//city
		if(StringUtils.isNotEmpty(city)){
			String[] citys=city.split(",");
			if(citys.length==2){
				petSaleInfo.setpAdressId(Long.parseLong(citys[0]));
				petSaleInfo.setCity(citys[1]);
			}
		}
		//地址
		if(StringUtils.isNotEmpty(address)){
			String[] addresss=address.split(",");
			if(addresss.length==2){
				petSaleInfo.setAdressId(Long.parseLong(addresss[0]));
				petSaleInfo.setAdress(addresss[1]);
			}
		}
		//宠物图片
		if(StringUtils.isNotEmpty(imageDetail)){
			String[] imageDetails=imageDetail.split(",");
			if(imageDetails.length==1){
				petSaleInfo.setImageDetail1(imageDetails[0]);
			}
			if(imageDetails.length==2){
				petSaleInfo.setImageDetail1(imageDetails[0]);
				petSaleInfo.setImageDetail2(imageDetails[1]);
			}
			if(imageDetails.length==3){
				petSaleInfo.setImageDetail1(imageDetails[0]);
				petSaleInfo.setImageDetail2(imageDetails[1]);
				petSaleInfo.setImageDetail3(imageDetails[2]);
			}
			if(imageDetails.length==4){
				petSaleInfo.setImageDetail1(imageDetails[0]);
				petSaleInfo.setImageDetail2(imageDetails[1]);
				petSaleInfo.setImageDetail3(imageDetails[2]);
				petSaleInfo.setImageDetail4(imageDetails[3]);
			}
		}
		//设置宠物状态
		petSaleInfo.setStatus(Status.STATUS_PERSON);
		int resultflag=petDetailService.addPetSaleInfo(petSaleInfo);
		//关联人与宠物
		ResultBean result=new ResultBean();
		if(resultflag<0){
			result.setCode(1000);
			result.setMsg("添加失败，验证数据错误！");
		}
		//return "chongwu/chongwu_fabu";
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
		ChongwuController chongwuController=new ChongwuController();
		System.out.println(chongwuController.getAddress("阜阳市"));
		System.out.println(chongwuController.getAddress("永川区"));
		System.out.println(chongwuController.getAddress("璧山县"));
		PetSaleInfo petSaleInfo=new PetSaleInfo();
		Long adressId=null;
//		chongwuController.setSeoInfo(petSaleInfo, adressId);
//		petSaleInfo.setCategory("哈士奇");
//		chongwuController.setSeoInfo(petSaleInfo, adressId);
//		petSaleInfo.setCity("北京");
//		chongwuController.setSeoInfo(petSaleInfo, adressId);
//		petSaleInfo.setAdressId(24L);
//		petSaleInfo.setAdress("昌平区");
//		adressId=24L;
//		chongwuController.setSeoInfo(petSaleInfo, adressId);
	}

}
