package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoAppRecommendQuery;

public interface ChaoAppRecommendDAO {

	/**
	 * 
	 * @return
	 */
	long insertRecommend(ChaoAppRecommendDO recommend) ;
	
	ChaoAppRecommendDO queryRecommendById(long id) ;
	
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
