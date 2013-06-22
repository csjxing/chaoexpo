package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserQuery;
import com.opensymphony.xwork2.ModelDriven;

public class UserListAction extends BopsBasicAction implements ModelDriven<ChaoUserQuery>{

	private ChaoUserQuery query = new ChaoUserQuery() ;
	
	@Autowired
	private ChaoUserService chaoUserService ;
	
	
	private QueryResult<ChaoUserDTO> queryResult ;
	
	private int page ;
	
	@Override
	public String execute() throws Exception {
		
		queryResult = chaoUserService.getUsersWithPagination(query, new Pagination(page)) ;
		
		return SUCCESS ;
	}

	@Override
	public ChaoUserQuery getModel() {
		return query ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public QueryResult<ChaoUserDTO> getQueryResult() {
		return queryResult;
	}
	
}
