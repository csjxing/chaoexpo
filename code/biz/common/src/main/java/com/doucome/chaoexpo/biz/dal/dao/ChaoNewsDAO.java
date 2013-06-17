package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

/**
 * 新闻资讯
 * @author langben 2013-5-27
 *
 */
public interface ChaoNewsDAO {

	/**
	 * 
	 * @param news
	 * @return
	 */
	Long insertNews(ChaoNewsDO news) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoNewsDO queryNewsById(long id) ;

	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoNewsDO> queryNewsSummarysWithPagination(ChaoNewsSearchCondition condition , int start , int size) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countNewsSummarysWithPagination(ChaoNewsSearchCondition condition) ;
	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoNewsDO> queryNewsPage(ChaoNewsCondition condition, int start, int size);
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countNews(ChaoNewsCondition condition);
	/**
	 * 
	 * @param newsDO
	 * @return
	 */
	int updateNews(ChaoNewsDO newsDO);
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int updateNewsById(long id , ChaoNewsUpdateCondition condition) ;
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteNews(long id);
}
