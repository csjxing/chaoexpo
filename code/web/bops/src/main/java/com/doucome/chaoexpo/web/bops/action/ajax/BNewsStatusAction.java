package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoNewsStatusEnum;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BNewsStatusAction extends BopsBasicAction {
	
	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id;
	
	private String status;
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	
	public String execute() {
		ChaoNewsStatusEnum statusEnum = ChaoNewsStatusEnum.toEnum(status);
		if (IDUtils.isNotCorrect(id) || statusEnum == ChaoNewsStatusEnum.UNKNOW) {
			json.setFail("param.error");
			return SUCCESS;
		}
		ChaoNewsUpdateCondition condition = new ChaoNewsUpdateCondition();
		condition.setStatus(status);
		chaoNewsService.updateNewsById(id, condition);
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
