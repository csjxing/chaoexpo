package com.doucome.chaoexpo.biz.dal.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChaoNewsCondition {
	
	private Long categoryId;
	
	private Date gmtPublishStart;
	
	private Date gmtPublishEnd;
	
	private String orderColumn;
	
	private boolean isDesc;
	
	public Map<String,Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("categoryId", categoryId);
		result.put("gmtPublishStart", gmtPublishStart);
		result.put("gmtPublishEnd", gmtPublishEnd);
		result.put("orderColumn", orderColumn);
		if (isDesc) {
			result.put("order", "desc");
		}
		return result ;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getGmtPublishStart() {
		return gmtPublishStart;
	}

	public void setGmtPublishStart(Date gmtPublishStart) {
		this.gmtPublishStart = gmtPublishStart;
	}

	public Date getGmtPublishEnd() {
		return gmtPublishEnd;
	}

	public void setGmtPublishEnd(Date gmtPublishEnd) {
		this.gmtPublishEnd = gmtPublishEnd;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public boolean isDesc() {
		return isDesc;
	}

	public void setDesc(boolean isDesc) {
		this.isDesc = isDesc;
	}
}
