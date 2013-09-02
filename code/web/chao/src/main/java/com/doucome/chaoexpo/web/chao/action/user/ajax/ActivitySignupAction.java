package com.doucome.chaoexpo.web.chao.action.user.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.bo.ChaoUserBO;
import com.doucome.chaoexpo.biz.core.exception.ChaoActivitySignupException;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 活动报名
 * @author langben 2013-9-2
 *
 */
public class ActivitySignupAction extends ChaoBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	private Long activityId ;
	
	private String contactName ;
	
	private String contactPhone ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Autowired
	private ChaoUserBO chaoUserBO ;
	
	@Override
	public String execute() throws Exception {
		
		String userName = chaoAuthz.getUserName() ;
		
		if(IDUtils.isNotCorrect(activityId)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.signup.act.required") ;
			return SUCCESS ;
		}
		
		if(StringUtils.isBlank(contactName) || StringUtils.isBlank(contactPhone)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.signup.contact.required") ;
			return SUCCESS ;
		}
		
		ChaoActivityDTO act = chaoActivityService.getActivityById(activityId) ;
		
		try {
			chaoUserBO.signupActivity(act, userName, contactName, contactPhone) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
		} catch (ChaoActivitySignupException e) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail(e.getMessage()) ;
			return SUCCESS ;
		}

		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
}
