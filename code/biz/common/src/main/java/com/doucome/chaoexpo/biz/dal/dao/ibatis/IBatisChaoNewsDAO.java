package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoNewsDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class IBatisChaoNewsDAO extends SqlMapClientDaoSupport implements ChaoNewsDAO {

	@Override
	public long insertNews(ChaoNewsDO news) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoNews.insertNews" , news)) ;
	}
	
	@Override
	public ChaoNewsDO queryNewsById(long id) {
		return (ChaoNewsDO)getSqlMapClientTemplate().queryForObject("ChaoNews.queryNewsById" , id) ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoNewsDO> queryNewsSummarysWithPagination(ChaoNewsSearchCondition condition, int start, int size) {
		Map<String,Object> map = condition.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoNews.queryNewsSummarysWithPagination" , map) ;
	}

	@Override
	public int countNewsSummarysWithPagination(ChaoNewsSearchCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoNews.countNewsSummarysWithPagination" , map));
	}

	@Override
	public int updateNewsById(long id, ChaoNewsUpdateCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoNews.updateNewsById" , map) ;
	}

	@Override
	public int updateDisplayOrderById(Long id) {
		return getSqlMapClientTemplate().update("ChaoNews.updateDisplayOrderById" , System.currentTimeMillis()) ;
	}

}
