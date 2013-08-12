package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoSubjectStatusEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BSubjectStatusAction extends BopsBasicAction {
	
	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id;
	
	private String status;
	
	@Autowired
	private ChaoSubjectService chaoSubjectService;
	
	public String execute() {
		ChaoSubjectStatusEnum statusEnum = ChaoSubjectStatusEnum.toEnum(status);
		if (IDUtils.isNotCorrect(id) || statusEnum == ChaoSubjectStatusEnum.UNKNOW) {
			json.setFail("param.error");
			return SUCCESS;
		}
		ChaoSubjectDTO subject = new ChaoSubjectDTO();
		subject.setId(id);
		subject.setStatus(status);
		chaoSubjectService.updateSubject(subject);
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
