package com.doucome.chaoexpo.web.chao.action.ajax;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.BannerStatusEnums;
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

	private JsonModel<Map<String,ChaoBannerDTO>> json = new JsonModel<Map<String,ChaoBannerDTO>>() ;
	
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
		
		for(Iterator<ChaoBannerDTO> i = banners.iterator() ; i.hasNext() ;) {
			ChaoBannerDTO banner = i.next() ;
			if(BannerStatusEnums.toEnum(banner.getStatus()) != BannerStatusEnums.NORMAL) {
				i.remove() ;
			}
		}
		
		Map<String,ChaoBannerDTO> map = convert2Map(banners) ;
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		json.setData(map) ;
		
		return SUCCESS ;
	}
	
	private Map<String,ChaoBannerDTO> convert2Map(List<ChaoBannerDTO> banners) {
		Map<String,ChaoBannerDTO> bannerMap = new HashMap<String,ChaoBannerDTO>() ;
		if(CollectionUtils.isNotEmpty(banners)) {
			for(ChaoBannerDTO dto : banners) {
				bannerMap.put(dto.getBannerId(), dto) ;
			}
		}
		return bannerMap ;
	}

	public JsonModel<Map<String,ChaoBannerDTO>> getJson() {
		return json;
	}

	public void setBanners(String banners) {
		this.banners = banners;
	}
}
