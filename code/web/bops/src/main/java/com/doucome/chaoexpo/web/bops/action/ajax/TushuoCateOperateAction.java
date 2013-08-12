package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.TushuoCateStatusEnums;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoCateUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class TushuoCateOperateAction extends BopsBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id ;
	
	private String status ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	public String updateStatus() {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuoCate.update.id.error") ;
			return SUCCESS ;
		}
		
		TushuoCateStatusEnums e = TushuoCateStatusEnums.toEnum(status) ;
		if(e == TushuoCateStatusEnums.UNKNOW) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuoCate.updateStatus.status.error") ;
			return SUCCESS ;
		}
		
		ChaoTushuoCateUpdateCondition update = new ChaoTushuoCateUpdateCondition() ;
		update.setStatus(status) ;
		int effectCount = chaoTushuoCategoryService.updateCategoryById(id, update) ;
		
		if(effectCount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuoCate.updateStatus.effectCount.zero") ;
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

	public void setStatus(String status) {
		this.status = status;
	}

}
