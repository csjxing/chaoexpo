package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoAppRecommendService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;
import com.opensymphony.xwork2.ModelDriven;

public class AddAppRecommendAction extends BopsBasicAction implements ModelDriven<ChaoAppRecommendDO>{

	private ChaoAppRecommendDO recommend = new ChaoAppRecommendDO() ;
	
	@Autowired
	private ChaoAppRecommendService chaoAppRecommendService ;
	
	@Override
	public String execute() throws Exception {
		
		if(IDUtils.isCorrect(recommend.getId())){
			//修改
			ChaoAppRecommendUpdateCondition condition = ChaoAppRecommendUpdateCondition.fromAppRecommend(recommend) ;
			chaoAppRecommendService.updateRecommendById(recommend.getId(),condition ) ;
		} else {
			chaoAppRecommendService.createRecommend(recommend) ;
		}
		
		return SUCCESS ;
	}
	
	@Override
	public ChaoAppRecommendDO getModel() {
		return recommend;
	}

	public ChaoAppRecommendDO getRecommend() {
		return recommend;
	}

	public void setRecommend(ChaoAppRecommendDO recommend) {
		this.recommend = recommend;
	}

}
