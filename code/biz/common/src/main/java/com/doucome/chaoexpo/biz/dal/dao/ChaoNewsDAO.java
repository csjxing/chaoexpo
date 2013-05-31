package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

/**
 * 用户关注
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
	 * @param newsId
	 * @return
	 */
	ChaoNewsDO queryNews(long id);
	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoNewsDO> queryNewsPage(ChaoNewsCondition condition, int start, int size) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countNews(ChaoNewsCondition condition) ;
	/**
	 * 
	 * @param newsDO
	 * @return
	 */
	int updateNews(ChaoNewsDO newsDO);
	/**
	 * 
	 * @param id
	 * @return
	 */
	int updateNewsDisplayOrder(Long id);
}
