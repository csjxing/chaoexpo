package com.doucome.chaoexpo.biz.core.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.TrueOrFalseEnums;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;

public class ChaoNewsBO {

	@Autowired
	private ChaoNewsService chaoNewsService ;
	
	/**
	 * 置顶
	 * @return
	 */
	public int moveNewsTop(long id) {
		ChaoNewsUpdateCondition condition = new ChaoNewsUpdateCondition() ;
		condition.setIsTop(TrueOrFalseEnums.TRUE.getValue()) ;
		return chaoNewsService.updateNewsById(id, condition) ;
	}
	
}
