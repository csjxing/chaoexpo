package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoSubjectQuery;

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
	List<ChaoSubjectDO> querySubjectsWithPagination(ChaoSubjectQuery condtion , int start , int size) ;
	
	/**
	 * 
	 * @param condtion
	 * @return
	 */
	int countSubjectsWithPagination(ChaoSubjectQuery condtion) ;
	
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateSubjectById(Long id , ChaoSubjectUpdateCondition condition) ;
	/**
	 * 
	 * @param subject
	 * @return
	 */
	int updateSubject(ChaoSubjectDO subject);
}
