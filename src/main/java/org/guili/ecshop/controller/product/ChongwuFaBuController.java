package org.guili.ecshop.controller.product;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.controller.common.BaseProfileController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分享宠物
 * @author Administrator
 *
 */
@Controller
public class ChongwuFaBuController extends BaseProfileController{

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
    	
        return petSaleInfo;  
    }
}
