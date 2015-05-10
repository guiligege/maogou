package org.guili.ecshop.business.impl.product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetAddress;
import org.guili.ecshop.business.product.IPetAddressService;
import org.guili.ecshop.dao.pet.IPetAddressDao;
import org.guili.ecshop.util.chongwu.PetAddressConstants;

public class PetAddressService implements IPetAddressService {

	private  IPetAddressDao PetAddressDao;
	private static Logger logger=Logger.getLogger(PetAddressService.class);

	public IPetAddressDao getPetAddressDao() {
		return PetAddressDao;
	}

	public void setPetAddressDao(IPetAddressDao petAddressDao) {
		PetAddressDao = petAddressDao;
	}

	//地址map
	@Override
	public Map<String, Map<String, PetAddress>> initAddressPetMap() {
		Map<String, Map<String, PetAddress>> map=new HashMap<String, Map<String, PetAddress>>();
		try {
			List<PetAddress> listPetCategory=PetAddressDao.selectAllPetAddress();
			if(!listPetCategory.isEmpty()){
				//循环宠物所有大类别，狗，猫等
				for(PetAddressConstants name :PetAddressConstants.values()){
					Map<String, PetAddress> PetAddressMap=new HashMap<String, PetAddress>();
					for(int i=0;i<listPetCategory.size();i++){
						//如果类别的父类别的常量的父id一致，加入该list
						if(name.getAddressName().equals(listPetCategory.get(i).getCity())){
							PetAddressMap.put(listPetCategory.get(i).getArea(), listPetCategory.get(i));
						}
					}
					if(!PetAddressMap.isEmpty()){
						map.put(name.getAddressName(), PetAddressMap);
					}
				}
			}
			return map;
		} catch (Exception e) {
			logger.error("initCategoryPetMap 获取宠物类型失败："+e.getStackTrace());
			return null;
		}
	}

	@Override
	public List<PetAddress> selectAllPetAddress() {
		List<PetAddress> petAddressList=new ArrayList<PetAddress>();
		for(PetAddressConstants name :PetAddressConstants.values()){
			PetAddress petAddress=new PetAddress();
			petAddress.setCity(name.getAddressName());
			petAddress.setId(name.getId());
			petAddressList.add(petAddress);
		}
		return petAddressList;
	}

	@Override
	public Map<String, Long> selectPetAddressMap() {
		Map<String, Long> cityMap=new HashMap<String, Long>();
		for(PetAddressConstants name :PetAddressConstants.values()){
			cityMap.put(name.getAddressName(), name.getId());
		}
		return cityMap;
	}

	
	
}
