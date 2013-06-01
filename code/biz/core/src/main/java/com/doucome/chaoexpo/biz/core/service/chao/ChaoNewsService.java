package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public interface ChaoNewsService {

	/**
	 * 
	 * @param news
	 * @return
	 */
	long createNews(ChaoNewsDO news) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoNewsDTO getNewsById(long id) ;
	
	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	QueryResult<ChaoNewsDTO> getNewsSummarysWithPagination(ChaoNewsSearchCondition condition , Pagination pagination) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int updateNewsById(long id , ChaoNewsUpdateCondition condition) ;
}
