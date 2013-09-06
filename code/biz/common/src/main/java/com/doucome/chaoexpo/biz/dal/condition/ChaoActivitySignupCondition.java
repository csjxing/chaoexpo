package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoActivitySignupCondition extends AbstractModel  {

	private Long id;
	
	private Long activityId;
	
	private String sortColumn;
	
	private String order = "desc";
	
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", id);
		result.put("activityId", activityId);
		result.put("sortColumn", sortColumn);
		result.put("order", order);
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn== null? null: sortColumn.toUpperCase().trim();
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order == null? null: order.toUpperCase().trim();
	}
}
