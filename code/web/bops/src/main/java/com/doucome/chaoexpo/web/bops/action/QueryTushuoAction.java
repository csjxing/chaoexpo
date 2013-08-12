package com.doucome.chaoexpo.web.bops.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoCategoryQuery;


public class QueryTushuoAction extends BopsBasicAction {

	private ChaoTushuoDTO tushuo ;
	
	private List<ChaoTushuoCategoryDTO> cateList ;
	
	private Long id ;
	
	@Autowired
	private ChaoTushuoService chaoTushuoService ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	@Override
	public String execute() throws Exception {
		if(IDUtils.isCorrect(id)) {
			tushuo = chaoTushuoService.getTushuoById(id) ;
		}
		ChaoTushuoCategoryQuery cateQuery = new ChaoTushuoCategoryQuery() ;
		cateList = chaoTushuoCategoryService.getCategories(cateQuery) ;
		
		return SUCCESS ;
	}

	public ChaoTushuoDTO getTushuo() {
		return tushuo ;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ChaoTushuoCategoryDTO> getCateList() {
		return cateList;
	}
	
}
