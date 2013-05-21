package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoActivityUpdateCondition extends AbstractModel  {

	/**
	 * 活动名
	 */
	private String name ;
	
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
	 * 专题列表（“,”隔开）
	 */
	private Long subjectIds ;
	
	private Integer incrFollowCount ;
	
	private Integer incrCommentCount ;
	
	public Map<String,Object> toMap() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("name", name) ;
		map.put("location", location) ;
		map.put("contactName", contactName) ;
		map.put("contactPhone", contactPhone) ;
		map.put("intro", intro) ;
		map.put("picUrls", picUrls) ;
		map.put("notice", notice) ;
		map.put("countesyReminder", countesyReminder) ;
		map.put("standPicUrls", standPicUrls) ;
		map.put("subjectIds", subjectIds) ;
		
		map.put("incrFollowCount", incrFollowCount) ;
		map.put("incrCommentCount", incrCommentCount) ;
		return map ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getSubjectIds() {
		return subjectIds;
	}

	public void setSubjectIds(Long subjectIds) {
		this.subjectIds = subjectIds;
	}

	public Integer getIncrFollowCount() {
		return incrFollowCount;
	}

	public void setIncrFollowCount(Integer incrFollowCount) {
		this.incrFollowCount = incrFollowCount;
	}

	public Integer getIncrCommentCount() {
		return incrCommentCount;
	}

	public void setIncrCommentCount(Integer incrCommentCount) {
		this.incrCommentCount = incrCommentCount;
	}
	
}
