package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoNewsStatusEnum;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BCategoryStatusAction extends BopsBasicAction {
	
	private JsonModel<Integer> json = new JsonModel<Integer>();
	
	@Autowired
	private ChaoNewsCategoryService chaoNewsCategoryService;
	
	private Long id;
	
	private String status;
	
	@Override
	public String execute() throws Exception {
		ChaoNewsStatusEnum statusEnum = ChaoNewsStatusEnum.toEnum(status);
		if (IDUtils.isNotCorrect(id) || statusEnum == ChaoNewsStatusEnum.UNKNOW) {
			json.setFail("param.error");
		}
		int count = chaoNewsCategoryService.updateStstus(id, statusEnum);
		if (count > 0) {
			json.setSuccess(count);
		} else {
			json.setFail("category.not.exist");
		}
		return SUCCESS;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public JsonModel<Integer> getJson() {
		return json;
	}
}
