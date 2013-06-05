package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendQuery;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;

public interface ChaoAppRecommendDAO {

	/**
	 * 
	 * @return
	 */
	long insertRecommend(ChaoAppRecommendDO recommend) ;
	
	/**
	 * 
	 * @return
	 */
	List<ChaoAppRecommendDO> queryRecommendWithPagination(ChaoAppRecommendQuery query ,int start , int size) ;
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	int countRecommendWithPagination(ChaoAppRecommendQuery query) ;
}
