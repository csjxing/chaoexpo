package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.dao.ChaoActivitySignupDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivitySignupDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoActivitySignupQuery;

public class IBatisChaoActivitySignupDAO extends SqlMapClientDaoSupport implements ChaoActivitySignupDAO {

	@Override
	public long insertActivitySignup(ChaoActivitySignupDO signup) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoActivitySignup.insertActivitySignup" , signup)) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoActivitySignupDO> queryActivitySignupWithPagination(ChaoActivitySignupQuery query, int start, int size) {
		Map<String,Object> map = query.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoActivitySignup.queryActivitySignupWithPagination" , map) ;
	}

	@Override
	public int countActivitySignupWithPagination(ChaoActivitySignupQuery query) {
		Map<String,Object> map = query.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoActivitySignup.countActivitySignupWithPagination" ,map)) ;
	}

}
