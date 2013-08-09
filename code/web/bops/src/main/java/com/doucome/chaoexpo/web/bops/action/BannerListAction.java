package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoBannerDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoBannerService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoBannerCondition;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class BannerListAction extends BopsBasicAction implements ModelDriven<ChaoBannerCondition> {
	
	private ChaoBannerCondition condition = new ChaoBannerCondition();
	
	private QueryResult<ChaoBannerDTO> bannerResult;
	
	private Integer page = 1;
	
	@Autowired
	private ChaoBannerService chaoBannerService;
	
	@Override
	public String execute() throws Exception {
		bannerResult = chaoBannerService.getBannerPage(condition, new Pagination(page));
		return SUCCESS ;
	}
	
	public QueryResult<ChaoBannerDTO> getBannerResult() {
		return bannerResult;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public ChaoBannerCondition getModel() {
		return condition;
	}
}
