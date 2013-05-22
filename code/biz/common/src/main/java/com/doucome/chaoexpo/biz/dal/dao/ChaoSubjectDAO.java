package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;

public interface ChaoSubjectDAO {

	/**
	 * 
	 * @param subject
	 * @return
	 */
	Long insertSubject(ChaoSubjectDO subject) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoSubjectDO querySubjectById(Long id) ;
	
	/**
	 * 
	 * @param condtion
	 * @return
	 */
	List<ChaoSubjectDO> querySubjectsWithPagination(ChaoSubjectSearchCondition condtion , int start , int size) ;
	
	/**
	 * 
	 * @param condtion
	 * @return
	 */
	int countSubjectsWithPagination(ChaoSubjectSearchCondition condtion) ;
	
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateSubjectById(Long id , ChaoSubjectUpdateCondition condition) ;
}
