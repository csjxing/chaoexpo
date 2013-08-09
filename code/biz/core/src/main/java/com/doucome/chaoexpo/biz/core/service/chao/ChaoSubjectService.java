package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoSubjectQuery;

public interface ChaoSubjectService {

	/**
	 * 
	 * @param subject
	 * @return
	 */
	Long createSubject(ChaoSubjectDO subject) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoSubjectDTO getSubjectById(Long id) ;
	
	/**
	 * 
	 * @param condtion
	 * @return
	 */
	QueryResult<ChaoSubjectDTO> getSubjectsWithPagination(ChaoSubjectQuery condtion , Pagination pagination) ;
	
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateSubjectById(Long id , ChaoSubjectUpdateCondition condition) ;
	/**
	 * 
	 * @param subjectDTO
	 * @return
	 */
	int updateSubject(ChaoSubjectDTO subjectDTO);
}
