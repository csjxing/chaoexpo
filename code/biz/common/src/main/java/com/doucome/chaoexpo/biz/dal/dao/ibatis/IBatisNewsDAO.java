package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoNewsDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

/**
 * 类IBatisBopsAdminDAO.java的实现描述：BopsAdminDAO的ibatis实现
 * 
 * @author ib 2012-4-21 下午02:30:17
 */
public class IBatisNewsDAO extends SqlMapClientDaoSupport implements ChaoNewsDAO {
	
	@Override
	public Long insertNews(ChaoNewsDO news) {
		return (Long) getSqlMapClientTemplate().insert("chaoNews.insertNews", news);
	}

	@Override
	public ChaoNewsDO queryNews(long id) {
		return (ChaoNewsDO) getSqlMapClientTemplate().queryForObject("chaoNews.insertNews", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoNewsDO> queryNewsPage(ChaoNewsCondition condition, int start, int size) {
		Map<String, Object> params = condition.toMap();
		params.put("start", start);
		params.put("size", size);
		return (List<ChaoNewsDO>) getSqlMapClientTemplate().queryForList("chaoNews.queryNewsPage", params);
	}

	@Override
	public int countNews(ChaoNewsCondition condition) {
		return (Integer) getSqlMapClientTemplate().queryForObject("chaoNews.countNews", condition.toMap());
	}

	@Override
	public int updateNews(ChaoNewsDO newsDO) {
		return (Integer) getSqlMapClientTemplate().update("chaoNews.updateNews", newsDO);
	}
	
	@Override
	public int updateNewsDisplayOrder(Long id) {
		return (Integer) getSqlMapClientTemplate().update("chaoNews.updateNews", id);
	}
}
