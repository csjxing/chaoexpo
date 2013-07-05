package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class TushuoCateOperateAction extends BopsBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	public String delete() {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuoCate.delete.id.error") ;
			return SUCCESS ;
		}
		
		int effectCount = chaoTushuoCategoryService.deleteCategoryById(id) ;
		
		if(effectCount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuoCate.delete.effectCount.zero") ;
			return SUCCESS ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

}
