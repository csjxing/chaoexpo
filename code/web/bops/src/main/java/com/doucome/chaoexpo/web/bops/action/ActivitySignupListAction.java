package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoActivitySignupDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivitySignupService;
import com.doucome.chaoexpo.biz.dal.query.ChaoActivitySignupQuery;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ActivitySignupListAction extends BopsBasicAction implements ModelDriven<ChaoActivitySignupQuery> {
	
	private QueryResult<ChaoActivitySignupDTO> signupResult;
	
	private ChaoActivitySignupQuery condition = new ChaoActivitySignupQuery();
	
	@Autowired
	private ChaoActivitySignupService chaoActivitySignupService;
	
	private int page;
	
	@Override
	public String execute() throws Exception {
		signupResult = chaoActivitySignupService.getActivitySignupWithPagination(condition, new Pagination(page));
		return SUCCESS ;
	}
	
	public QueryResult<ChaoActivitySignupDTO> getSignupResult() {
		return signupResult;
	}
	
	public ChaoActivitySignupQuery getModel() {
		return condition;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
