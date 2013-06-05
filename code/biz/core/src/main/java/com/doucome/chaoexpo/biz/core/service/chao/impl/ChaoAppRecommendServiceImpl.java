package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoAppRecommendService;
import com.doucome.chaoexpo.biz.core.utils.ChaoModelConvertUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendQuery;
import com.doucome.chaoexpo.biz.dal.dao.ChaoAppRecommendDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;

public class ChaoAppRecommendServiceImpl implements ChaoAppRecommendService {

	@Autowired
	private ChaoAppRecommendDAO chaoAppRecommendDAO ;
	
	@Override
	public long createRecommend(ChaoAppRecommendDO recommend) {
		return chaoAppRecommendDAO.insertRecommend(recommend) ;
	}

	@Override
	public QueryResult<ChaoAppRecommendDTO> getRecommendWithPagination(ChaoAppRecommendQuery query, Pagination pagination) {
		
		int totalRecords = chaoAppRecommendDAO.countRecommendWithPagination(query);
        if (totalRecords <= 0) {
            return new QueryResult<ChaoAppRecommendDTO>(new ArrayList<ChaoAppRecommendDTO>(), pagination, totalRecords);
        }
        List<ChaoAppRecommendDO> doList = chaoAppRecommendDAO.queryRecommendWithPagination(query, pagination.getStart(), pagination.getSize()) ;
        List<ChaoAppRecommendDTO> dtoList = ChaoModelConvertUtils.toAppRecommDTOList(doList) ;
        return new QueryResult<ChaoAppRecommendDTO>(dtoList, pagination, totalRecords);
	}

}
