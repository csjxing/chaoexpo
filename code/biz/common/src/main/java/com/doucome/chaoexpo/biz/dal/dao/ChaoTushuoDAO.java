package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoQuery;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;

public interface ChaoTushuoDAO {

	/**
	 * 
	 * @param tushuo
	 * @return
	 */
	long insertTushuo(ChaoTushuoDO tushuo) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoTushuoDO queryTushuoById(Long id) ;
	
	/**
	 * 
	 * @param query
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoTushuoDO> queryTushuosWithPagination(ChaoTushuoQuery query , int start , int size) ;
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	int countTushuosWithPagination(ChaoTushuoQuery query) ;

	/**
	 * 
	 * @param id
	 * @param update
	 * @return
	 */
	int updateTushuoById(Long id , ChaoTushuoUpdateCondition update) ;
}
