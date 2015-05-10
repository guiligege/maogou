package org.guili.ecshop.business.product;

import java.util.List;

import org.guili.ecshop.bean.chongwu.CwPageParam;
import org.guili.ecshop.bean.chongwu.PetCategory;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;

public interface IPetDetailService {

	/**
	 * 新增宠物售卖信息
	 * @param petSaleInfo
	 * @return
	 */
	public int addPetSaleInfo(PetSaleInfo petSaleInfo);
	
	/**
	 * 根据信息id查询售卖信息
	 * @param id
	 * @return
	 */
	public PetSaleInfo selectPetSaleInfoById(Long id);
	
	/**
	 * 批量新增宠物售卖信息
	 * @param petSaleInfo
	 * @return
	 */
	public void savePetSaleInfoList(List<PetSaleInfo> petSaleInfoList);
	
	/**
	 * 根据titlehash查询是否重复
	 * @param Hash
	 * @return
	 */
	public Integer selectPetSaleInfoByHash(Long Hash);
	
	/**
	 * 根据条件，查询宠物信息总数
	 * @param cwPageParam
	 * @return
	 */
	public Integer selectPetInfoCount(CwPageParam cwPageParam);
	
	/**
	 * 分页查询宠物信息
	 * @param start
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<PetSaleInfo> selectPetInfoPage(int start,int pageSize,CwPageParam cwPageParam);
	
	/**
	 * 查找相关宠物
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<PetSaleInfo> selectLikeThis(Integer size,
			CwPageParam cwPageParam);
	
	
	/**
	 * 查找推荐宠物
	 * @param size
	 * @return
	 */
	public List<PetSaleInfo> selectTuijian(Integer size);
}
