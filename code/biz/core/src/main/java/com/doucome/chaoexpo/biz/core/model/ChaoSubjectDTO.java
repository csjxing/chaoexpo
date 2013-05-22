package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoSubjectDTO extends AbstractModel {

	private ChaoSubjectDO subject ;
	
	public ChaoSubjectDTO(ChaoSubjectDO subject) {
		if(subject == null) {
			subject = new ChaoSubjectDO() ;
		}
		this.subject = subject ;
	}
	
	public Long getId() {
		return subject.getId();
	}

	public String getName() {
		return subject.getName();
	}

	public String getPicUrls() {
		return subject.getPicUrls();
	}

	public String getWebUrl() {
		return subject.getWebUrl();
	}

	public Date getGmtCreate() {
		return subject.getGmtCreate();
	}

	public Date getGmtModified() {
		return subject.getGmtModified();
	}
	
}
