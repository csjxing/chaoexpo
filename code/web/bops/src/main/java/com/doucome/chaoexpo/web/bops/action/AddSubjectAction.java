package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddSubjectAction extends BopsBasicAction implements ModelDriven<ChaoSubjectDTO> {
	
	private ChaoSubjectDTO subject = new ChaoSubjectDTO();
	
	@Autowired
	private ChaoSubjectService chaoSubjectService;
	
	@Override
	public String execute() throws Exception {
		if (subject.getId() == null) {
			chaoSubjectService.createSubject(subject.toDO());
		} else {
			chaoSubjectService.updateSubject(subject);
		}
		return SUCCESS ;
	}
	
	
	public ChaoSubjectDTO getModel() {
		return subject;
	}
}
