package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;

@SuppressWarnings("serial")
public class NewsCategoryAction extends BopsBasicAction {
	
	private ChaoNewsCategoryDTO category;
	
	private Long id;
	
	@Autowired
	private ChaoNewsCategoryService chaoNewsCategoryService;
	
	@Override
	public String execute() throws Exception {
		if (IDUtils.isCorrect(id)) {
			category = chaoNewsCategoryService.getCategoryById(id);
		}
		return SUCCESS ;
	}
	
	public ChaoNewsCategoryDTO getCategory() {
		return category;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
