package com.doucome.chaoexpo.web.chao.action.user.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class MyAction extends ChaoBasicAction {

	@Autowired
	private ChaoUserService chaoUserService ;
	
	private JsonModel<ChaoUserDTO> json = new JsonModel<ChaoUserDTO>() ;
	
	
	@Override
	public String execute() throws Exception {
		
		String userName = chaoAuthz.getUserName() ;
		
		ChaoUserDTO user = chaoUserService.getUserByUserName(userName) ;
		
		json.setData(user) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}


	public JsonModel<ChaoUserDTO> getJson() {
		return json;
	}

}
