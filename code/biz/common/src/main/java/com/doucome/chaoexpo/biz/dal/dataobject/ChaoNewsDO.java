package com.doucome.chaoexpo.biz.dal.dataobject;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 活动
 * @author ze2200
 *
 */
public class ChaoNewsDO  extends AbstractModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id ;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 摘要
	 */
	private String summary;
	/**
	 * 概要图片地址
	 */
	private String summaryPictures;
	
	/**
	 * 详情图片
	 */
	private String detailPictures;
	
	/**
	 * 正文Url
	 */
	private String sourceUrl;
	
	/**
	 * 分类id
	 */
	private String categoryId;
	
	/**
	 * 排序编号.
	 */
	private Long displayOrder;
	/**
	 * 时间
	 */
	private Date gmtPublish;
	/**
	 * 
	 */
	private Date gmtModified;
	/**
	 * 
	 */
	private Date gmtCreate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public String getSummaryPictures() {
		return summaryPictures;
	}
	
	public void setSummaryPictures(String summaryPictures) {
		this.summaryPictures = summaryPictures;
	}
	
	public String getDetailPictures() {
		return detailPictures;
	}
	
	public void setDetailPictures(String detailPictures) {
		this.detailPictures = detailPictures;
	}
	
	public String getSourceUrl() {
		return sourceUrl;
	}
	
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public Long getDisplayOrder() {
		return displayOrder;
	}
	
	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	public Date getGmtPublish() {
		return gmtPublish;
	}
	
	public void setGmtPublish(Date gmtPublish) {
		this.gmtPublish = gmtPublish;
	}
	
	public Date getGmtModified() {
		return gmtModified;
	}
	
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
}
