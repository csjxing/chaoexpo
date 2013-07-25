package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户
 * @author langben 2013-6-20
 *
 */
@SuppressWarnings("serial")
public class UserFollowListAction extends BopsBasicAction implements ModelDriven<ChaoUserFollowQuery> {

	private QueryResult<ChaoUserFollowDTO> queryResult ;
	
	@Autowired
	private ChaoUserFollowService chaoUserFollowService ;
	
	private int page ;
	
	private ChaoUserFollowQuery query = new ChaoUserFollowQuery() ;
	
	@Override
	public String execute() throws Exception {
		
		queryResult = chaoUserFollowService.getFollowsWithPagination(query , new Pagination(page)) ;
		
		return SUCCESS ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public QueryResult<ChaoUserFollowDTO> getQueryResult() {
		return queryResult;
	}

	@Override
	public ChaoUserFollowQuery getModel() {
		return query;
	}
	
}
