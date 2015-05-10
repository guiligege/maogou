package org.guili.ecshop.business.impl.product;

import java.util.EnumMap;
import java.util.Map;
import org.guili.ecshop.business.product.IProductService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * //加载bean实例，并提供通过enum获取实体bean的方法。
 * @author Administrator
 */
public class Spiders  implements ApplicationContextAware{

	 private static Map<SpiderType,IProductService> handlers = new EnumMap<SpiderType, IProductService>(SpiderType.class);
	 
	 public static IProductService getHandler(SpiderType spiderType){
		 if(spiderType==null){
			 return null;
		 }
		 return handlers.get(spiderType);
	 }
	 
	 /**
	  * 初始化实体bean
	  */
	 @Override
	 public void setApplicationContext(ApplicationContext applicationContext)
	   throws BeansException {
		  Map<String, IProductService> beansMap = applicationContext.getBeansOfType(IProductService.class);
		  SpiderType [] spiderTypes = null;
		  for(String beanName:beansMap.keySet()){
			   IProductService handler = beansMap.get(beanName);
			   spiderTypes = handler.getSpiderType();
			   if(spiderTypes == null || spiderTypes.length == 0){
				   continue;
			   }
			   for(SpiderType spiderType: spiderTypes){
				   handlers.put(spiderType, handler);
			   }
		 }
	}

}
