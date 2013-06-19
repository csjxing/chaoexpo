package com.doucome.chaoexpo.biz.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoAppRecommendDTO extends AbstractModel {

	private ChaoAppRecommendDO recommend ;
	
	public ChaoAppRecommendDTO(ChaoAppRecommendDO recommend) {
		if(recommend == null) {
			recommend = new ChaoAppRecommendDO() ;
		}
		this.recommend = recommend ;
	}
	
	public PicModel getLogoUrlModel() {
		List<String> picList = ArrayStringUtils.toList(getLogoUrl()) ;
		if(CollectionUtils.isEmpty(picList)) {
			return null ;
		}
		return new PicModel(picList.get(0)) ;
	}
	
	
	/**
	 * ---------------------------------------------------------------------------
	 */
	
	public Long getId() {
		return recommend.getId();
	}

	public String getAppName() {
		return recommend.getAppName();
	}

	public String getLogoUrl() {
		return recommend.getLogoUrl();
	}

	public String getIntro() {
		return recommend.getIntro();
	}


	public String getAppStoreUrl() {
		return recommend.getAppStoreUrl();
	}


	public Date getGmtCreate() {
		return recommend.getGmtCreate();
	}

	public Date getGmtModified() {
		return recommend.getGmtModified();
	}
	
}
