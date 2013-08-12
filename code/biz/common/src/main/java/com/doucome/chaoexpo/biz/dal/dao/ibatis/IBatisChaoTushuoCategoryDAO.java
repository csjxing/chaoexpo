package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoCateUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoTushuoCategoryDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoCategoryQuery;

public class IBatisChaoTushuoCategoryDAO extends SqlMapClientDaoSupport implements ChaoTushuoCategoryDAO {

	@Override
	public long insertCategory(ChaoTushuoCategoryDO category) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoTushuoCategory.insertCategory" , category)) ;
	}
	
	@Override
	public ChaoTushuoCategoryDO queryCategoryById(long id) {
		return (ChaoTushuoCategoryDO)getSqlMapClientTemplate().queryForObject("ChaoTushuoCategory.queryCategoryById" , id) ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoTushuoCategoryDO> queryCategories(ChaoTushuoCategoryQuery query) {
		Map<String,Object> map = query.toMap() ;
		return getSqlMapClientTemplate().queryForList("ChaoTushuoCategory.queryCategories" , map) ;
	}
	
	@Override
	public int updateCategoryById(long id,ChaoTushuoCateUpdateCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoTushuoCategory.updateCategoryById",map) ;
	}

}
