package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoQuery;

public interface ChaoTushuoService {

	/**
	 * 
	 * @param tushuo
	 * @return
	 */
	long createTushuo(ChaoTushuoDO tushuo) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoTushuoDTO getTushuoById(Long id) ;
	
	/**
	 * 
	 * @param query
	 * @param start
	 * @param size
	 * @return
	 */
	QueryResult<ChaoTushuoDTO> getTushuosWithPagination(ChaoTushuoQuery query , Pagination pagination) ;
	

	/**
	 * 
	 * @param id
	 * @param update
	 * @return
	 */
	int updateTushuoById(Long id , ChaoTushuoUpdateCondition update) ;
	
}
