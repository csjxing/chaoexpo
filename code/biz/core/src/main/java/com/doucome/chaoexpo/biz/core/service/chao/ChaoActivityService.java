package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivitySearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;

/**
 * 活动
 * @author langben 2013-5-21
 *
 */
public interface ChaoActivityService {
	/**
	 * 
	 * @param activity
	 * @return
	 */
	Long createActivity(ChaoActivityDO activity) ;
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoActivityDTO getActivityById(Long id) ;
	/**
	 * 获取了CHAO_ACTIVITY部分字段信息.
	 * @param condition
	 * @param pagination
	 * @return
	 */
	QueryResult<ChaoActivityDTO> getActivityWithPagination(ChaoActivitySearchCondition condition , Pagination pagination) ;
	/**
	 * 获取了CHAO_ACTIVITY所有字段信息.
	 * @param condition
	 * @param pagination
	 * @return
	 */
	QueryResult<ChaoActivityDTO> getActivityPage(ChaoActivityCondition condition, Pagination pagination);
	/**
	 * 
	 * @param activity
	 * @return
	 */
	int updateActivity(ChaoActivityDTO activity);
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateActivityById(Long id , ChaoActivityUpdateCondition condition) ;
}
