package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;

public class ChaoUserDTO {

	private ChaoUserDO user ;
	
	public ChaoUserDTO(ChaoUserDO user) {
		if(user == null) {
			user = new ChaoUserDO() ;
		}
		this.user = user ;
	}
	
	public Long getUserId() {
		return user.getUserId();
	}

	public String getUserName() {
		return user.getUserName();
	}

	public String getMd5Password() {
		return user.getMd5Password();
	}

	public Integer getFollowActivityCount() {
		return user.getFollowActivityCount();
	}

	public Integer getFavoriteSubjectCount() {
		return user.getFavoriteSubjectCount();
	}

	public Integer getCheckinActivityCount() {
		return user.getCheckinActivityCount();
	}

	public String getAuthKey() {
		return user.getAuthKey();
	}

	public String getRegisterIMEI() {
		return user.getRegisterIMEI();
	}

	public Date getGmtAuth() {
		return user.getGmtAuth();
	}

	public Date getGmtModified() {
		return user.getGmtModified();
	}

	public Date getGmtCreate() {
		return user.getGmtCreate();
	}

}
