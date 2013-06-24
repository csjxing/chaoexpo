package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ChaoNewsBO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 新闻列表
 * @author langben 2013-6-2
 *
 */
public class QueryNewsListAction extends ChaoBasicAction implements ModelDriven<ChaoNewsSearchCondition> {
	
	private static final long serialVersionUID = 1L;

	private ChaoNewsSearchCondition condition = new ChaoNewsSearchCondition() ;
	
	private JsonModel<QueryResult<ChaoNewsDTO>> json = new JsonModel<QueryResult<ChaoNewsDTO>>() ;
	
	private int page = 1;
	
	private int size = 20;
	
	@Autowired
	private ChaoNewsBO chaoNewsBO;
	
	@Override
	public String execute() throws Exception {
		condition.setStatus("N") ;
		ResultModel<QueryResult<ChaoNewsDTO>> result = chaoNewsBO.getNewsSummaryPage(condition, new Pagination(page, size));
		if (result.isSucc()) {
			json.setSuccess(result.getData());
		} else {
			json.setFail(result.getDetail());
		}
		return SUCCESS;
	}

	public JsonModel<QueryResult<ChaoNewsDTO>> getJson() {
		return json;
	}
	
	@Override
	public ChaoNewsSearchCondition getModel() {
		return condition;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
