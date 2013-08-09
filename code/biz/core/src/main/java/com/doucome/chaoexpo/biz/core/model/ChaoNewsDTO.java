package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.core.constant.URIConstant;
import com.doucome.chaoexpo.biz.core.enums.ChaoNewsStatusEnum;
import com.doucome.chaoexpo.biz.core.service.impl.DefaultUriService;
import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.core.utils.ChaoDisplayOrderUtils;
import com.doucome.chaoexpo.biz.core.utils.PictureUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class ChaoNewsDTO {

	private ChaoNewsDO news;
	
	private String summary;
	
	private String contentUrl;
	
	private String categoryName;

	public ChaoNewsDTO() {
		this(null);
	}
	
	public ChaoNewsDTO(ChaoNewsDO news) {
		this.news = news;
		if(news == null) {
			this.news = new ChaoNewsDO() ;
			this.news.setStatus(ChaoNewsStatusEnum.NORMAL.getValue());
			this.news.setDisplayOrder(ChaoDisplayOrderUtils.getDisplayOrder());
		} else {
			this.summary = news.getContent();
			if (StringUtils.length(summary) > 100) {
				this.summary = this.summary.substring(0, 100);
			}
			this.contentUrl = DefaultUriService.getFactoryURI(URIConstant.SERVER)
			  + "/chao/remote/rest/query_news_detail.htm?id=" + news.getId();
		}
	}
	
	public List<PicModel> getPicModelList() {
		List<String> detailPicList = ArrayStringUtils.toList(getPicUrls()) ;
		return PictureUtils.toModelList(detailPicList) ;
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

	public Long getCategoryId() {
		return news.getCategoryId();
	}
	
	public void setCategoryId(Long categoryId) {
		news.setCategoryId(categoryId);
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

	public Date getGmtCreate() {
		return news.getGmtCreate();
	}

	public Date getGmtModified() {
		return news.getGmtModified();
	}

	public String getPicUrls() {
		return news.getPicUrls();
	}
	
	public List<String> getPicUrlList() {
		return ArrayStringUtils.toList(getPicUrls());
	}
	
	public void setPicUrlList(List<String> picUrls) {
		news.setPicUrls(ArrayStringUtils.toString(picUrls));
	}

	public Long getDisplayOrder() {
		return news.getDisplayOrder();
	}
	
	public void setDisplayOrder(Long displayOrder) {
		news.setDisplayOrder(displayOrder);
	}

	public String getSource() {
		return news.getSource();
	}
	
	public void setSource(String source) {
		news.setSource(source);
	}

	public String getContent() {
		return news.getContent();
	}
	
	public void setContent(String content) {
		news.setContent(content);
	}
	
	public String getSummary() {
		return summary;
	}
	
	public Integer getCommentCount() {
		return news.getCommentCount() ;
	}
	
	public String getIsTop() {
		return news.getIsTop();
	}
	
	public void setIsTop(String isTop) {
		news.setIsTop(isTop);
	}
	
	public String getContentUrl() {
		return contentUrl;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ChaoNewsDO toDO() {
		return news;
	}

}
