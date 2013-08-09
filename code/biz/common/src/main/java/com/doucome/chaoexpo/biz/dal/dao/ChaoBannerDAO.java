package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoBannerCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoBannerDO;

/**
 * 活动
 * @author langben 2013-5-21
 *
 */
public interface ChaoBannerDAO{

	/**
	 * 
	 * @param activity
	 * @return
	 */
	Long insertBanner(ChaoBannerDO banner);
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoBannerDO queryBanner(Long id) ;
	/**
	 * 
	 * @param bannerId
	 * @return
	 */
	ChaoBannerDO queryBanner(String bannerId);
	
	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoBannerDO> queryBannerPage(ChaoBannerCondition condition, int start, int size);
	/**
	 * 
	 * @param condition
	 * @return
	 */
	int countBanners(ChaoBannerCondition condition);
	/**
	 * 
	 * @param id
	 * @param banner
	 * @return
	 */
	int updateBanner(ChaoBannerDO banner);
}
