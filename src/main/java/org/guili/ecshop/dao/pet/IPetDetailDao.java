package org.guili.ecshop.dao.pet;
import java.util.List;

import org.guili.ecshop.bean.chongwu.CwPageParam;
import org.guili.ecshop.bean.chongwu.PetSaleInfo;
/**
 * 宠物售卖信息
 * @author guili
 */
public interface IPetDetailDao {
	/**
	 * 添加宠物售卖信息
	 * @param lcProduct
	 * @return
	 * @throws Exception
	 */
	public int addPetSaleInfo(PetSaleInfo petSaleInfo);
	
	/**
	 * 根据Id查询宠物售卖信息
	 * @param pageParam
	 * @return
	 */
	public PetSaleInfo selectPetSaleInfoById(Long id) throws Exception;
	
	/**
	 * 根据title的hash值，查询商品数量
	 * @param Hash
	 * @return
	 */
	public Integer selectPetSaleInfoByHash(Long titlehash);
	
	
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
	public List<PetSaleInfo> selectPetInfoPage(Integer start, Integer pageSize,
			CwPageParam cwPageParam) ;
	
	/**
	 * 查找相关宠物
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<PetSaleInfo> selectLikeThis(Integer size,CwPageParam cwPageParam);
	
	/**
	 * 查找推荐宠物
	 * @param pageSize
	 * @param cwPageParam
	 * @return
	 */
	public List<PetSaleInfo> selectTuijian(Integer size);
}
