package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoCultureDTO extends AbstractModel {

	private ChaoCultureDO culture ;
	
	public ChaoCultureDTO(ChaoCultureDO culture) {
		if(culture == null) {
			culture = new ChaoCultureDO() ;
		}
		this.culture = culture ;
	}
	
	public Long getId() {
		return culture.getId();
	}

	public String getName() {
		return culture.getName();
	}

	public String getIntro() {
		return culture.getIntro();
	}

	public String getPicUrls() {
		return culture.getPicUrls();
	}

	public Date getGmtModified() {
		return culture.getGmtModified();
	}

	public Date getGmtCreate() {
		return culture.getGmtCreate();
	}
	
}
