package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivitySignupDO;

public class ChaoActivitySignupDTO {

	private ChaoActivitySignupDO signup ;
	
	public ChaoActivitySignupDTO(ChaoActivitySignupDO signup) {
		if( signup == null ) {
			signup = new ChaoActivitySignupDO() ;
		}
		this.signup = signup ;
	}
	
	public Long getId() {
		return signup.getId();
	}

	public Long getActivityId() {
		return signup.getActivityId();
	}

	public String getActivityName() {
		return signup.getActivityName();
	}

	public String getUserName() {
		return signup.getUserName();
	}

	public String getContactName() {
		return signup.getContactName();
	}

	public String getContactPhone() {
		return signup.getContactPhone();
	}

	public Date getGmtCreate() {
		return signup.getGmtCreate();
	}

	public Date getGmtModified() {
		return signup.getGmtModified();
	}

}
