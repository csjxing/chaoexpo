package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoActivitySearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;

/**
 * 活动
 * @author langben 2013-5-21
 *
 */
public interface ChaoActivityDAO{

	/**
	 * 
	 * @param activity
	 * @return
	 */
	Long insertActivity(ChaoActivityDO activity) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoActivityDO queryActivityById(Long id) ;
	
	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoActivityDO> queryActivityWithPagination(ChaoActivitySearchCondition condition , int start , int size) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countActivityWithPagination(ChaoActivitySearchCondition condition) ;
	/**
	 * 
	 * @param activity
	 * @return
	 */
	int updateActivity(ChaoActivityDO activity);
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateActivityById(Long id , ChaoActivityUpdateCondition condition) ;
}
