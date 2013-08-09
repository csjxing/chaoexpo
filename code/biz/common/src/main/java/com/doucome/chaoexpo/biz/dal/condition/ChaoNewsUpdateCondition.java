package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

public class ChaoNewsUpdateCondition {

private String title ;
	
	private String summary ;
	
	private String summaryPics ;
	
	private String detailUrl ;
	
	private String detailPics ;
	
	private String content ;
	
	private Long categoryId ;
	
	private String status;
	
	private Long displayOrder ;
	
	private String isTop ;
	
	private String source ;
	
	private Integer incrCommentCount ;
	
	public Map<String,Object> toMap() {
		
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("title", title) ;
		map.put("summary", summary) ;
		map.put("summaryPics", summaryPics) ;
		map.put("detailUrl", detailUrl) ;
		map.put("detailPics", detailPics) ;
		map.put("content", content) ;
		map.put("categoryId", categoryId) ;
		map.put("displayOrder", displayOrder) ;
		map.put("isTop", isTop) ;
		map.put("source", source) ;
		map.put("incrCommentCount", incrCommentCount) ;
		map.put("status", status) ;

		return map ;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getIncrCommentCount() {
		return incrCommentCount;
	}

	public void setIncrCommentCount(Integer incrCommentCount) {
		this.incrCommentCount = incrCommentCount;
	}

	public String getSummaryPics() {
		return summaryPics;
	}

	public void setSummaryPics(String summaryPics) {
		this.summaryPics = summaryPics;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDetailPics() {
		return detailPics;
	}

	public void setDetailPics(String detailPics) {
		this.detailPics = detailPics;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
