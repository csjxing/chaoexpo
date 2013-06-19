package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoAboutDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoAppRecommendService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 关于
 * @author langben 2013-6-19
 *
 */
public class AboutAction extends ChaoBasicAction {

	private JsonModel<ChaoAboutDTO> json = new JsonModel<ChaoAboutDTO>() ;
	
	@Autowired
	private ChaoAppRecommendService chaoAppRecommendService ;
		
	@Override
	public String execute() throws Exception {
		
		ChaoAboutDTO about = new ChaoAboutDTO() ;
		ChaoAppRecommendQuery query = new ChaoAppRecommendQuery() ;
		QueryResult<ChaoAppRecommendDTO> result = chaoAppRecommendService.getRecommendWithPagination(query, new Pagination(1)) ;
		about.setAppRecommendList(result.getItems()) ;
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		json.setData(about) ;
		
		return SUCCESS ;
	}

	public JsonModel<ChaoAboutDTO> getJson() {
		return json;
	}
	
}
