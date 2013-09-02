package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivitySignupDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoActivitySignupQuery;

/**
 * 
 * @author langben 2013-9-2
 *
 */
public interface ChaoActivitySignupDAO {

	/**
	 * 
	 * @param signup
	 * @return
	 */
	long insertActivitySignup(ChaoActivitySignupDO signup) ;
	
	/**
	 * 
	 * @param query
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoActivitySignupDO> queryActivitySignupWithPagination(ChaoActivitySignupQuery query , int start , int size) ;
	
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	int countActivitySignupWithPagination(ChaoActivitySignupQuery query) ;
}
