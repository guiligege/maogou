package org.guili.ecshop.dao.pet;
import java.util.List;
import org.guili.ecshop.bean.chongwu.PetAddress;

/**
 * 宠物类别信息
 * @author guili
 */
public interface IPetAddressDao {
	
	/**
	 * 根据Id查询宠物售卖信息
	 * @param pageParam
	 * @return
	 */
	public List<PetAddress> selectAllPetAddress() throws Exception;
	
}
