package com.doucome.chaoexpo.biz.core.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;

public class ChaoTushuoBO {

	@Autowired
	private ChaoTushuoService chaoTushuoService ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	/**
	 * 
	 * @param tushuo
	 * @return
	 */
	@Transactional
	public long createTushuo(ChaoTushuoDO tushuo) {
		long newId = chaoTushuoService.createTushuo(tushuo) ;
		if(IDUtils.isCorrect(newId)) {
			if(tushuo.get)
			chaoTushuoCategoryService.updateCategoryById(id, condition) ;
		}
	}
	
}
