package com.doucome.chaoexpo.biz.core.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.TushuoStatusEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoCateUpdateCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
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
			Long cateId = tushuo.getCategoryId() ;
			if(IDUtils.isCorrect(cateId)){
				ChaoTushuoCateUpdateCondition update = new ChaoTushuoCateUpdateCondition() ;
				update.setIncrTushuoCount(1) ;
				chaoTushuoCategoryService.updateCategoryById(cateId , update) ;
			}
		}
		return newId ;
	}
	
	@Transactional
	public int updateTushuoById(Long id , ChaoTushuoUpdateCondition update , Long newCateId) {
		ChaoTushuoDTO ts = chaoTushuoService.getTushuoById(id) ;
		if(ts == null) {
			return 0 ;
		}
		int effectCount = chaoTushuoService.updateTushuoById(id, update) ;
		this.updateCateById(id, newCateId) ;
		return effectCount ;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public int updateStatus(Long id , TushuoStatusEnums status) {
		ChaoTushuoUpdateCondition condition = new ChaoTushuoUpdateCondition() ;
		condition.setStatus(status.getValue()) ;
		int effectCount = chaoTushuoService.updateTushuoById(id, condition) ;
		if(effectCount >= 1) {
			ChaoTushuoDTO ts = chaoTushuoService.getTushuoById(id) ;
			Long cateId = ts.getCategoryId() ;
			if(IDUtils.isCorrect(cateId)){
				if(status == TushuoStatusEnums.NORMAL) {
					ChaoTushuoCateUpdateCondition update = new ChaoTushuoCateUpdateCondition() ;
					update.setIncrTushuoCount(1) ;
					chaoTushuoCategoryService.updateCategoryById(cateId , update) ;
				} else {
					ChaoTushuoCateUpdateCondition update = new ChaoTushuoCateUpdateCondition() ;
					update.setDecrTushuoCount(1) ;
					chaoTushuoCategoryService.updateCategoryById(cateId , update) ;
				}
			}
		}
		return effectCount ;
	}
	
	/**
	 * 
	 * @param id
	 * @param newCateId
	 * @return
	 */
	@Transactional
	public int updateCateById(Long id , Long newCateId) {
		
		if(IDUtils.isNotCorrect(id)) {
			throw new IllegalArgumentException("chao.tushuo.updateCate.id.error") ;
		}
		
		if(IDUtils.isNotCorrect(newCateId)) {
			throw new IllegalArgumentException("chao.tushuo.updateCate.cateId.error") ;
		}
		
		ChaoTushuoCategoryDTO cate = chaoTushuoCategoryService.getCategoryById(newCateId) ;
		ChaoTushuoDTO ts = chaoTushuoService.getTushuoById(id) ;
		
		if(ts == null) {
			return 0 ;
		}
		
		if(cate == null) {
			newCateId = 0L ;
		}
		
		Long oldCateId = ts.getCategoryId() ;
		
		int effectCount = chaoTushuoService.updateTushuoCateById(id, newCateId) ;
		
		if(effectCount > 0) {
			if(IDUtils.isCorrect(oldCateId)) {
				ChaoTushuoCateUpdateCondition u = new ChaoTushuoCateUpdateCondition() ;
				u.setDecrTushuoCount(1) ;
				chaoTushuoCategoryService.updateCategoryById(oldCateId, u) ;
			}
			
			if(IDUtils.isCorrect(newCateId)) {
				ChaoTushuoCateUpdateCondition u = new ChaoTushuoCateUpdateCondition() ;
				u.setIncrTushuoCount(1) ;
				chaoTushuoCategoryService.updateCategoryById(newCateId, u) ;
			}
		}
		
		return effectCount ;
	}
	
}
