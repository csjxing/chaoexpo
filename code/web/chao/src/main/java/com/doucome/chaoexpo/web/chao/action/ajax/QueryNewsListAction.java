package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 新闻列表
 * @author langben 2013-6-2
 *
 */
public class QueryNewsListAction extends ChaoBasicAction {

	private ChaoNewsSearchCondition condition = new ChaoNewsSearchCondition() ;
	
	private JsonModel<QueryResult<ChaoNewsDTO>> json = new JsonModel<QueryResult<ChaoNewsDTO>>() ;
	
	private int page = 1;
	
	private int size = 20 ;
	
	@Autowired
	private ChaoNewsService chaoNewsService ;
	
	@Override
	public String execute() throws Exception {
		try {
			QueryResult<ChaoNewsDTO> result = chaoNewsService.getNewsSummarysWithPagination(condition, new Pagination(page, size)) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
			json.setData(result) ;
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		return SUCCESS ;
	}

	public JsonModel<QueryResult<ChaoNewsDTO>> getJson() {
		return json;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
