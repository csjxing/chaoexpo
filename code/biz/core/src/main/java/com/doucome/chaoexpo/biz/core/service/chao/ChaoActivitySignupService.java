package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoActivitySignupDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivitySignupCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivitySignupDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoActivitySignupQuery;

public interface ChaoActivitySignupService {
	/**
	 * 
	 * @param signup
	 * @return
	 */
	long createActivitySignup(ChaoActivitySignupDO signup) ;
	
	/**
	 * 
	 * @param query
	 * @param start
	 * @param size
	 * @return
	 */
	QueryResult<ChaoActivitySignupDTO> getActivitySignupWithPagination(ChaoActivitySignupQuery query , Pagination pagination) ;
}
