package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.ChaoStatusEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoCategoryDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCategoryService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddCategoryAction extends BopsBasicAction implements ModelDriven<ChaoCategoryDTO> {
	
	private ChaoCategoryDTO category = new ChaoCategoryDTO();
	
	@Autowired
	private ChaoCategoryService chaoCategoryService;
	
	@Override
	public String execute() throws Exception {
		if (category.getId() == null) {
			category.setStatus(ChaoStatusEnum.ENABLE.getValue());
			chaoCategoryService.createCategory(category);
		} else {
			chaoCategoryService.updateCategory(category);
		}
		return SUCCESS ;
	}
	
	public ChaoCategoryDTO getModel() {
		return category;
	}
}
