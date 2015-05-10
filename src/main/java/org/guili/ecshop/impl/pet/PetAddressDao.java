package org.guili.ecshop.impl.pet;

import java.util.List;
import org.apache.log4j.Logger;
import org.guili.ecshop.bean.chongwu.PetAddress;
import org.guili.ecshop.dao.pet.IPetAddressDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 查询宠物类别
 * @author Administrator
 *
 */
public class PetAddressDao extends BasicSqlSupport implements IPetAddressDao {
	private static Logger logger=Logger.getLogger(PetAddressDao.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<PetAddress> selectAllPetAddress() throws Exception {
		@SuppressWarnings("rawtypes")
		List list=this.session.selectList("org.guili.ecshop.dao.pet.IPetAddressDao.selectAllPetAddress");
		logger.debug("success!size is:"+list.size());
		return list;
	}
}
