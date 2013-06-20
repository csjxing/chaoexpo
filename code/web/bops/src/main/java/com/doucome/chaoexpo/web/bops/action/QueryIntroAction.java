package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoIntroDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoIntroService;

public class QueryIntroAction extends BopsBasicAction {

	private ChaoIntroDTO intro ;
	
	@Autowired
	private ChaoIntroService chaoIntroService ;
	
	@Override
	public String execute() throws Exception {
		intro = chaoIntroService.getIntro() ;
		return SUCCESS ;
	}

	public ChaoIntroDTO getIntro() {
		return intro;
	}
	
}
