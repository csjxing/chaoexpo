package com.doucome.chaoexpo.web.chao.action.user.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.bo.ChaoUserBO;
import com.doucome.chaoexpo.biz.core.exception.ChaoUserFollowException;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 关注
 * @author langben 2013-5-28
 *
 */
public class AddUserFollowAction extends ChaoBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	private Long id ;
	
	@Autowired
	private ChaoUserBO chaoUserBO ;
	
	
	public String followActivity() {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.follow.id.required") ;
			return SUCCESS ;
		}
		
		String userName = chaoAuthz.getUserName() ;
		//用户是否登陆
		if(StringUtils.isBlank(userName)){
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.follow.user.required") ;
			return SUCCESS ;
		}
		
		//活动是否存在
		try {
			chaoUserBO.followActivity(userName, id) ;
		} catch (ChaoUserFollowException e) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail(e.getMessage()) ;
			return SUCCESS ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		return SUCCESS ;
	}
	
	public String followSubjectt() {
		return SUCCESS ;
	}
	
	public String followTenant() {
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
