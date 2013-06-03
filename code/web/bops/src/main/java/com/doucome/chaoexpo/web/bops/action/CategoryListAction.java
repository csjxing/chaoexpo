package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCategoryService;

@SuppressWarnings("serial")
public class CategoryListAction extends BopsBasicAction {
	
	private QueryResult<ChaoCategoryDTO> categoryResult;
	
	private String status;
	
	private int page;
	
	@Autowired
	private ChaoCategoryService chaoCategoryService;
	
	@Override
	public String execute() throws Exception {
		categoryResult = chaoCategoryService.getCategoryPage(status, new Pagination(page, 20));
		return SUCCESS ;
	}
	
	public QueryResult<ChaoCategoryDTO> getCategoryResult() {
		return categoryResult;
	}
	
	public void setPage(Integer page) {
		this.page = page == null? 1: page;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
