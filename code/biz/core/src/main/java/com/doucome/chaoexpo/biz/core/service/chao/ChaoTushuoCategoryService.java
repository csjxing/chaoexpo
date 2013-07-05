package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.List;

import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoCateUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;

public interface ChaoTushuoCategoryService {

	/**
	 * 
	 * @param category
	 * @return
	 */
	long createCategory(ChaoTushuoCategoryDO category) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoTushuoCategoryDTO getCategoryById(long id) ;
	
	/**
	 * 
	 * @return
	 */
	List<ChaoTushuoCategoryDTO> getCategories() ;
	
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateCategoryById(long id , ChaoTushuoCateUpdateCondition condition) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteCategoryById(long id) ;
	
}
