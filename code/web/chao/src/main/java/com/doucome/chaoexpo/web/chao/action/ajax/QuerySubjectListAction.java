package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.biz.dal.query.ChaoSubjectQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class QuerySubjectListAction extends ChaoBasicAction {
	
	private JsonModel<QueryResult<ChaoSubjectDTO>> json = new JsonModel<QueryResult<ChaoSubjectDTO>>() ;
 
	@Autowired
	private ChaoSubjectService chaoSubjectService ;
	
	private int page = 1;
	
	@Override
	public String execute() throws Exception {
		ChaoSubjectQuery query = new ChaoSubjectQuery() ;
		QueryResult<ChaoSubjectDTO> result = chaoSubjectService.getSubjectsWithPagination(query, new Pagination(page)) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		json.setData(result) ;
		return SUCCESS ;
	}

	public JsonModel<QueryResult<ChaoSubjectDTO>> getJson() {
		return json;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
