package com.doucome.chaoexpo.web.bops.action.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCatSearchCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class CategoriesAction extends BopsBasicAction {
	
	private JsonModel<List<ChaoNewsCategoryDTO>> json = new JsonModel<List<ChaoNewsCategoryDTO>>();
	
	@Autowired
	private ChaoNewsCategoryService chaoNewsCategoryService;
	
	@Override
	public String execute() throws Exception {
		ChaoNewsCatSearchCondition condition = new ChaoNewsCatSearchCondition();
		QueryResult<ChaoNewsCategoryDTO> temps = chaoNewsCategoryService.getCategoriesWithPagination(condition, new Pagination(1, 100));
		json.setSuccess(temps.getItems());
		return SUCCESS ;
	}

	public JsonModel<List<ChaoNewsCategoryDTO>> getJson() {
		return json;
	}
}
