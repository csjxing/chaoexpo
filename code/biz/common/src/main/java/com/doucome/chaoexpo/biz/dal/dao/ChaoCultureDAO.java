package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureQuery;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;

public interface ChaoCultureDAO {

	/**
	 * 
	 * @param culture
	 * @return
	 */
	long insertCulture(ChaoCultureDO culture) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoCultureDO queryCultureById(long id) ;
	
	/**
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoCultureDO> queryCulturesWithPagination(ChaoCultureQuery query ,int start , int size) ;
	
	/**
	 * 
	 * @return
	 */
	int countCulturesWithPagination(ChaoCultureQuery query) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteCultureById(long id) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	int updateCultureById(long id , ChaoCultureUpdateCondition update) ;
	
}
