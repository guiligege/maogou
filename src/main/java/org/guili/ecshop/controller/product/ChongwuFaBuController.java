package org.guili.ecshop.controller.product;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.business.impl.product.SpiderType;
import org.guili.ecshop.business.impl.product.Spiders;
import org.guili.ecshop.controller.common.BaseProfileController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 分享宠物
 * @author Administrator
 *
 */
@Controller
public class ChongwuFaBuController extends BaseProfileController{
	
	private static final String GANJI_SITE="ganji.com";
	private static final String WUBA_SITE="58.com";
	/**
	 * 分享宠物
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value={"/chongwu/to_share.htm"},method={RequestMethod. GET})
	public String to_share(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		//宠物分享页面
		return "chongwu/chongwu_share";
	}
	
	
	/**
     * 功能描述：文件上传
     * @author 作者 zhengdong.xiao@vip.com
     * @throw 异常描述
     * @see 需要参见的其它内容
     */
    @RequestMapping(value = { "/chongwu/ajaxshare.htm"})
    @ResponseBody
    public PetSaleInfo ajaxshare(HttpServletResponse response,HttpServletRequest request,
                                    @RequestParam(value="shareUrl", required=false) String  shareUrl
                                    ) throws IOException{
    	
    	PetSaleInfo petSaleInfo=new PetSaleInfo();
    	//空判定
    	if(shareUrl==null ||shareUrl.isEmpty()){
			return petSaleInfo;
		}
    	//验证url
		if(!isValidateURL(shareUrl)){
			return petSaleInfo;
		}
		if(getSpiderType(shareUrl)==null){
			return petSaleInfo;
		}
    	//执行指定的spider
		try {
			petSaleInfo=Spiders.getHandler(getSpiderType(shareUrl)).petDetail(shareUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println(JSON.toJSON(petSaleInfo));
        return petSaleInfo;  
    }
    
    /**
     * 验证url是否可用
     * @param shareUrl
     * @return
     */
    private boolean isValidateURL(String  shareUrl){
    	if(!shareUrl.contains(WUBA_SITE) && !shareUrl.contains(GANJI_SITE)){
			return false;
    	}
    	if(!shareUrl.endsWith("x.htm") && !shareUrl.contains("x.shtml")){
			return false;
    	}
    	return true;
    }
    
    /**
     * 获取网站类型
     * @param shareUrl
     * @return
     */
    private SpiderType getSpiderType(String  shareUrl){
    	if(shareUrl.contains(WUBA_SITE)){
    		return SpiderType.WUBA;
    	}else if(shareUrl.contains(GANJI_SITE)){
    		return SpiderType.GANJI;
    	}
    	else{
    		return null;
    	}
    }
}
