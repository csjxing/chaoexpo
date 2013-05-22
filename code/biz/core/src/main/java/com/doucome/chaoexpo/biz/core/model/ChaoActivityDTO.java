package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoActivityDTO extends AbstractModel {
	
	private ChaoActivityDO activity ;
	
	private ChaoSubjectDTO subject ;

	public ChaoActivityDTO(ChaoActivityDO activity) {
		if(activity == null) {
			activity = new ChaoActivityDO() ;
		}
		this.activity = activity ;
	}
	
	public Long getId() {
		return activity.getId();
	}

	public String getName() {
		return activity.getName();
	}

	public String getLocation() {
		return activity.getLocation();
	}

	public String getContactName() {
		return activity.getContactName();
	}

	public String getContactPhone() {
		return activity.getContactPhone();
	}


	public String getIntro() {
		return activity.getIntro();
	}


	public String getPicUrls() {
		return activity.getPicUrls();
	}

	public String getNotice() {
		return activity.getNotice()
		;
	}

	public String getCountesyReminder() {
		return activity.getCountesyReminder();
	}

	public String getStandPicUrls() {
		return activity.getStandPicUrls();
	}

	public Long getSubjectId() {
		return activity.getSubjectId();
	}
	
	public Integer getFollowCount() {
		return activity.getFollowCount();
	}

	public Integer getCommentCount() {
		return activity.getCommentCount();
	}

	public Date getGmtCreate() {
		return activity.getGmtCreate();
	}

	public Date getGmtModified() {
		return activity.getGmtModified();
	}

	public ChaoSubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(ChaoSubjectDTO subject) {
		this.subject = subject;
	}

}
