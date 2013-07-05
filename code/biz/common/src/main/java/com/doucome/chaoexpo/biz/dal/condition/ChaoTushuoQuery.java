package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoTushuoQuery extends AbstractModel {

	private String status ;
	
	private String category ;
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("status", status) ;
		map.put("category", category) ;
		return map ;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
