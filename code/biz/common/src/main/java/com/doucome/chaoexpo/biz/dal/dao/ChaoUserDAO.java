package com.doucome.chaoexpo.biz.dal.dao;

import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;

/**
 * user
 * @author langben 2013-5-21
 *
 */
public interface ChaoUserDAO {
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	Long insertUser(ChaoUserDO user) ;
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	ChaoUserDO queryUserByUserName(String userName) ;
	
	/**
	 * 
	 * @param userName
	 * @param authKey
	 * @return
	 */
	ChaoUserDO queryUserByUserNameAndAuthKey(String userName , String authKey) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int updateUserByUserName(String userName , ChaoUserUpdateCondition condition) ;
	
	/**
	 * 
	 * @return
	 */
	long queryMaxId() ;
}
