package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.TrueOrFalseEnums;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class ActivityOperateAction  extends BopsBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id;
	
	private String top;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	public String updateTop() throws Exception {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.top.id.required") ;
			return SUCCESS ;
		}
		
		TrueOrFalseEnums tof = TrueOrFalseEnums.toEnum(top) ;
		
		if(tof == TrueOrFalseEnums.UNKNOWN) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.top.set.error") ;
			return SUCCESS ;
		}
		
		ChaoActivityUpdateCondition update = new ChaoActivityUpdateCondition() ;
		update.setIsTop(tof.getValue()) ;
		
		int eff = chaoActivityService.updateActivityById(id, update) ;
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTop(String top) {
		this.top = top;
	}
	
	
}
