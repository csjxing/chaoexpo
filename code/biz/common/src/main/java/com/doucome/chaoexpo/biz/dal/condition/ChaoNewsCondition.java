package com.doucome.chaoexpo.biz.dal.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChaoNewsCondition {
	
	private Long newsId;
	
	private Long categoryId;
	
	private String keyword;
	
	private String status;
	
	private Date gmtPublishStart;
	
	private Date gmtPublishEnd;
	
	private Date gmtCreateStart;
	
	private Date gmtCreateEnd;
	
	private String orderColumn;
	
	private boolean isDesc;
	
	public Map<String,Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("newsId", newsId);
		result.put("categoryId", categoryId);
		result.put("keyword", keyword);
		result.put("status", status);
		result.put("gmtPublishStart", gmtPublishStart);
		result.put("gmtPublishEnd", gmtPublishEnd);
		result.put("gmtCreateStart", gmtCreateStart);
		result.put("gmtCreateEnd", gmtCreateEnd);
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

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getGmtCreateStart() {
		return gmtCreateStart;
	}

	public void setGmtCreateStart(Date gmtCreateStart) {
		this.gmtCreateStart = gmtCreateStart;
	}

	public Date getGmtCreateEnd() {
		return gmtCreateEnd;
	}

	public void setGmtCreateEnd(Date gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
	}
}
