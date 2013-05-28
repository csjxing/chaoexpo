package com.doucome.chaoexpo.web.chao.action.user.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ChaoUserBO;
import com.doucome.chaoexpo.biz.core.exception.ChaoDuplicateKeyException;
import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 注册接口
 * @author langben 2013-5-27
 *
 */
public class RegisterUserAction extends ChaoBasicAction {

	private JsonModel<ChaoUserDTO> json = new JsonModel<ChaoUserDTO>() ;
	
	@Autowired
	private ChaoUserBO chaoUserBO ;
	
	@Override
	public String execute() throws Exception {
		ChaoUserDTO user = null ;
		try {
			user = chaoUserBO.register() ;
		} catch (ChaoDuplicateKeyException e) {
			user = chaoUserBO.register();
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
			return SUCCESS ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		json.setData(user) ;
		
		return SUCCESS ;
	}

	public JsonModel<ChaoUserDTO> getJson() {
		return json;
	}
	
	
}
