package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class NewsListAction extends BopsBasicAction implements ModelDriven<ChaoNewsCondition> {
	
	private QueryResult<ChaoNewsDTO> newsResult;
	
	private ChaoNewsCondition condition = new ChaoNewsCondition();
	
	private int page;
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	
	@Override
	public String execute() throws Exception {
		
		newsResult = chaoNewsService.getNewsPage(condition, new Pagination(page, 20));
		
		return SUCCESS ;
	}
	
	public QueryResult<ChaoNewsDTO> getNewsResult() {
		return newsResult;
	}
	
	public ChaoNewsCondition getModel() {
		return condition;
	}
	
	public void setPage(Integer page) {
		this.page = page == null? 1: page;
	}
}
