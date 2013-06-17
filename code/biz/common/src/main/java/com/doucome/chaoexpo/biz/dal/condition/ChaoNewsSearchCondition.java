package com.doucome.chaoexpo.biz.dal.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChaoNewsSearchCondition {
	
	private Long id;
	
	private String keyword;
	
	private Long categoryId;
	
	private String source;
	
	private String isTop;
	
	private String status = "N";
	
	private Date gmtPublishStart;
	
	private Date gmtPublishEnd = new Date();
	
	private String orderColumn;
	
	public Map<String,Object> toMap() {
		Map<String,Object> result = new HashMap<String,Object>() ;
		result.put("id", id);
		result.put("keyword", keyword);
		result.put("categoryId", categoryId);
		result.put("source", source);
		result.put("isTop", isTop);
		result.put("status", status);
		result.put("gmtPublishStart", gmtPublishStart);
		result.put("gmtPublishEnd", gmtPublishEnd);
		result.put("orderColumn", orderColumn);
		return result;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
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
		this.orderColumn = orderColumn != null? orderColumn.trim().toUpperCase(): null;
	}
}
