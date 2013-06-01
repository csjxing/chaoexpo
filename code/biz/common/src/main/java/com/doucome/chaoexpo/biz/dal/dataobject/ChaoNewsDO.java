package com.doucome.chaoexpo.biz.dal.dataobject;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 新闻
 * @author langben 2013-6-1
 *
 */
public class ChaoNewsDO extends AbstractModel {

	private Long id ;
	
	/**
	 * 新闻标题
	 */
	private String title ;
	
	/**
	 * 正文摘要
	 */
	private String summary ;
	
	/**
	 * 概要图片
	 */
	private String summaryPics ;
	
	/**
	 * 正文图片
	 */
	private String detailPics ;
	
	/**
	 * 正文
	 */
	private String content ;
	
	/**
	 * 正文URL
	 */
	private String detailUrl ;
	
	/**
	 * 新闻分类
	 */
	private Long categoryId ;
	
	/**
	 * 排序，一般是当前时间戳
	 */
	private Long displayOrder ;
	
	/**
	 * 来源
	 */
	private String source ;
	
	/**
	 * 发表时间
	 */
	private Date gmtPublish ;
	
	private Date gmtCreate ;
	
	private Date gmtModified ;

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

	public String getSummaryPics() {
		return summaryPics;
	}

	public void setSummaryPics(String summaryPics) {
		this.summaryPics = summaryPics;
	}

	public String getDetailPics() {
		return detailPics;
	}

	public void setDetailPics(String detailPics) {
		this.detailPics = detailPics;
	}


	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public Date getGmtPublish() {
		return gmtPublish;
	}

	public void setGmtPublish(Date gmtPublish) {
		this.gmtPublish = gmtPublish;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
