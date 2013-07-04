package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.common.utils.ReflectUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;

public class ChaoTushuoUpdateCondition {

	private String name ;
	
	private String picUrls ;
	
	private String content ;
	
	private String category ;
	
	public static ChaoTushuoUpdateCondition fromTushuo(ChaoTushuoDO tushuo){
		ChaoTushuoUpdateCondition condition = new ChaoTushuoUpdateCondition() ;
		ReflectUtils.reflectTo(tushuo, condition) ;
		return condition;
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("name", name) ;
		map.put("picUrls", picUrls) ;
		map.put("content", content) ;
		map.put("category", category) ;
		return map ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String picUrls) {
		this.picUrls = picUrls;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
