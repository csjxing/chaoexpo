package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoNewsDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

/**
 * 类IBatisBopsAdminDAO.java的实现描述：BopsAdminDAO的ibatis实现
 * 
 * @author ib 2012-4-21 下午02:30:17
 */
public class IBatisChaoNewsDAO extends SqlMapClientDaoSupport implements ChaoNewsDAO {
	
	@Override
	public Long insertNews(ChaoNewsDO news) {
		return (Long) getSqlMapClientTemplate().insert("ChaoNews.insertNews", news);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoNewsDO> queryNewsPage(ChaoNewsCondition condition, int start, int size) {
		Map<String, Object> params = condition.toMap();
		params.put("start", start);
		params.put("size", size);
		return (List<ChaoNewsDO>) getSqlMapClientTemplate().queryForList("ChaoNews.queryNewsPage", params);
	}

	@Override
	public int countNews(ChaoNewsCondition condition) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ChaoNews.countNews", condition.toMap());
	}

	@Override
	public int updateNews(ChaoNewsDO newsDO) {
		return (Integer) getSqlMapClientTemplate().update("ChaoNews.updateNews", newsDO);
	}

	@Override
	public ChaoNewsDO queryNewsById(long id) {
		return (ChaoNewsDO) getSqlMapClientTemplate().queryForObject("ChaoNews.queryNewsById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoNewsDO> queryNewsSummarysWithPagination(ChaoNewsSearchCondition condition, int start, int size) {
		Map<String, Object> params = condition.toMap();
		params.put("start", start);
		params.put("size", size);
		return (List<ChaoNewsDO>) getSqlMapClientTemplate().queryForList("ChaoNews.queryNewsSummarysWithPagination", params);
	}

	@Override
	public int countNewsSummarysWithPagination(ChaoNewsSearchCondition condition) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ChaoNews.countNewsSummarysWithPagination", condition.toMap());
	}

	@Override
	public int updateNewsById(long id, ChaoNewsUpdateCondition condition) {
		Map<String, Object> params = condition.toMap();
		params.put("id", id);
		return (Integer) getSqlMapClientTemplate().update("ChaoNews.updateNewsById", params);
	}
	
	@Override
	public int deleteNews(long id) {
		return (Integer) getSqlMapClientTemplate().update("ChaoNews.deleteNewsd", id);
	}
}
