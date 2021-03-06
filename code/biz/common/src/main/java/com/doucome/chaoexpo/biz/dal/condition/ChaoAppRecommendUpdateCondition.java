package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.common.utils.ReflectUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoAppRecommendUpdateCondition extends AbstractModel {
	
	private String appName ;
	
	private String logoUrl ;
	
	private String intro ;
	
	private String androidStoreUrl ;
	
	private String iosStoreUrl ;
	
	private String wpStoreUrl ;
	
	public Map<String,Object> toMap() {
		
		Map<String,Object> map = new HashMap<String,Object>() ;
		
		map.put("appName", appName) ;
		map.put("logoUrl", logoUrl) ;
		map.put("intro", intro) ;
		map.put("androidStoreUrl", androidStoreUrl) ;
		map.put("iosStoreUrl", iosStoreUrl) ;
		map.put("wpStoreUrl", wpStoreUrl) ;

		return map ;
	}
	
	public static ChaoAppRecommendUpdateCondition fromAppRecommend(ChaoAppRecommendDO recommend) {
		ChaoAppRecommendUpdateCondition condition = new ChaoAppRecommendUpdateCondition() ;
		ReflectUtils.reflectTo(recommend, condition) ;
		return condition ;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAndroidStoreUrl() {
		return androidStoreUrl;
	}

	public void setAndroidStoreUrl(String androidStoreUrl) {
		this.androidStoreUrl = androidStoreUrl;
	}

	public String getIosStoreUrl() {
		return iosStoreUrl;
	}

	public void setIosStoreUrl(String iosStoreUrl) {
		this.iosStoreUrl = iosStoreUrl;
	}

	public String getWpStoreUrl() {
		return wpStoreUrl;
	}

	public void setWpStoreUrl(String wpStoreUrl) {
		this.wpStoreUrl = wpStoreUrl;
	}
	
}
