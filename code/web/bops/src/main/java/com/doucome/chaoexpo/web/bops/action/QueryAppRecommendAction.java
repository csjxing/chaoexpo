package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoAppRecommendService;

public class QueryAppRecommendAction extends BopsBasicAction {

	private Long id ;
	
	private ChaoAppRecommendDTO recommend  ;
	
	@Autowired
	private ChaoAppRecommendService chaoAppRecommendService ;
	
	@Override
	public String execute() throws Exception {
		if(IDUtils.isCorrect(id)) {
			recommend = chaoAppRecommendService.getRecommendById(id) ;
		}
		return SUCCESS ;
	}

	public ChaoAppRecommendDTO getRecommend() {
		return recommend;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
