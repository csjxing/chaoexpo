package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddCategoryAction extends BopsBasicAction implements ModelDriven<ChaoNewsCategoryDTO> {
	
	private ChaoNewsCategoryDTO category = new ChaoNewsCategoryDTO();
	
	@Autowired
	private ChaoNewsCategoryService chaoNewsCategoryService;
	
	@Override
	public String execute() throws Exception {
		if (category.getId() == null) {
			chaoNewsCategoryService.createCategory(category.toDO());
		} else {
			chaoNewsCategoryService.updateCategory(category);
		}
		return SUCCESS ;
	}
	
	public ChaoNewsCategoryDTO getModel() {
		return category;
	}
}
