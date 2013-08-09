package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoUserFollowDTO extends AbstractModel {

	private ChaoUserFollowDO userFollow ;
	
	public ChaoUserFollowDTO(ChaoUserFollowDO userFollow) {
		if(userFollow == null) {
			userFollow = new ChaoUserFollowDO() ;
		}
		this.userFollow = userFollow ;
	}
	
	public Long getId() {
		return userFollow.getId();
	}

	public String getUserName() {
		return userFollow.getUserName();
	}
	
	public Long getActivityId() {
		return userFollow.getActivityId();
	}

	public Long getSubjectId() {
		return userFollow.getSubjectId();
	}

	public Long getTenantId() {
		return userFollow.getTenantId() ;
	}

	public String getType() {
		return userFollow.getType();
	}

	public Date getGmtModified() {
		return userFollow.getGmtModified();
	}

	public Date getGmtCreate() {
		return userFollow.getGmtCreate();
	}
	
	public String getLocationCode() {
		return userFollow.getLocationCode();
	}

	public String getLocation() {
		return userFollow.getLocation();
	}
	
}
