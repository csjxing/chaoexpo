package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoQuery;

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
	
	/**
	 * 
	 * @param id
	 * @param newCateId
	 * @return
	 */
	int updateTushuoCateById(Long id , Long newCateId) ;
}
