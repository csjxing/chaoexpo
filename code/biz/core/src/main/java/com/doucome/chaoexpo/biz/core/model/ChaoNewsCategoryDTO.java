package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.core.enums.ChaoNewsStatusEnum;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;

public class ChaoNewsCategoryDTO {

	private ChaoNewsCategoryDO category ;
	
	public ChaoNewsCategoryDTO() {
		this(null);
	}
	
	public ChaoNewsCategoryDTO(ChaoNewsCategoryDO category) {
		if(category == null) {
			category = new ChaoNewsCategoryDO();
			category.setStatus(ChaoNewsStatusEnum.NORMAL.getValue()) ;
		}
		this.category = category ;
	}
	
	public Long getId() {
		return category.getId();
	}
	
	public void setId(Long id) {
		category.setId(id);
	}

	public String getCatName() {
		return category.getCatName();
	}
	
	public void setCatName(String catName) {
		category.setCatName(catName);
	}
	
	public String getStatus() {
		return category.getStatus();
	}
	
	public ChaoNewsStatusEnum getStatusEnum() {
		return ChaoNewsStatusEnum.toEnum(getStatus());
	}
	
	public void setStatus(String status) {
		category.setStatus(status);
	}
	
	public void setStatusEnum(ChaoNewsStatusEnum statusEnum) {
		if (statusEnum != null) {
			setStatus(statusEnum.getValue());
		}
	}
	
	public Date getGmtCreate() {
		return category.getGmtCreate() ;
	}
	
	public ChaoNewsCategoryDO toDO() {
		return category;
	}
}
