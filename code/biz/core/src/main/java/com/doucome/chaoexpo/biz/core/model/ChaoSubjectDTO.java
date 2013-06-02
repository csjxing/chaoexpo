package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;
import java.util.List;

import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoSubjectDTO extends AbstractModel {

	private ChaoSubjectDO subject ;

	private Boolean isUserFollowed ;	public ChaoSubjectDTO(ChaoSubjectDO subject) {
		if(subject == null) {
			subject = new ChaoSubjectDO() ;
		}
		this.subject = subject ;
	}
	
	public Long getId() {
		return subject.getId();
	}
	
	public void setId(Long id) {
		subject.setId(id);
	}

	public String getName() {
		return subject.getName();
	}
	
	public void setName(String name) {
		subject.setName(name);
	}

	public String getPicUrls() {
		return subject.getPicUrls();
	}
	
	public List<String> getPicUrlList() {
		return ArrayStringUtils.toList(getPicUrls());
	}
	
	public void setPicUrlList(List<String> picUrlList) {
		subject.setPicUrls(ArrayStringUtils.toString(picUrlList));
	}
	
	public String getWebUrl() {
		return subject.getWebUrl();
	}
	
	public void setWebUrl(String webUrl) {
		subject.setWebUrl(webUrl);
	}

	public Date getGmtCreate() {
		return subject.getGmtCreate();
	}

	public Date getGmtModified() {
		return subject.getGmtModified();
	}

	public Boolean getIsUserFollowed() {
		return isUserFollowed;
	}

	public void setIsUserFollowed(Boolean isUserFollowed) {
		this.isUserFollowed = isUserFollowed;
	}
	
	public ChaoSubjectDO toDO() {
		return subject;
	}
}
