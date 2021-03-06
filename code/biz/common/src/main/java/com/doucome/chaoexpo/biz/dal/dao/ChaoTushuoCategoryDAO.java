package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoCateUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoCategoryQuery;

/**
 * 
 * @author langben 2013-7-5
 *
 */
public interface ChaoTushuoCategoryDAO {

	/**
	 * 
	 * @param category
	 * @return
	 */
	long insertCategory(ChaoTushuoCategoryDO category) ;
	
	/**
	 * 
	 * @return
	 */
	List<ChaoTushuoCategoryDO> queryCategories(ChaoTushuoCategoryQuery query) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoTushuoCategoryDO queryCategoryById(long id) ;
	
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateCategoryById(long id , ChaoTushuoCateUpdateCondition condition) ;
	
}
