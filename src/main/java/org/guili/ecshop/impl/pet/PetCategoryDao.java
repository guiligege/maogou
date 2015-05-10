package org.guili.ecshop.impl.pet;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetCategory;
import org.guili.ecshop.dao.pet.IPetCategoryDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 查询宠物类别
 * @author Administrator
 *
 */
public class PetCategoryDao extends BasicSqlSupport implements IPetCategoryDao {
	private static Logger logger=Logger.getLogger(PetCategoryDao.class);
	@Override
	public List<PetCategory> selectAllPetCategory() throws Exception {
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.pet.IPetCategoryDao.selectAllPetCategory");
		logger.debug("success!size is:"+list.size());
		return list;
	}
}
