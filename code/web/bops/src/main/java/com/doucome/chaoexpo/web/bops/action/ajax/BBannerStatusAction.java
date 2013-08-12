package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoBannerStatusEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoBannerDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoBannerService;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BBannerStatusAction extends BopsBasicAction {
	
	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id;
	
	private String status;
	
	@Autowired
	private ChaoBannerService chaoBannerService;
	
	public String execute() {
		ChaoBannerStatusEnum statusEnum = ChaoBannerStatusEnum.toEnum(status);
		if (IDUtils.isNotCorrect(id) || statusEnum == ChaoBannerStatusEnum.UNKNOW) {
			json.setFail("param.error");
			return SUCCESS;
		}
		ChaoBannerDTO banner = new ChaoBannerDTO();
		banner.setStatus(status);
		chaoBannerService.updateBanner(id, banner);
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
