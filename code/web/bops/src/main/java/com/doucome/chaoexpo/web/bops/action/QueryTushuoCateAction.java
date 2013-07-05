package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;


public class QueryTushuoCateAction extends BopsBasicAction {

	private ChaoTushuoCategoryDTO cate ;
	
	private Long id ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	@Override
	public String execute() throws Exception {
		
		if(IDUtils.isCorrect(id)) {
			cate = chaoTushuoCategoryService.getCategoryById(id) ;
		}
		
		return SUCCESS ;
	}

	public ChaoTushuoCategoryDTO getCate() {
		return cate;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
