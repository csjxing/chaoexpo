package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoSubjectDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;

public class IBatisChaoSubjectDAO extends SqlMapClientDaoSupport implements ChaoSubjectDAO {

	@Override
	public Long insertSubject(ChaoSubjectDO subject) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoSubject.insertSubject" , subject)) ;
	}

	@Override
	public ChaoSubjectDO querySubjectById(Long id) {
		return (ChaoSubjectDO)getSqlMapClientTemplate().queryForObject("ChaoSubject.querySubjectById" , id) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoSubjectDO> querySubjectsWithPagination(ChaoSubjectSearchCondition condition, int start, int size) {
		Map<String,Object> map = condition.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoSubject.querySubjectsWithPagination" , map) ;
	}

	@Override
	public int countSubjectsWithPagination(ChaoSubjectSearchCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoSubject.countSubjectsWithPagination" , map)) ;
	}

	@Override
	public int updateSubjectById(Long id, ChaoSubjectUpdateCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoSubject.updateSubjectById" , map);
	}
	
	@Override
	public int updateSubject(ChaoSubjectDO subject) {
		return getSqlMapClientTemplate().update("ChaoSubject.updateSubject" , subject);
	}
}
