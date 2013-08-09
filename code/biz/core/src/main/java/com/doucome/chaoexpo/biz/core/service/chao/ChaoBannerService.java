package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoBannerDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoBannerCondition;

/**
 * 活动
 * @author langben 2013-5-21
 *
 */
public interface ChaoBannerService {
	/**
	 * 
	 * @param activity
	 * @return
	 */
	Long createBanner(ChaoBannerDTO banner) ;
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoBannerDTO getBanner(Long id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoBannerDTO getBanner(String bannerId);
	/**
	 * 
	 * @param condition
	 * @param page
	 * @return
	 */
	QueryResult<ChaoBannerDTO> getBannerPage(ChaoBannerCondition condition, Pagination page);
	/**
	 * 
	 * @param id
	 * @param banner
	 * @return
	 */
	int updateBanner(Long id, ChaoBannerDTO banner);
}
