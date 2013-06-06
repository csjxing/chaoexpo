package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCatSearchCondition;

@SuppressWarnings("serial")
public class NewsCategoryListAction extends BopsBasicAction {
	
	private QueryResult<ChaoNewsCategoryDTO> categoryResult;
	
	private int page;
	
	@Autowired
	private ChaoNewsCategoryService chaoNewsCategoryService;
	
	@Override
	public String execute() throws Exception {
		ChaoNewsCatSearchCondition condition = new ChaoNewsCatSearchCondition();
		categoryResult = chaoNewsCategoryService.getCategoriesWithPagination(condition, new Pagination(page, 20));
		return SUCCESS ;
	}
	
	public QueryResult<ChaoNewsCategoryDTO> getCategoryResult() {
		return categoryResult;
	}
	
	public void setPage(Integer page) {
		this.page = page == null? 1: page;
	}
}
