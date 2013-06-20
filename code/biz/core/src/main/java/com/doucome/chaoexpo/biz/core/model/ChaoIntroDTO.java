package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoIntroDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoIntroDTO extends AbstractModel {

	private ChaoIntroDO intro ;
	
	public ChaoIntroDTO(ChaoIntroDO intro) {
		if(intro == null) {
			intro = new ChaoIntroDO() ;
		}
		this.intro = intro ;
	}
	
	public Long getId() {
		return intro.getId();
	}

	public String getHnMapPicUrls() {
		return intro.getHnMapPicUrls();
	}

	public String getHnIntro() {
		return intro.getHnIntro();
	}
	
	public String getChaoExpoIntro() {
		return intro.getChaoExpoIntro();
	}

	public Date getGmtCreate() {
		return intro.getGmtCreate();
	}

	public Date getGmtModified() {
		return intro.getGmtModified();
	}

}
