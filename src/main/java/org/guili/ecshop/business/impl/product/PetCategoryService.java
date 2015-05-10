package org.guili.ecshop.business.impl.product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetCategory;
import org.guili.ecshop.business.product.IPetCategoryService;
import org.guili.ecshop.dao.pet.IPetCategoryDao;
import org.guili.ecshop.util.chongwu.PetCategoryConstants;

/**
 * 宠物类别
 * @author Administrator
 */
public class PetCategoryService implements IPetCategoryService {
	//单例模式
//    private static PetCategoryService singleton;
//    private PetCategoryService(){
//    }
//    public static PetCategoryService getInstance(){
//        if(singleton==null){
//            singleton=new PetCategoryService();
//        }
//        return singleton;
//    }   
	private  IPetCategoryDao petCategoryDao;
	private static Logger logger=Logger.getLogger(PetCategoryService.class);
//	public static Map<String, Long> categoryMap=new HashMap<String, Long>();
	//查询各个分类信息，方便页面显示
//	public static Map<String, List<PetCategory>> categoryPetMap=new LinkedHashMap<String, List<PetCategory>>();
//	static {
//		//init category map
//		categoryMap=selectAllPetCategory();
////		categoryPetMap=initCategoryPetMap();
//	}
	
	//获取所有宠物类型
	public   Map<String, Long> selectAllPetCategory() {
		 Map<String, Long> map=new HashMap<String, Long>();
		try {
			List<PetCategory> listPetCategory=petCategoryDao.selectAllPetCategory();
			if(!listPetCategory.isEmpty()){
				for(int i=0;i<listPetCategory.size();i++){
					map.put(listPetCategory.get(i).getName(), listPetCategory.get(i).getId());
				}
			}
			return map;
		} catch (Exception e) {
			logger.error("selectAllPetCategory 获取宠物类型失败："+e.getStackTrace());
			return null;
		}
	}
	
	//初始化，宠物类型map
	public   Map<String, List<PetCategory>> initCategoryPetMap(){
		 Map<String, List<PetCategory>> map=new LinkedHashMap<String, List<PetCategory>>();
			try {
				List<PetCategory> listPetCategory=petCategoryDao.selectAllPetCategory();
				if(!listPetCategory.isEmpty()){
					//循环宠物所有大类别，狗，猫等
					for(PetCategoryConstants name :PetCategoryConstants.values()){
						List<PetCategory> petCategoryList=new ArrayList<PetCategory>();
						for(int i=0;i<listPetCategory.size();i++){
							//如果类别的父类别的常量的父id一致，加入该list
							if(name.getParentCategoryId().equals(listPetCategory.get(i).getParentType())){
								petCategoryList.add(listPetCategory.get(i));
							}
						}
						if(!petCategoryList.isEmpty()){
							map.put(name.getCategoryName(), petCategoryList);
						}
					}
				}
				return map;
			} catch (Exception e) {
				logger.error("initCategoryPetMap 获取宠物类型失败："+e.getStackTrace());
				return null;
			}
	}
	
	public IPetCategoryDao getPetCategoryDao() {
		return petCategoryDao;
	}

	public void setPetCategoryDao(IPetCategoryDao petCategoryDao) {
		this.petCategoryDao = petCategoryDao;
	}

}
