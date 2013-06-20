package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.service.chao.ChaoIntroService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoIntroUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoIntroDO;
import com.opensymphony.xwork2.ModelDriven;

public class AddIntroAction extends BopsBasicAction implements ModelDriven<ChaoIntroDO> {

	private ChaoIntroDO intro = new ChaoIntroDO() ;
	
	@Autowired
	private ChaoIntroService chaoIntroService ;
	
	@Override
	public String execute() throws Exception {	
		
		ChaoIntroUpdateCondition update = ChaoIntroUpdateCondition.fromIntro(intro) ;
		
		int effectCount = chaoIntroService.updateIntro(update) ;
		
		return SUCCESS ;
	}
	
	@Override
	public ChaoIntroDO getModel() {
		return intro ;
	}

}
