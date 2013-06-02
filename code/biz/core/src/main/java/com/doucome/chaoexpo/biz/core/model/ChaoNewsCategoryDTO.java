package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;

public class ChaoNewsCategoryDTO {

	private ChaoNewsCategoryDO category ;
	
	public ChaoNewsCategoryDTO(ChaoNewsCategoryDO category) {
		if(category == null) {
			category = new ChaoNewsCategoryDO() ;
		}
		this.category = category ;
	}
	
	public Long getId() {
		return category.getId();
	}

	public String getCatName() {
		return category.getCatName();
	}

	public Date getGmtCreate() {
		return category.getGmtCreate() ;
	}

}
