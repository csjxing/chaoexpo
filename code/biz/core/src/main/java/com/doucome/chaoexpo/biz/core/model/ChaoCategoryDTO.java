package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCategoryDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoCategoryDTO extends AbstractModel {
	
	private static final long serialVersionUID = 1l;
	
	private ChaoCategoryDO category;

	public ChaoCategoryDTO() {
		this(null);
	}
	
	public ChaoCategoryDTO(ChaoCategoryDO category) {
		if(category == null) {
			category = new ChaoCategoryDO();
		}
		this.category = category ;
	}
	
	public Long getId() {
		return category.getId();
	}

	public void setId(Long id) {
		category.setId(id);
	}
	
	public String getName() {
		return category.getName();
	}

	public void setName(String name) {
		category.setName(name);
	}

	public String getStatus() {
		return category.getStatus();
	}

	public void setStatus(String status) {
		category.setStatus(status);
	}

	public Date getGmtModified() {
		return category.getGmtModified();
	}

	public void setGmtModified(Date gmtModified) {
		category.setGmtModified(gmtModified);
	}

	public Date getGmtCreate() {
		return category.getGmtCreate();
	}

	public void setGmtCreate(Date gmtCreate) {
		category.setGmtCreate(gmtCreate);
	}
	
	public ChaoCategoryDO toDO() {
		return category;
	}
}
