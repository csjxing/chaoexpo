package com.doucome.chaoexpo.biz.dal.dao;

import com.doucome.chaoexpo.biz.dal.condition.ChaoIntroUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoIntroDO;

public interface ChaoIntroDAO {

	/**
	 * 
	 * @param culture
	 * @return
	 */
	long insertIntro(ChaoIntroDO intro) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoIntroDO queryIntro() ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	int updateIntro(ChaoIntroUpdateCondition update) ;
	
}
