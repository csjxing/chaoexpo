package com.doucome.chaoexpo.biz.dal.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.common.utils.ConditionUtils;

public class ChaoNewsCondition {
	
	private Long id;
	
	private Long categoryId;
	
	private String keyword;
	
	private String isTop;
	
	private Date gmtPublishStart;
	
	private Date gmtPublishEnd;
	
	private Date gmtCreateStart;
	
	private Date gmtCreateEnd;
	
	private String orderColumn;
	
	private String status = "N";
	
	private String order = "DESC";
	
	public Map<String,Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", id);
		result.put("categoryId", categoryId);
		result.put("keyword", keyword);
		result.put("isTop", isTop);
		result.put("gmtPublishStart", gmtPublishStart);
		result.put("gmtPublishEnd", gmtPublishEnd);
		result.put("gmtCreateStart", gmtCreateStart);
		result.put("gmtCreateEnd", gmtCreateEnd);
		result.put("orderColumn", orderColumn);
		result.put("order", order);
		result.put("status", status);
		return result ;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
		Date[] days = ConditionUtils.getDayStartEnd(gmtPublishEnd);
		this.gmtPublishEnd = days[1];
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn == null? null: orderColumn.toUpperCase();
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order == null? null: order.toUpperCase();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop == null? null: isTop.toUpperCase();
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
