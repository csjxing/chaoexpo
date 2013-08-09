package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoBannerDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoBannerService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoBannerCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoBannerDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoBannerDO;

/**
 * 
 * @author langben 2013-5-21
 *
 */
public class ChaoBannerServiceImpl implements ChaoBannerService {

	@Autowired
	private ChaoBannerDAO chaoBannerDAO ;
	
	@Override
	public Long createBanner(ChaoBannerDTO banner) {
		if (banner == null) {
			return 0l;
		}
		return chaoBannerDAO.insertBanner(banner.toDO());
	}

	@Override
	public ChaoBannerDTO getBanner(Long id) {
		if (IDUtils.isNotCorrect(id)) {
			return null;
		}
		ChaoBannerDO banner = chaoBannerDAO.queryBanner(id);
		if (banner == null) {
			return null;
		}
		return new ChaoBannerDTO(banner);
	}

	@Override
	public ChaoBannerDTO getBanner(String bannerId) {
		if (StringUtils.isEmpty(bannerId)) {
			return null;
		}
		ChaoBannerDO banner = chaoBannerDAO.queryBanner(bannerId);
		if (banner == null) {
			return null;
		}
		return new ChaoBannerDTO(banner);
	}
	
	@Override
	public QueryResult<ChaoBannerDTO> getBannerPage(ChaoBannerCondition condition, Pagination page) {
		if (condition == null || page == null) {
			return new QueryResult<ChaoBannerDTO>(new ArrayList<ChaoBannerDTO>(), page, 0);
		}
		int count = chaoBannerDAO.countBanners(condition);
		if (count == 0) {
		    return new QueryResult<ChaoBannerDTO>(new ArrayList<ChaoBannerDTO>(), page, 0);
		}
		List<ChaoBannerDO> banners = chaoBannerDAO.queryBannerPage(condition, page.getStart() - 1, page.getSize());
		return new QueryResult<ChaoBannerDTO>(convert(banners), page, count);
	}


	@Override
	public int updateBanner(Long id, ChaoBannerDTO banner) {
		if (IDUtils.isNotCorrect(id) || banner == null) {
			return 0;
		}
		banner.setId(id);
		return chaoBannerDAO.updateBanner(banner.toDO());
	}
	
	private List<ChaoBannerDTO> convert(List<ChaoBannerDO> banners) {
		List<ChaoBannerDTO> result = new ArrayList<ChaoBannerDTO>() ;
        if(CollectionUtils.isNotEmpty(banners)){
        	for(ChaoBannerDO banner : banners) {
        		result.add(new ChaoBannerDTO(banner));
        	}
        }
        return result;
	}
}
