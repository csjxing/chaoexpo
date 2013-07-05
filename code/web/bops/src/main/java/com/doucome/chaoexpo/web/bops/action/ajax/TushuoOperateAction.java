package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.TushuoStatusEnums;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class TushuoOperateAction extends BopsBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id ;
	
	private String status ;
	
	@Autowired
	private ChaoTushuoService chaoTushuoService ;
	
	public String updateStatus() {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuo.updateStatus.id.error") ;
			return SUCCESS ;
		}
		
		TushuoStatusEnums e = TushuoStatusEnums.toEnum(status) ;
		if(e == TushuoStatusEnums.UNKNOW) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuo.updateStatus.status.error") ;
			return SUCCESS ;
		}
		
		ChaoTushuoUpdateCondition condition = new ChaoTushuoUpdateCondition() ;
		condition.setStatus(status) ;
		
		int effectCount = chaoTushuoService.updateTushuoById(id, condition) ;
		
		if(effectCount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.tushuo.updateStatus.effectCount.zero") ;
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
