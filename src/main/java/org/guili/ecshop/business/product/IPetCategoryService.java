package org.guili.ecshop.business.product;
import java.util.List;
import java.util.Map;

import org.guili.ecshop.bean.chongwu.PetCategory;
public interface IPetCategoryService {
	/**
	 * 查询所有宠物类别信息
	 * @return
	 */
//	public List<PetCategory> selectAllPetCategory();
	public   Map<String, List<PetCategory>> initCategoryPetMap();
	public   Map<String, Long> selectAllPetCategory();
	
}
