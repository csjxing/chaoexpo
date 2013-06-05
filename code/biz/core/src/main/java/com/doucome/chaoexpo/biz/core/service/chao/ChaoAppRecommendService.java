package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendQuery;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;

public interface ChaoAppRecommendService {

	/**
	 * 
	 * @return
	 */
	long createRecommend(ChaoAppRecommendDO recommend) ;
	
	/**
	 * 
	 * @return
	 */
	QueryResult<ChaoAppRecommendDTO> getRecommendWithPagination(ChaoAppRecommendQuery query , Pagination pagination) ;
	
}
