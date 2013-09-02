package com.doucome.chaoexpo.web.chao.action.ajax;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoBannerDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoBannerService;
import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 加载banner
 * @author langben 2013-9-2
 *
 */
public class QueryBannerAction extends ChaoBasicAction {

	private JsonModel<List<ChaoBannerDTO>> json = new JsonModel<List<ChaoBannerDTO>>() ;
	
	private String banners ;
	
	@Autowired
	private ChaoBannerService chaoBannerService ;
	
	@Override
	public String execute() throws Exception {
		
		if(StringUtils.isEmpty(banners)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.banner.query.bannerId.required") ;
			return SUCCESS ;
		}
		
		String[] bannerIds = ArrayStringUtils.toArray(banners) ;
		
		List<ChaoBannerDTO> banners = chaoBannerService.getBannerByBannerIds(bannerIds) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		json.setData(banners) ;
		
		return SUCCESS ;
	}

	public JsonModel<List<ChaoBannerDTO>> getJson() {
		return json;
	}

	public void setBanners(String banners) {
		this.banners = banners;
	}
}
