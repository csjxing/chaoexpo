package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

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
		return new PicModel(getLogoUrl()) ;
	}
	
	/**
	 * ---------------------------------------------------------------------------
	 */
	
	public Long getId() {
		return recommend.getId();
	}

	public String getName() {
		return recommend.getName();
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
