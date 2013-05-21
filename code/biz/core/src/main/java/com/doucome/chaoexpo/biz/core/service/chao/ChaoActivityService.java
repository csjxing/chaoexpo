package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivitySearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;

/**
 * 活动
 * @author langben 2013-5-21
 *
 */
public interface ChaoActivityService {

	Long createActivity(ChaoActivityDO activity) ;
	
	ChaoActivityDTO getActivityById(Long id) ;
	
	QueryResult<ChaoActivityDTO> getActivityWithPagination(ChaoActivitySearchCondition condition , Pagination pagination) ;
	
	int updateActivityById(Long id , ChaoActivityUpdateCondition condition) ;
}
