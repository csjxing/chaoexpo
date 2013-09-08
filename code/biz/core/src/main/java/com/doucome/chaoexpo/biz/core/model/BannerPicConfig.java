package com.doucome.chaoexpo.biz.core.model;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 
 * @author ze2200
 *
 */
public class BannerPicConfig extends AbstractModel {
	
	private static final long serialVersionUID = 1L;

	private String picPath;
	
	private String name;
	
	private String clickUrl;

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClickUrl() {
		return clickUrl;
	}

	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl == null? null: clickUrl.toLowerCase().trim();
	}
}
