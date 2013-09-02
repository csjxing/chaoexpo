package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import com.doucome.chaoexpo.biz.core.model.ChaoActivitySignupDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivitySignupService;
import com.doucome.chaoexpo.biz.core.utils.ChaoModelConvertUtils;
import com.doucome.chaoexpo.biz.dal.dao.ChaoActivitySignupDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivitySignupDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoActivitySignupQuery;

public class ChaoActivitySignupServiceImpl implements ChaoActivitySignupService {

	private ChaoActivitySignupDAO chaoActivitySignupDAO ;
	
	@Override
	public long createActivitySignup(ChaoActivitySignupDO signup) {
		return chaoActivitySignupDAO.insertActivitySignup(signup) ;
	}

	@Override
	public QueryResult<ChaoActivitySignupDTO> getActivitySignupWithPagination(ChaoActivitySignupQuery query, Pagination pagination) {
		int totalResults = chaoActivitySignupDAO.countActivitySignupWithPagination(query) ;
		
		if(totalResults <= 0) {
			return new QueryResult<ChaoActivitySignupDTO>(new ArrayList<ChaoActivitySignupDTO>() , pagination, totalResults) ;
		}
		
		List<ChaoActivitySignupDO> doList = chaoActivitySignupDAO.queryActivitySignupWithPagination(query, pagination.getStart(), pagination.getSize()) ;
		
		List<ChaoActivitySignupDTO> dtoList = ChaoModelConvertUtils.toActSignupDTOList(doList) ;
		
		return new QueryResult<ChaoActivitySignupDTO>(dtoList , pagination, totalResults) ;
	}

	
	
}
