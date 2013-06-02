package com.doucome.chaoexpo.biz.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.doucome.chaoexpo.biz.core.enums.ChaoStatusEnum;
import com.doucome.chaoexpo.biz.core.model.param.PictureModel;
import com.doucome.chaoexpo.biz.core.utils.ChaoDisplayOrderUtils;
import com.doucome.chaoexpo.biz.core.utils.JacksonHelper;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoNewsDTO extends AbstractModel {

	private static final long serialVersionUID = 1L;
	
	private ChaoNewsDO news;
	
	public ChaoNewsDTO() {
		this(null);
	}
	
	public ChaoNewsDTO(ChaoNewsDO news) {
		this.news = news ;
		if(news == null) {
			this.news = new ChaoNewsDO() ;
			this.news.setStatus(ChaoStatusEnum.ENABLE.getValue());
			this.news.setDisplayOrder(ChaoDisplayOrderUtils.getDisplayOrder());
		}
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
	
	public void setId(Long id) {
		news.setId(id);
	}
	
	public String getTitle() {
		return news.getTitle();
	}
	
	public void setTitle(String title) {
		news.setTitle(title);
	}
	
	public String getSummary() {
		return news.getSummary();
	}
	
	public void setSummary(String summary) {
		news.setSummary(summary);
	}
	
	public String getSummaryPictures() {
		return news.getSummaryPictures();
	}
	
	public PictureModel[] getSummaryPictureModels() {
		try {
			return JacksonHelper.fromJSON(getSummaryPictures(), PictureModel[].class);
		} catch(Exception e) {
			return new PictureModel[0];
		}
	}
	
	public void setSummaryPictures(String summaryPictures) {
		news.setSummaryPictures(summaryPictures);
	}
	
	public void setSummaryPictures(PictureModel[] models) {
		if (models == null) {
			return ;
		}
		try {
			setSummaryPictures(JacksonHelper.toJSON(models));
		} catch (Exception e) {
		}
	}
	
	public String getDetailPictures() {
		return news.getDetailPictures();
	}
	
	public PictureModel[] getDetailPictureModels() {
		try {
			return JacksonHelper.fromJSON(getDetailPictures(), PictureModel[].class);
		} catch(Exception e) {
			return new PictureModel[0];
		}
	}
	
	public void setDetailPictures(String detailPictures) {
		news.setDetailPictures(detailPictures);
	}
	
	public void setDetailPictures(PictureModel[] models) {
		if (models == null) {
			return ;
		}
		try {
			setDetailPictures(JacksonHelper.toJSON(models));
		} catch (Exception e) {
		}
	}
	
	public String getSourceUrl() {
		return news.getSourceUrl();
	}
	
	public void setSourceUrl(String sourceUrl) {
		news.setSourceUrl(sourceUrl);
	}
	
	public String getCategoryId() {
		return news.getCategoryId();
	}
	
	public void setCategoryId(String categoryId) {
		news.setCategoryId(categoryId);
	}
	
	public Long getDisplayOrder() {
		return news.getDisplayOrder();
	}
	
	public void setDisplayOrder(Long displayOrder) {
		news.setDisplayOrder(displayOrder);
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
	
	public void setGmtPublish(Date gmtPublish) {
		news.setGmtPublish(gmtPublish);
	}
	
	public Date getGmtModified() {
		return news.getGmtModified();
	}
	
	public void setGmtModified(Date gmtModified) {
		news.setGmtModified(gmtModified);
	}
	
	public Date getGmtCreate() {
		return news.getGmtCreate();
	}
	
	public void setGmtCreate(Date gmtCreate) {
		news.setGmtCreate(gmtCreate);
	}
	
	public ChaoNewsDO toDO() {
		return news;
	}
}
