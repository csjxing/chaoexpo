package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.common.utils.ReflectUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;

public class ChaoTushuoCateUpdateCondition {
	
	private String picUrls ;
	
	private String intro ;
	
	public static ChaoTushuoCateUpdateCondition fromCate(ChaoTushuoCategoryDO cate){
		ChaoTushuoCateUpdateCondition condition = new ChaoTushuoCateUpdateCondition() ;
		ReflectUtils.reflectTo(cate, condition) ;
		return condition;
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("picUrls", picUrls) ;
		map.put("intro", intro) ;
		return map ;
	}

	public String getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String picUrls) {
		this.picUrls = picUrls;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
