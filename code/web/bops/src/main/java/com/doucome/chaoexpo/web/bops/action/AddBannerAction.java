package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoBannerDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoBannerService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddBannerAction extends BopsBasicAction implements ModelDriven<ChaoBannerDTO> {
	
	private ChaoBannerDTO banner = new ChaoBannerDTO();
	
	@Autowired
	private ChaoBannerService chaoBannerService;
	
	@Override
	public String execute() throws Exception {
		if (banner.getId() == null) {
			chaoBannerService.createBanner(banner);
		} else {
			chaoBannerService.updateBanner(banner.getId(), banner);
		}
		
		return SUCCESS;
	}
	
	public ChaoBannerDTO getModel() {
		return banner;
	}
}
