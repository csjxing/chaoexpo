package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.List;

import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowSearchCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;

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
	List<ChaoUserFollowDTO> getFollowsNoPagination(ChaoUserFollowSearchCondition condition) ;
	
}
