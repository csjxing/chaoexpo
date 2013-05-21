package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;

public interface ChaoUserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	Long createUser(ChaoUserDO user) ;
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	ChaoUserDTO getUserByUserName(String userName) ;
	
	/**
	 * 
	 * @param userName
	 * @param authKey
	 * @return
	 */
	ChaoUserDTO getUserByUserNameAndAuthKey(String userName , String authKey) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int updateUserByUserName(String userName , ChaoUserUpdateCondition condition) ;
	
}
