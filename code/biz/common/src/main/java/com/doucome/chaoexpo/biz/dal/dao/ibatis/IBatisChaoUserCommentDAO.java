package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserCommentUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserCommentDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserCommentQuery;

public class IBatisChaoUserCommentDAO extends SqlMapClientDaoSupport implements ChaoUserCommentDAO {

	@Override
	public long insertComment(ChaoUserCommentDO comment) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoUserComment.insertComment" , comment)) ;
	}
	
	@Override
	public ChaoUserCommentDO queryCommentById(Long id) {
		return (ChaoUserCommentDO)getSqlMapClientTemplate().queryForObject("ChaoUserComment.queryCommentById", id) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoUserCommentDO> queryCommentsWithPagination(ChaoUserCommentQuery query, int start, int size) {
		Map<String,Object> map = query.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoUserComment.queryCommentsWithPagination" , map) ;
	}

	@Override
	public int countCommentsWithPagination(ChaoUserCommentQuery query) {
		Map<String,Object> map = query.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoUserComment.countCommentsWithPagination" , map)) ;
	}

	@Override
	public int updateCommentById(long id,ChaoUserCommentUpdateCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoUserComment.updateCommentById",map) ;
	}
	
}
