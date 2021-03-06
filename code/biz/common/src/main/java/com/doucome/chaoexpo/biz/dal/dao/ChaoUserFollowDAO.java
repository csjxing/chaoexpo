package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowDelCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;

/**
 * 用户关注
 * @author langben 2013-5-27
 *
 */
public interface ChaoUserFollowDAO {

	/**
	 * 
	 * @param follow
	 * @return
	 */
	long insertFollow(ChaoUserFollowDO follow) ;
	
	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoUserFollowDO> queryFollowsWithPagination(ChaoUserFollowQuery condition , int start , int size) ;
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countFollowsWithPagination(ChaoUserFollowQuery condition) ;
	
	/**
	 * 
	 * @param userName
	 * @param delCondition
	 * @return
	 */
	int deleteFollowByCondition(String userName,ChaoUserFollowDelCondition delCondition) ;
	
}
