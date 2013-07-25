package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.condition.ChaoUserCommentUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserCommentQuery;

/**
 * 评论
 * @author langben 2013-7-24
 *
 */
public interface ChaoUserCommentDAO {

	/**
	 * 
	 * @param comment
	 * @return
	 */
	long insertComment(ChaoUserCommentDO comment) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoUserCommentDO queryCommentById(Long id) ;
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	List<ChaoUserCommentDO> queryCommentsWithPagination(ChaoUserCommentQuery query , int start , int size) ;
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	int countCommentsWithPagination(ChaoUserCommentQuery query) ;
	
	/**
	 * 
	 * @param id
	 * @param condition
	 * @return
	 */
	int updateCommentById(long id , ChaoUserCommentUpdateCondition condition) ;
}
