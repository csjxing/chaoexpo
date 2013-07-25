package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserCommentDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserCommentService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserCommentUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserCommentDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserCommentQuery;

public class ChaoUserCommentServiceImpl implements ChaoUserCommentService {

	@Autowired
	private ChaoUserCommentDAO chaoUserCommentDAO ;
	
	@Override
	public long createComment(ChaoUserCommentDO comment) {
		return chaoUserCommentDAO.insertComment(comment) ;
	}
	
	@Override
	public ChaoUserCommentDTO getCommentById(Long id) {
		ChaoUserCommentDO c = chaoUserCommentDAO.queryCommentById(id) ;
		if(c == null) {
			return null ;
		}
		return new ChaoUserCommentDTO(c) ;
	}

	@Override
	public QueryResult<ChaoUserCommentDTO> getCommentsWithPagination(ChaoUserCommentQuery query, Pagination pagination) {
		int totalRecords = chaoUserCommentDAO.countCommentsWithPagination(query) ;
        if (totalRecords <= 0) {
            return new QueryResult<ChaoUserCommentDTO>(new ArrayList<ChaoUserCommentDTO>(), pagination, totalRecords);
        }
        List<ChaoUserCommentDO> doList = chaoUserCommentDAO.queryCommentsWithPagination(query,pagination.getStart(),pagination.getSize()) ;
        List<ChaoUserCommentDTO> dtoList = new ArrayList<ChaoUserCommentDTO>() ;
        if(CollectionUtils.isNotEmpty(doList)){
        	for(ChaoUserCommentDO c : doList) {
        		dtoList.add(new ChaoUserCommentDTO(c)) ;
        	}
        }
        return new QueryResult<ChaoUserCommentDTO>(dtoList, pagination, totalRecords);
	}

	@Override
	public int updateCommentById(long id,ChaoUserCommentUpdateCondition condition) {
		return chaoUserCommentDAO.updateCommentById(id, condition) ;
	}
}
