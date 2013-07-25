package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserCommentDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserCommentService;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserCommentQuery;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户
 * @author langben 2013-6-20
 *
 */
@SuppressWarnings("serial")
public class UserCommentListAction extends BopsBasicAction implements ModelDriven<ChaoUserCommentQuery> {

	private QueryResult<ChaoUserCommentDTO> queryResult ;
	
	@Autowired
	private ChaoUserCommentService chaoUserCommentService ;
	
	private int page ;
	
	private ChaoUserCommentQuery query = new ChaoUserCommentQuery() ;
	
	@Override
	public String execute() throws Exception {
		
		queryResult = chaoUserCommentService.getCommentsWithPagination(query , new Pagination(page)) ;
		
		return SUCCESS ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public QueryResult<ChaoUserCommentDTO> getQueryResult() {
		return queryResult;
	}

	@Override
	public ChaoUserCommentQuery getModel() {
		return query;
	}
	
}
