package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoCultureDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;

public interface ChaoCultureService {

	/**
	 * 
	 * @param culture
	 * @return
	 */
	long createCulture(ChaoCultureDO culture) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoCultureDTO getCultureById(long id) ;
	
	/**
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	QueryResult<ChaoCultureDTO> getCulturesWithPagination(Pagination pagination) ;
	
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
