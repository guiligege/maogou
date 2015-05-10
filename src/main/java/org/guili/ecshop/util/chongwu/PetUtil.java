package org.guili.ecshop.util.chongwu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.guili.ecshop.bean.chongwu.PetAddress;
import org.guili.ecshop.business.product.IPetAddressService;
import org.guili.ecshop.business.product.IPetCategoryService;

/**
 * 宠物工具类，用户各种公共信息设置
 * @author Administrator
 *
 */
public class PetUtil {
	private IPetCategoryService petCategoryService;
	private IPetAddressService petAddressService;
	//地址map
	    private static Map<String, Map<String, PetAddress>> petAddressMap=new HashMap<String, Map<String,PetAddress>>();
	    private static Map<String, Long> petCategoryMap=new HashMap<String, Long>();
	    private static Map<String, Long> petCityMap=new HashMap<String, Long>();
	    //设置宠物类别
		public  Long getPetCategory(String category){
			if( petCategoryMap.isEmpty()){
				petCategoryMap=petCategoryService.selectAllPetCategory();
			}
			if( petCategoryMap.isEmpty()){
				return 0L;
			}
			if(petCategoryMap.get(category)!=null){
				return petCategoryMap.get(category);
			}
			return 0L;
		}
		//设置宠物一级地址
				public  Long getPetPAddressId(String city){
					if(petCityMap.isEmpty()){
						petCityMap=petAddressService.selectPetAddressMap();
					}
					if(petCityMap.get(city)!=null){
						return petCityMap.get(city);
					}
					return 0L;
				}
		//设置宠物二级地址
		public  Long getPetAddressId(String city,String Address){
			if(petAddressMap.isEmpty()){
				petAddressMap=petAddressService.initAddressPetMap();
			}
			if(petAddressMap.get(city)==null){
				return 0L;
			}
			Set<String> keys=petAddressMap.get(city).keySet();
			//模糊匹配key
			for(String mykey:keys){
				if(mykey.contains(Address)){
					return petAddressMap.get(city).get(mykey).getId();
				}
			}
//			if(petAddressMap.get(city).get(Address)!=null){
//				return petAddressMap.get(city).get(Address).getId();
//			}
			return 0L;
		}
		public IPetCategoryService getPetCategoryService() {
			return petCategoryService;
		}
		public void setPetCategoryService(IPetCategoryService petCategoryService) {
			this.petCategoryService = petCategoryService;
		}
		public IPetAddressService getPetAddressService() {
			return petAddressService;
		}
		public void setPetAddressService(IPetAddressService petAddressService) {
			this.petAddressService = petAddressService;
		}
		
}
