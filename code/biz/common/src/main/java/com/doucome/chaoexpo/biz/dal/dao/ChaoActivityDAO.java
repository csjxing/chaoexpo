package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoActivityQuery;

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
	List<ChaoActivityDO> queryActivityWithPagination(ChaoActivityQuery condition , int start , int size) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countActivityWithPagination(ChaoActivityQuery condition) ;
	/**
	 * CHAO_ACTIVITY全字段数据.
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoActivityDO> queryActivityPage(ChaoActivityCondition condition, int start, int size);
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countActivities(ChaoActivityCondition condition);
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
