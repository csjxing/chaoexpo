package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoCultureDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCultureService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureQuery;

/**
 * 周边文化
 * @author langben 2013-6-20
 *
 */
public class CultureListAction extends BopsBasicAction {

	private QueryResult<ChaoCultureDTO> queryResult ;
	
	@Autowired
	private ChaoCultureService chaoCultureService ;
	
	private int page ;
	
	@Override
	public String execute() throws Exception {
		
		queryResult = chaoCultureService.getCulturesWithPagination(new ChaoCultureQuery(),new Pagination(page)) ;
		
		return SUCCESS ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public QueryResult<ChaoCultureDTO> getQueryResult() {
		return queryResult;
	}
	
}
