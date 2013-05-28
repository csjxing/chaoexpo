package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowSearchCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserFollowDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;

public class ChaoUserFollowServiceImpl implements ChaoUserFollowService {

	@Autowired
	private ChaoUserFollowDAO chaoUserFollowDAO ;
	
	@Override
	public long createFollow(ChaoUserFollowDO follow) {
		return chaoUserFollowDAO.insertFollow(follow) ;
	}

	@Override
	public List<ChaoUserFollowDTO> getFollowsNoPagination(ChaoUserFollowSearchCondition condition) {
		List<ChaoUserFollowDO> userFollowList = chaoUserFollowDAO.queryFollowsWithPagination(condition, 1, 1000) ;
		List<ChaoUserFollowDTO> dtoList = new ArrayList<ChaoUserFollowDTO>() ;
		if(CollectionUtils.isNotEmpty(userFollowList)) {
			for(ChaoUserFollowDO userFollow : userFollowList) {
				dtoList.add(new ChaoUserFollowDTO(userFollow)) ;
			}
		}
		return dtoList;
	}

}
