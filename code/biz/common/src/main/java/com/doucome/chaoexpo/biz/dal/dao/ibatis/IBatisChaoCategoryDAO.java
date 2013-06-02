package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.dal.dao.ChaoCategoryDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCategoryDO;

public class IBatisChaoCategoryDAO extends SqlMapClientDaoSupport implements ChaoCategoryDAO {

	@Override
	public Long insertCategory(ChaoCategoryDO category) {
		return (Long) getSqlMapClientTemplate().insert("chaoCategory.insertCategory", category);
	}

	@Override
	public ChaoCategoryDO queryCategory(Long id) {
		return (ChaoCategoryDO) getSqlMapClientTemplate().queryForObject("chaoCategory.queryCategory", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoCategoryDO> queryCategoryPage(String status, int start, int size) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("start", start);
		params.put("size", size);
		return (List<ChaoCategoryDO>) getSqlMapClientTemplate().queryForList("chaoCategory.queryCategoryPage", params);
	}

	@Override
	public int countCategory(String status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		return (Integer) getSqlMapClientTemplate().queryForObject("chaoCategory.countCategory", params);
	}
	
	@Override
	public int updateCategory(ChaoCategoryDO category) {
		return (Integer) getSqlMapClientTemplate().update("chaoCategory.updateCategory", category);
	}

	@Override
	public int updateCategoryName(Long id, String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("name", name);
		return (Integer) getSqlMapClientTemplate().update("chaoCategory.updateCategoryName", params);
	}

	@Override
	public int updateCategoryStatus(Long id, String status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("status", status);
		return (Integer) getSqlMapClientTemplate().update("chaoCategory.updateCategoryStatus", params);
	}

	@Override
	public int deleteCategory(Long id) {
		return getSqlMapClientTemplate().delete("chaoCategory.deleteCategory", id);
	}
	
}
