package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCatSearchCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoNewsCategoryDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;

public class IBatisChaoNewsCategoryDAO extends SqlMapClientDaoSupport implements ChaoNewsCategoryDAO {

	@Override
	public long insertCategory(ChaoNewsCategoryDO cat) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoNewsCategory.insertCategory" , cat)) ;
	}
	
	@Override
	public ChaoNewsCategoryDO queryCategoryById(Long id) {
		return (ChaoNewsCategoryDO)getSqlMapClientTemplate().queryForObject("ChaoNewsCategory.queryCategoryById" , id) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoNewsCategoryDO> queryCategoriesByIds(List<Long> ids) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		return getSqlMapClientTemplate().queryForList("ChaoNewsCategory.queryCategoriesByIds", params) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoNewsCategoryDO> queryCategoriesWithPagination(ChaoNewsCatSearchCondition condition, int start, int size) {
		Map<String,Object> map = condition.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoNewsCategory.queryCategoriesWithPagination", map);
	}

	@Override
	public int countCategoriesWithPagination(ChaoNewsCatSearchCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoNewsCategory.countCategoriesWithPagination" , map)) ;
	}
	
	@Override
	public int updateCategory(ChaoNewsCategoryDO category) {
		return (Integer) getSqlMapClientTemplate().update("ChaoNewsCategory.updateCategory", category);
	}
	
	@Override
	public int updateStatus(Long id, String status) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("status", status);
		return getSqlMapClientTemplate().update("ChaoNewsCategory.updateStatus", params);
	}
}
