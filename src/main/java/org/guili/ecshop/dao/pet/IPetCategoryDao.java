package org.guili.ecshop.dao.pet;
import java.util.List;
import org.guili.ecshop.bean.chongwu.PetCategory;

/**
 * 宠物类别信息
 * @author guili
 */
public interface IPetCategoryDao {
	
	/**
	 * 根据Id查询宠物售卖信息
	 * @param pageParam
	 * @return
	 */
	public List<PetCategory> selectAllPetCategory() throws Exception;
	
}
