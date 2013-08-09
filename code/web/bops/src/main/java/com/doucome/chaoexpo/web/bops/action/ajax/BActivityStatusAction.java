package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoActivityStatusEnum;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BActivityStatusAction extends BopsBasicAction {
	
	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id;
	
	private String status;
	
	@Autowired
	private ChaoActivityService chaoActivityService;
	
	public String execute() {
		ChaoActivityStatusEnum statusEnum = ChaoActivityStatusEnum.toEnum(status);
		if (IDUtils.isNotCorrect(id) || statusEnum == ChaoActivityStatusEnum.UNKNOW) {
			json.setFail("param.error");
			return SUCCESS;
		}
		ChaoActivityUpdateCondition condition = new ChaoActivityUpdateCondition();
		condition.setStatus(status);
		chaoActivityService.updateActivityById(id, condition);
		json.setSuccess(true);
		return SUCCESS;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}
}
