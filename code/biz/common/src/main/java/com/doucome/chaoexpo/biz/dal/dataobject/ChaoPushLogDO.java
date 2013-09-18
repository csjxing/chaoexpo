package com.doucome.chaoexpo.biz.dal.dataobject;

import java.util.Date;

public class ChaoPushLogDO {

	private Long id ;
	
	private String msg ;
	
	private String pushGroup ;
	
	private Integer succCount ;
	
	private Date gmtCreate ;

	public Long getId() {
		return id;
	}

	public Integer getSuccCount() {
		return succCount;
	}

	public void setSuccCount(Integer succCount) {
		this.succCount = succCount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPushGroup() {
		return pushGroup;
	}

	public void setPushGroup(String pushGroup) {
		this.pushGroup = pushGroup;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	
}
