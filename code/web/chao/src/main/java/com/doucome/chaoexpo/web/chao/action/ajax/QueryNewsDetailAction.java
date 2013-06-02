package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 新闻详情
 * @author langben 2013-5-21
 *
 */
public class QueryNewsDetailAction extends ChaoBasicAction {

	private JsonModel<ChaoNewsDTO> json = new JsonModel<ChaoNewsDTO>() ;
	
	private Long id ;
	
	@Autowired
	private ChaoNewsService chaoNewsService ;
	
	@Override
	public String execute() throws Exception {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.news.query.id.required") ;
			return SUCCESS ;
		}
		
		try {
			ChaoNewsDTO news = chaoNewsService.getNewsById(id) ;
			
			if(news == null) {
				json.setCode(JsonModel.CODE_ILL_ARGS) ;
				json.setDetail("chao.news.query.news.notExists") ;
				return SUCCESS ;
			}
						
			json.setCode(JsonModel.CODE_SUCCESS) ;
			json.setData(news) ;
			
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}

	
	public JsonModel<ChaoNewsDTO> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
