package com.doucome.chaoexpo.web.bops.action.ajax;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.UserStatusEnums;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class UserOperateAction extends BopsBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private String userName ;
	
	private String status ;
	
	@Autowired
	private ChaoUserService chaoUserService ;
	
	public String updateStatus() {
		
		if(StringUtils.isBlank(userName)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.user.updateStatus.userName.required") ;
			return SUCCESS ;
		}
		
		UserStatusEnums e = UserStatusEnums.toEnum(status) ;
		if(e == UserStatusEnums.UNKNOW) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.user.updateStatus.status.error") ;
			return SUCCESS ;
		}
		
		ChaoUserUpdateCondition update = new ChaoUserUpdateCondition() ;
		update.setStatus(status) ;
		
		int effectCount = chaoUserService.updateUserByUserName(userName, update); 
		
		if(effectCount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.user.updateStatus.effectCount.zero") ;
			return SUCCESS ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
