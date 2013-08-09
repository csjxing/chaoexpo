package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.core.utils.ChaoModelConvertUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowDelCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserFollowDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;

public class ChaoUserFollowServiceImpl implements ChaoUserFollowService {

	@Autowired
	private ChaoUserFollowDAO chaoUserFollowDAO ;
	
	@Override
	public long createFollow(ChaoUserFollowDO follow) {
		return chaoUserFollowDAO.insertFollow(follow) ;
	}

	@Override
	public List<ChaoUserFollowDTO> getFollowsNoPagination(ChaoUserFollowQuery query) {
		List<ChaoUserFollowDO> userFollowList = chaoUserFollowDAO.queryFollowsWithPagination(query, 1, 1000) ;
		return ChaoModelConvertUtils.toUserFollowDTOList(userFollowList) ;
	}
	
	@Override
	public QueryResult<ChaoUserFollowDTO> getFollowsWithPagination(ChaoUserFollowQuery query, Pagination pagination) {
		int totalRecords = chaoUserFollowDAO.countFollowsWithPagination(query) ;
        if (totalRecords <= 0) {
            return new QueryResult<ChaoUserFollowDTO>(new ArrayList<ChaoUserFollowDTO>(), pagination, totalRecords);
        }
        List<ChaoUserFollowDO> doList = chaoUserFollowDAO.queryFollowsWithPagination(query,pagination.getStart(),pagination.getSize()) ;
        List<ChaoUserFollowDTO> dtoList = ChaoModelConvertUtils.toUserFollowDTOList(doList) ;
        return new QueryResult<ChaoUserFollowDTO>(dtoList, pagination, totalRecords);
	}

	@Override
	public int deleteFollowByCondition(String userName,ChaoUserFollowDelCondition delCondition) {
		return chaoUserFollowDAO.deleteFollowByCondition(userName, delCondition) ;
	}

	

}
