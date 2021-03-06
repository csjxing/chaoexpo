package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoActivityDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoActivityQuery;

public class IBatisChaoActivityDAO extends SqlMapClientDaoSupport implements ChaoActivityDAO {

	@Override
	public Long insertActivity(ChaoActivityDO activity) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoActivity.insertActivity" , activity)) ;
	}

	@Override
	public ChaoActivityDO queryActivityById(Long id) {
		return (ChaoActivityDO)getSqlMapClientTemplate().queryForObject("ChaoActivity.queryActivityById",id) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoActivityDO> queryActivityWithPagination(ChaoActivityQuery condition, int start, int size) {
		Map<String,Object> map = condition.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoActivity.queryActivityWithPagination" , map) ;
	}

	@Override
	public int countActivityWithPagination(ChaoActivityQuery condition) {
		Map<String,Object> map = condition.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoActivity.countActivityWithPagination" , map)) ;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ChaoActivityDO> queryActivityPage(ChaoActivityCondition condition, int start, int size) {
		Map<String,Object> params = condition.toMap() ;
		params.put("start", start) ;
		params.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoActivity.queryActivityPage" , params) ;
	}
	
	@Override
	public int countActivities(ChaoActivityCondition condition) {
		return (Integer)getSqlMapClientTemplate().queryForObject("ChaoActivity.countActivities" , condition.toMap());
	}

	@Override
	public int updateActivity(ChaoActivityDO activity) {
		return getSqlMapClientTemplate().update("ChaoActivity.updateActivity", activity);
	}
	
	@Override
	public int updateActivityById(Long id, ChaoActivityUpdateCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoActivity.updateActivityById" , map);
	}

}
