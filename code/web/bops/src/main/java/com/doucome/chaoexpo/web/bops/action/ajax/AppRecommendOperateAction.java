package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoAppRecommendService;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 
 * @author langben 2013-6-19
 *
 */
public class AppRecommendOperateAction extends BopsBasicAction  {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id ;
	
	@Autowired
	private ChaoAppRecommendService chaoAppRecommendService ;
	
	public String delete() {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.appRecommend.delete.id.error") ;
			return SUCCESS ;
		}
		
		int effectCount = chaoAppRecommendService.deleteRecommendById(id) ;
		if(effectCount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.appRecommend.delete.effectCount.zero") ;
			return SUCCESS ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
