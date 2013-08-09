package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoAppRecommendService;
import com.doucome.chaoexpo.biz.dal.query.ChaoAppRecommendQuery;

/**
 * 应用推荐列表
 * @author langben 2013-6-5
 *
 */
@SuppressWarnings("serial")
public class AppRecommendListAction extends BopsBasicAction {

	private QueryResult<ChaoAppRecommendDTO> queryResult ;
	
	@Autowired
	private ChaoAppRecommendService chaoAppRecommendService ;
	
	@Override
	public String execute() throws Exception {
		
		queryResult = chaoAppRecommendService.getRecommendWithPagination(new ChaoAppRecommendQuery(), new Pagination(1,100)) ;
		
		return SUCCESS ;
	}

	public QueryResult<ChaoAppRecommendDTO> getQueryResult() {
		return queryResult;
	}
	
}
