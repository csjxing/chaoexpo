package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.List;

import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowDelCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;

public interface ChaoUserFollowService {

	/**
	 * 
	 * @param follow
	 * @return
	 */
	long createFollow(ChaoUserFollowDO follow) ;
	
	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoUserFollowDTO> getFollowsNoPagination(ChaoUserFollowQuery query) ;
	
	/**
	 * 
	 * @param condition
	 * @param pagination
	 * @return
	 */
	QueryResult<ChaoUserFollowDTO> getFollowsWithPagination(ChaoUserFollowQuery query , Pagination pagination) ;
	
	/**
	 * 
	 * @param userName
	 * @param delCondition
	 * @return
	 */
	int deleteFollowByCondition(String userName , ChaoUserFollowDelCondition delCondition) ;
}
