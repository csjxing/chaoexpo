package com.doucome.chaoexpo.biz.core.service.chao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;

public class ChaoUserServiceImpl implements ChaoUserService {

	@Autowired
	private ChaoUserDAO chaoUserDAO ;
	
	@Override
	public Long createUser(ChaoUserDO user) {
		return chaoUserDAO.insertUser(user) ;
	}

	@Override
	public ChaoUserDTO getUserByUserName(String userName) {
		ChaoUserDO user = chaoUserDAO.queryUserByUserName(userName) ;
		if(user == null) {
			return null ;
		}
		return new ChaoUserDTO(user) ;
	}
	
	@Override
	public ChaoUserDTO getUserByUserNameAndAuthKey(String userName,String authKey) {
		ChaoUserDO user = chaoUserDAO.queryUserByUserNameAndAuthKey(userName,authKey) ;
		if(user == null) {
			return null ;
		}
		return new ChaoUserDTO(user) ;
	}

	@Override
	public int updateUserByUserName(String userName,ChaoUserUpdateCondition condition) {
		return chaoUserDAO.updateUserByUserName(userName, condition) ;
	}

	

}
