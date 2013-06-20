package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoIntroUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoIntroDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoIntroDO;

public class IBatisChaoIntroDAO extends SqlMapClientDaoSupport implements ChaoIntroDAO {

	@Override
	public long insertIntro(ChaoIntroDO intro) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoIntro.insertIntro" , intro)) ;
	}

	@Override
	public ChaoIntroDO queryIntro() {
		return (ChaoIntroDO)getSqlMapClientTemplate().queryForObject("ChaoIntro.queryIntro") ;
	}

	@Override
	public int updateIntro(ChaoIntroUpdateCondition update) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		return getSqlMapClientTemplate().update("ChaoIntro.updateIntro" , map) ;
	}

}
