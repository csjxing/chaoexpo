package com.doucome.chaoexpo.biz.core.service.chao;


import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;

public interface ChaoNewsService {
	/**
	 * 
	 * @param user
	 * @return
	 */
	Long createNews(ChaoNewsDTO news);
	/**
	 * 
	 * @param userName
	 * @return
	 */
	ChaoNewsDTO getNews(Long id);
	/**
	 * 
	 * @param userName
	 * @param authKey
	 * @return
	 */
	QueryResult<ChaoNewsDTO> getNewsPage(ChaoNewsCondition condition, Pagination page);
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int updateNews(ChaoNewsDTO news);
	/**
	 * 
	 * @param id
	 * @return
	 */
	int moveNewsFront(Long id);
}
