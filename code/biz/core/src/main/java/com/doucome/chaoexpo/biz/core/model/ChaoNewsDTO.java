package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class ChaoNewsDTO {

	private ChaoNewsDO news ;
	
	public ChaoNewsDTO(ChaoNewsDO news) {
		if(news == null) {
			news = new ChaoNewsDO() ;
		}
		this.news = news ;
	}

	public Long getId() {
		return news.getId();
	}

	public String getTitle() {
		return news.getTitle();
	}

	public String getSummary() {
		return news.getSummary();
	}

	public String getSummaryPics() {
		return news.getSummaryPics();
	}

	public String getDetailPics() {
		return news.getDetailPics();
	}

	public Long getCategoryId() {
		return news.getCategoryId();
	}

	public Date getGmtPublish() {
		return news.getGmtPublish();
	}

	public Date getGmtCreate() {
		return news.getGmtCreate();
	}

	public Date getGmtModified() {
		return news.getGmtModified();
	}

	public String getDetailUrl() {
		return news.getDetailUrl();
	}

	public Long getDisplayOrder() {
		return news.getDisplayOrder();
	}

	public String getSource() {
		return news.getSource();
	}

	public String getContent() {
		return news.getContent();
	}

}
