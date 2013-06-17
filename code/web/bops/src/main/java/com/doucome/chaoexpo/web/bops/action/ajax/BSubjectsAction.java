package com.doucome.chaoexpo.web.bops.action.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectSearchCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BSubjectsAction extends BopsBasicAction {
	
	private JsonModel<List<ChaoSubjectDTO>> json = new JsonModel<List<ChaoSubjectDTO>>();
	
	@Autowired
	private ChaoSubjectService chaoSubjectService;
	
	private String status;
	
	@Override
	public String execute() throws Exception {
		ChaoSubjectSearchCondition condtion = new ChaoSubjectSearchCondition();
		QueryResult<ChaoSubjectDTO> temps = chaoSubjectService.getSubjectsWithPagination(condtion, new Pagination(1, 100));
		json.setSuccess(temps.getItems());
		return SUCCESS ;
	}

	public JsonModel<List<ChaoSubjectDTO>> getJson() {
		return json;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
