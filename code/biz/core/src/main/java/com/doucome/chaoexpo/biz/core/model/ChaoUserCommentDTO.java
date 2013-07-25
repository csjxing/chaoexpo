package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;

public class ChaoUserCommentDTO {

	private ChaoUserCommentDO comment ;
	
	public ChaoUserCommentDTO(ChaoUserCommentDO comment) {
		if(comment == null) {
			comment = new ChaoUserCommentDO() ;
		}
		this.comment = comment ;
	}
	
	public String getSubContent(int length) {
		return StringUtils.substring(getContent(), 0, length) ;
	}
	
	/**
	 * ----------------------------------------------------------------
	 */
	
	public Long getId() {
		return comment.getId();
	}

	public Long getToCommentId() {
		return comment.getToCommentId();
	}

	public String getToUserName() {
		return comment.getToUserName();
	}

	public String getUserName() {
		return comment.getUserName();
	}

	public Long getActivityId() {
		return comment.getActivityId();
	}

	public Long getNewsId() {
		return comment.getNewsId();
	}

	public String getType() {
		return comment.getType();
	}

	public String getContent() {
		return comment.getContent();
	}

	public String getStatus() {
		return comment.getStatus();
	}

	public Date getGmtCreate() {
		return comment.getGmtCreate();
	}

	public Date getGmtModified() {
		return comment.getGmtModified();
	}

}
