package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoIntroUpdateCondition extends AbstractModel {

	private String hnMapPicUrls ;
	
	private String hnIntro ;
	
	private String chaoExpoIntro ;
	
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("hnMapPicUrls", hnMapPicUrls) ;
		map.put("hnIntro", hnIntro) ;
		map.put("chaoExpoIntro", chaoExpoIntro) ;
		return map ;
	}


	public String getHnMapPicUrls() {
		return hnMapPicUrls;
	}


	public void setHnMapPicUrls(String hnMapPicUrls) {
		this.hnMapPicUrls = hnMapPicUrls;
	}


	public String getHnIntro() {
		return hnIntro;
	}


	public void setHnIntro(String hnIntro) {
		this.hnIntro = hnIntro;
	}


	public String getChaoExpoIntro() {
		return chaoExpoIntro;
	}


	public void setChaoExpoIntro(String chaoExpoIntro) {
		this.chaoExpoIntro = chaoExpoIntro;
	}
	
}
