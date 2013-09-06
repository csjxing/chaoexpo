package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.YesNoEnum;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BActivityCanSignupAction extends BopsBasicAction {
	
	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id;
	
	private String canSignup;
	
	@Autowired
	private ChaoActivityService chaoActivityService;
	
	public String execute() {
		YesNoEnum tempEnum = YesNoEnum.toEnum(canSignup);
		if (IDUtils.isNotCorrect(id) || tempEnum == YesNoEnum.UNKNOWN) {
			json.setFail("param.error");
			return SUCCESS;
		}
		ChaoActivityUpdateCondition condition = new ChaoActivityUpdateCondition();
		condition.setCanSignup(canSignup);
		chaoActivityService.updateActivityById(id, condition);
		json.setSuccess(true);
		return SUCCESS;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setCanSignup(String canSignup) {
		this.canSignup = canSignup;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}
}
