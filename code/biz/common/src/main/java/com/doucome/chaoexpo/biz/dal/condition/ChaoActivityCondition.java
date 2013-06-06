package com.doucome.chaoexpo.biz.dal.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.common.utils.ConditionUtils;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoActivityCondition extends AbstractModel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String keyword;
	
	private Long subjectId;
	
	private Date gmtActivityStart;
	
	private Date gmtActivityEnd;
	
	private String sortColumn;
	
	private String order = "desc";
	
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", id);
		result.put("keyword", keyword);
		result.put("subjectId", subjectId);
		result.put("order", order);
		result.put("sortColumn", sortColumn);
		result.put("gmtActivityStart", gmtActivityStart);
		result.put("gmtActivityEnd", gmtActivityEnd);
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

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Date getGmtActivityStart() {
		return gmtActivityStart;
	}

	public void setGmtActivityStart(Date gmtActivityStart) {
		this.gmtActivityStart = gmtActivityStart;
	}

	public Date getGmtActivityEnd() {
		return gmtActivityEnd;
	}

	public void setGmtActivityEnd(Date gmtActivityEnd) {
		Date[] days = ConditionUtils.getDayStartEnd(gmtActivityEnd);
		this.gmtActivityEnd = days[1];
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
