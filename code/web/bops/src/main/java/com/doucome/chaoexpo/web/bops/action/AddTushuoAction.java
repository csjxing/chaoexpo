package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.bo.ChaoTushuoBO;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;
import com.opensymphony.xwork2.ModelDriven;

public class AddTushuoAction extends BopsBasicAction implements ModelDriven<ChaoTushuoDO> {

	private ChaoTushuoDO tushuo = new ChaoTushuoDO() ;
	
	@Autowired
	private ChaoTushuoBO chaoTushuoBO ;
	
	@Override
	public String execute() throws Exception {	
		
		if(IDUtils.isCorrect(tushuo.getId())) {
		
			ChaoTushuoUpdateCondition update = ChaoTushuoUpdateCondition.fromTushuo(tushuo) ;
			int effectCount = chaoTushuoBO.updateTushuoById(tushuo.getId(), update , tushuo.getCategoryId()) ;
			
		} else {
			long newId = chaoTushuoBO.createTushuo(tushuo) ;
		}
		
		return SUCCESS ;
	}
	
	@Override
	public ChaoTushuoDO getModel() {
		return tushuo ;
	}

}
