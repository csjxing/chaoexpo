package com.doucome.chaoexpo.biz.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.doucome.chaoexpo.biz.core.enums.ChaoStatusEnum;
import com.doucome.chaoexpo.biz.core.utils.ChaoDisplayOrderUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class ChaoNewsDTO {

	private ChaoNewsDO news ;
	
	public ChaoNewsDTO() {
		this(null);
	}
	
	public ChaoNewsDTO(ChaoNewsDO news) {
		if(news == null) {
			news = new ChaoNewsDO() ;
			this.news.setStatus(ChaoStatusEnum.ENABLE.getValue());
			this.news.setDisplayOrder(ChaoDisplayOrderUtils.getDisplayOrder());
		}
		this.news = news ;
	}

	public List<String> getSummaryPicUrls() {
		List<String> result = new ArrayList<String>();
		
		return result;
	}

	public List<String> getDetailPicUrls() {
        List<String> result = new ArrayList<String>();
		
		return result;
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

	public String getStatus() {
		return news.getStatus();
	}
	
	public void setStatus(String status) {
		news.setStatus(status);
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

	public String getIsTop() {
		return news.getIsTop() ;
	}
	
	public ChaoNewsDO toDO() {
		return news;
	}
}
