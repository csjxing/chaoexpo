package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCatSearchCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;

/**
 * 新闻资讯
 * @author langben 2013-5-27
 *
 */
public interface ChaoNewsCategoryDAO {

	/**
	 * 
	 * @param news
	 * @return
	 */
	long insertCategory(ChaoNewsCategoryDO cat) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<ChaoNewsCategoryDO> queryCategoriesByIds(List<Long> ids) ;

	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoNewsCategoryDO> queryCategoriesWithPagination(ChaoNewsCatSearchCondition condition , int start , int size) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countCategoriesWithPagination(ChaoNewsCatSearchCondition condition) ;
	
}
