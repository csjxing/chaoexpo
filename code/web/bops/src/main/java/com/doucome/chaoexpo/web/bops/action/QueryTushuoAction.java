package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;


public class QueryTushuoAction extends BopsBasicAction {

	private ChaoTushuoDTO tushuo ;
	
	private Long id ;
	
	@Autowired
	private ChaoTushuoService chaoTushuoService ;
	
	@Override
	public String execute() throws Exception {
		if(IDUtils.isCorrect(id)) {
			tushuo = chaoTushuoService.getTushuoById(id) ;
		}
		return SUCCESS ;
	}

	public ChaoTushuoDTO getTushuo() {
		return tushuo ;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
