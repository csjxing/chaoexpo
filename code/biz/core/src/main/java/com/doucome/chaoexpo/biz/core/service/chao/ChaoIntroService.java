package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoIntroDTO;
import com.doucome.chaoexpo.biz.dal.condition.ChaoIntroUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoIntroDO;

public interface ChaoIntroService {

	/**
	 * 
	 * @param culture
	 * @return
	 */
	long createIntro(ChaoIntroDO intro) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoIntroDTO getIntro() ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	int updateIntro(ChaoIntroUpdateCondition update) ;
	
}
