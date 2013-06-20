package com.doucome.chaoexpo.biz.core.model;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoFirstReadDTO extends AbstractModel {

	private List<ChaoCultureDTO> cultureList ;
	
	private ChaoIntroDTO intro ;

	public List<ChaoCultureDTO> getCultureList() {
		return cultureList;
	}

	public void setCultureList(List<ChaoCultureDTO> cultureList) {
		this.cultureList = cultureList;
	}

	public ChaoIntroDTO getIntro() {
		return intro;
	}

	public void setIntro(ChaoIntroDTO intro) {
		this.intro = intro;
	}

}
