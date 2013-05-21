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
public interface ChaoActivityDAO {

	Long insertActivity(ChaoActivityDO activity) ;
	
	ChaoActivityDO queryActivityById(Long id) ;
	
	List<ChaoActivityDO> queryActivityWithPagination(ChaoActivitySearchCondition condition , int start , int size) ;
	
	int countActivityWithPagination(ChaoActivitySearchCondition condition) ;
	
	int updateActivityById(Long id , ChaoActivityUpdateCondition condition) ;
}
