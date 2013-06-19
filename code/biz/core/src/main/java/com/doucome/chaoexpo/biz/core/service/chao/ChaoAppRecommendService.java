package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendQuery;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;

public interface ChaoAppRecommendService {

	/**
	 * 
	 * @return
	 */
	long createRecommend(ChaoAppRecommendDO recommend) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoAppRecommendDTO getRecommendById(long id) ;
	
	/**
	 * 
	 * @return
	 */
	QueryResult<ChaoAppRecommendDTO> getRecommendWithPagination(ChaoAppRecommendQuery query , Pagination pagination) ;
	
	
	/**
	 * 
	 * @param update
	 * @return
	 */
	int updateRecommendById(long id , ChaoAppRecommendUpdateCondition update) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteRecommendById(long id) ;
}
