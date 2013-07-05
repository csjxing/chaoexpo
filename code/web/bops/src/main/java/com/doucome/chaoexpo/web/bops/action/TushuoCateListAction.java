package com.doucome.chaoexpo.web.bops.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;

/**
 * 图说分类
 * @author langben 2013-6-20
 *
 */
public class TushuoCateListAction extends BopsBasicAction {

	private List<ChaoTushuoCategoryDTO> cateList ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	private int page ;
	
	@Override
	public String execute() throws Exception {
		
		cateList = chaoTushuoCategoryService.getCategories() ;
		
		return SUCCESS ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<ChaoTushuoCategoryDTO> getCateList() {
		return cateList;
	}
	
}
