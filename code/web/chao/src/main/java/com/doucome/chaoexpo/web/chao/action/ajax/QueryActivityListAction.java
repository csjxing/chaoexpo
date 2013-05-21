package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivitySearchCondition;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 活动列表
 * @author langben 2013-5-21
 *
 */
public class QueryActivityListAction extends ChaoBasicAction implements ModelDriven<ChaoActivitySearchCondition>{

	private ChaoActivitySearchCondition condition = new ChaoActivitySearchCondition() ;
	
	private JsonModel<QueryResult<ChaoActivityDTO>> json = new JsonModel<QueryResult<ChaoActivityDTO>>() ;
	
	private int page = 1;
	
	private int size = 20 ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Override
	public String execute() throws Exception {
		try {
			QueryResult<ChaoActivityDTO> result = chaoActivityService.getActivityWithPagination(condition, new Pagination(page,size));
			json.setCode(JsonModel.CODE_SUCCESS) ;
			json.setData(result) ;
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}

	@Override
	public ChaoActivitySearchCondition getModel() {
		return condition ;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public JsonModel<QueryResult<ChaoActivityDTO>> getJson() {
		return json;
	}

}
