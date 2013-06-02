package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivitySearchCondition;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActivityListAction extends BopsBasicAction implements ModelDriven<ChaoActivitySearchCondition> {
	
	private QueryResult<ChaoActivityDTO> activityResult;
	
	private ChaoActivitySearchCondition condition = new ChaoActivitySearchCondition();
	
	@Autowired
	private ChaoActivityService chaoActivityService;
	
	private int page;
	
	@Override
	public String execute() throws Exception {
		activityResult = chaoActivityService.getActivityWithPagination(condition, new Pagination(page));
		return SUCCESS ;
	}
	
	public QueryResult<ChaoActivityDTO> getActivityResult() {
		return activityResult;
	}
	
	public ChaoActivitySearchCondition getModel() {
		return condition;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
