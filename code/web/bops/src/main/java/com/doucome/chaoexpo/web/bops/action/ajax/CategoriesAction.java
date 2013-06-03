package com.doucome.chaoexpo.web.bops.action.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCategoryService;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class CategoriesAction extends BopsBasicAction {
	
	private JsonModel<List<ChaoCategoryDTO>> result = new JsonModel<List<ChaoCategoryDTO>>();
	
	private String status;
	
	@Autowired
	private ChaoCategoryService chaoCategoryService;
	
	@Override
	public String execute() throws Exception {
		QueryResult<ChaoCategoryDTO> temps = chaoCategoryService.getCategoryPage(status, new Pagination(1, 100));
		result.setSuccess(temps.getItems());
		return SUCCESS ;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
