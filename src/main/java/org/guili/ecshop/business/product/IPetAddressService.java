package org.guili.ecshop.business.product;
import java.util.List;
import java.util.Map;
import org.guili.ecshop.bean.chongwu.PetAddress;
public interface IPetAddressService {
	/**
	 * 查询所有宠物类别信息
	 * @return
	 */
	public Map<String, Map<String, PetAddress>> initAddressPetMap();
	public List<PetAddress> selectAllPetAddress();
	public Map<String, Long> selectPetAddressMap();
	
}
