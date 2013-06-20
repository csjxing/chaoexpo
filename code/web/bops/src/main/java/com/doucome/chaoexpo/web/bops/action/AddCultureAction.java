package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCultureService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;
import com.opensymphony.xwork2.ModelDriven;

public class AddCultureAction extends BopsBasicAction implements ModelDriven<ChaoCultureDO> {

	private ChaoCultureDO culture = new ChaoCultureDO() ;
	
	@Autowired
	private ChaoCultureService chaoCultureService ;
	
	@Override
	public String execute() throws Exception {	
		
		if(IDUtils.isCorrect(culture.getId())) {
		
			ChaoCultureUpdateCondition update = ChaoCultureUpdateCondition.fromCulture(culture) ;
			int effectCount = chaoCultureService.updateCultureById(culture.getId(), update) ;
			
		} else {
			long newId = chaoCultureService.createCulture(culture) ;
		}
		
		return SUCCESS ;
	}
	
	@Override
	public ChaoCultureDO getModel() {
		return culture ;
	}

}
