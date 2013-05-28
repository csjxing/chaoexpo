package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;

public class IBatisChaoUserDAO extends SqlMapClientDaoSupport implements ChaoUserDAO{

	@Override
	public Long insertUser(ChaoUserDO user) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoUser.insertUser" , user)) ;
	}

	@Override
	public ChaoUserDO queryUserByUserName(String userName) {
		return (ChaoUserDO)getSqlMapClientTemplate().queryForObject("ChaoUser.queryUserByUserName" , userName) ;
	}
	
	@Override
	public ChaoUserDO queryUserByUserNameAndAuthKey(String userName,String authKey) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("userName", userName) ;
		map.put("authKey", authKey) ;
		return (ChaoUserDO)getSqlMapClientTemplate().queryForObject("ChaoUser.queryUserByUserNameAndAuthKey" , map) ;
	}

	@Override
	public int updateUserByUserName(String userName,ChaoUserUpdateCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		map.put("userName", userName) ;
		return getSqlMapClientTemplate().update("ChaoUser.updateUserByUserName" , map);
	}

	@Override
	public long queryMaxId() {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().queryForObject("ChaoUser.queryMaxId")) ;
	}

	

}
