package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

public class ChaoUserCommentUpdateCondition {

	public Map<String,Object> toMap() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("status", status) ;
		return map ;
	}
	
	private String status ;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
