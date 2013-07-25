package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.model.ChaoUserCommentDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserCommentUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserCommentQuery;

/**
 * 
 * @author langben 2013-7-24
 *
 */
public interface ChaoUserCommentService {

	/**
	 * 
	 * @param comment
	 * @return
	 */
	long createComment(ChaoUserCommentDO comment) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoUserCommentDTO getCommentById(Long id) ;
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	QueryResult<ChaoUserCommentDTO> getCommentsWithPagination(ChaoUserCommentQuery query , Pagination pagination) ;
	
	
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateCommentById(long id , ChaoUserCommentUpdateCondition condition) ;
	
}
