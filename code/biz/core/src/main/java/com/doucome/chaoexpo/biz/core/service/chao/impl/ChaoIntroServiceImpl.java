package com.doucome.chaoexpo.biz.core.service.chao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoIntroDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoIntroService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoIntroUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoIntroDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoIntroDO;

public class ChaoIntroServiceImpl implements ChaoIntroService {

	@Autowired
	private ChaoIntroDAO chaoIntroDAO ;
	
	@Override
	public long createIntro(ChaoIntroDO intro) {
		return chaoIntroDAO.insertIntro(intro) ;
	}

	@Override
	public ChaoIntroDTO getIntro() {
		ChaoIntroDO intro = chaoIntroDAO.queryIntro();
		if(intro == null) {
			return null ;
		}
		return new ChaoIntroDTO(intro) ;
	}

	@Override
	public int updateIntro(ChaoIntroUpdateCondition update) {
		return chaoIntroDAO.updateIntro(update) ;
	}

}
