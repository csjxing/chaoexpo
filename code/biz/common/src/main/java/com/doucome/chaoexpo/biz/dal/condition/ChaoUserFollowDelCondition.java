package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoUserFollowDelCondition extends AbstractModel {
	
	/**
	 * 类型
	 */
	private String type ;
	
	/**
	 * 活动ID
	 */
	private Long activityId ;
	
	/**
	 * 专题
	 */
	private Long subjectId ;
	
	/**
	 * 商户
	 */
	private Long tenantId ;
	
	public Map<String,Object> toMap() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("type", type) ;
		map.put("activityId", activityId) ;
		map.put("subjectId", subjectId) ;
		map.put("tenantId", tenantId) ;
		return map ;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	
	
	
}
