package com.doucome.chaoexpo.biz.dal.dataobject;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 活动
 * @author langben 2013-5-21
 *
 */
public class ChaoActivityDO  extends AbstractModel{

	private Long id ;
	
	/**
	 * 活动名
	 */
	private String name ;
	/**
	 * 
	 */
	private Date gmtActivity;
	/**
	 * 地点
	 */
	private String location ;
	
	/**
	 * 联系人
	 */
	private String contactName ;
	
	/**
	 * 联系电话
	 */
	private String contactPhone ;
	
	/**
	 * 活动介绍
	 */
	private String intro ;
	
	/**
	 * 活动图列表,","隔开
	 */
	private String picUrls ;
	
	/**
	 * 活动须知
	 */
	private String notice ;

	/**
	 * 温馨提示
	 */
	private String countesyReminder ;

	/**
	 * 展位图列表,","隔开
	 */
	private String standPicUrls ;
	
	/**
	 * 对应专题
	 */
	private Long subjectId ;
	
	/**
	 * 关注数
	 */
	private Integer followCount ;
	
	/**
	 * 评论数
	 */
	private Integer commentCount ;
	
	private Date gmtCreate ;
	
	private Date gmtModified ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getGmtActivity() {
		return gmtActivity;
	}

	public void setGmtActivity(Date gmtActivity) {
		this.gmtActivity = gmtActivity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String picUrls) {
		this.picUrls = picUrls;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getCountesyReminder() {
		return countesyReminder;
	}

	public void setCountesyReminder(String countesyReminder) {
		this.countesyReminder = countesyReminder;
	}

	public String getStandPicUrls() {
		return standPicUrls;
	}

	public void setStandPicUrls(String standPicUrls) {
		this.standPicUrls = standPicUrls;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
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

	public Integer getFollowCount() {
		return followCount;
	}

	public void setFollowCount(Integer followCount) {
		this.followCount = followCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	
}
