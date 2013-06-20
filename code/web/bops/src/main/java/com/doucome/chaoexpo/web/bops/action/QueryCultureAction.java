package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoCultureDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCultureService;


public class QueryCultureAction extends BopsBasicAction {

	private ChaoCultureDTO culture ;
	
	private Long id ;
	
	@Autowired
	private ChaoCultureService chaoCultureService ;
	
	@Override
	public String execute() throws Exception {
		if(IDUtils.isCorrect(id)) {
			culture = chaoCultureService.getCultureById(id) ;
		}
		return SUCCESS ;
	}

	public ChaoCultureDTO getCulture() {
		return culture;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
