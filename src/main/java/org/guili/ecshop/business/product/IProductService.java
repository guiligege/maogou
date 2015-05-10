package org.guili.ecshop.business.product;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
import org.guili.ecshop.business.impl.product.SpiderType;

/**
 * 商品服务接口
 * @ClassName:   IProductService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-13 下午4:11:27 
 */
public interface IProductService {
	
	
	public SpiderType [] getSpiderType();
	
	public String testHttp(String listurl) throws URISyntaxException, IOException;
	
	/**
	 * 抓取宠物信息列表
	 * @param listurl 宠物信息列表url
	 * 	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public List<PetSaleInfo> getPetListInfo(String listurl) throws URISyntaxException, IOException;
	
	/**
	 * 获取单个宠物信息
	 * @param detailturl
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public PetSaleInfo petDetailHttp(String detailUrl)throws URISyntaxException, IOException;
	
	/**
	 * 抓取并保持信息
	 * @param listurl
	 */
	public void batCrawlPet(String listurl);
	
	
	/**
	 * 根据url获取单个宠物信息
	 * @param detailturl
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public PetSaleInfo petDetail(String detailUrl)throws URISyntaxException, IOException;
	
}
