package com.doucome.chaoexpo.web.chao.action.user.ajax;

import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class LoginAjaxAction extends ChaoBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	@Override
	public String execute() throws Exception {
		json.setCode(JsonModel.CODE_AUTH_FAIL) ;
		json.setDetail("chao.user.login.fail") ;
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}
	 
}
