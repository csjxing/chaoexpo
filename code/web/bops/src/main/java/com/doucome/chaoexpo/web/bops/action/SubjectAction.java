package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;

@SuppressWarnings("serial")
public class SubjectAction extends BopsBasicAction {
	
	private ChaoSubjectDTO subject;
	
	private Long id;
	
	@Autowired
	private ChaoSubjectService chaoSubjectService;
	
	@Override
	public String execute() throws Exception {
		if (IDUtils.isCorrect(id)) {
			subject = chaoSubjectService.getSubjectById(id);
		}
		return SUCCESS ;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ChaoSubjectDTO getSubject() {
		return subject;
	}
}
