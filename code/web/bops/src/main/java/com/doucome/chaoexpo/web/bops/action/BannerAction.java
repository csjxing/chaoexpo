package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoBannerDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoBannerService;

@SuppressWarnings("serial")
public class BannerAction extends BopsBasicAction {
	
	private ChaoBannerDTO banner;
	
	private Long id;
	
	@Autowired
	private ChaoBannerService chaoBannerService;
	
	@Override
	public String execute() throws Exception {
		if (IDUtils.isCorrect(id)) {
			banner = chaoBannerService.getBanner(id);
		}
		return SUCCESS ;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ChaoBannerDTO getBanner() {
		return banner;
	}
}
