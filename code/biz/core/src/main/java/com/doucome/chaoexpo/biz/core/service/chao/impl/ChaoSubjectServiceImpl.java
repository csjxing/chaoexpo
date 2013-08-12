package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.ChaoSubjectStatusEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoSubjectDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoSubjectQuery;

public class ChaoSubjectServiceImpl implements ChaoSubjectService {

	@Autowired
	private ChaoSubjectDAO chaoSubjectDAO ;
	
	@Override
	public Long createSubject(ChaoSubjectDTO subject) {
		subject.setStatus(ChaoSubjectStatusEnum.NORMAL.getValue());
		return chaoSubjectDAO.insertSubject(subject.toDO()) ;
	}

	@Override
	public ChaoSubjectDTO getSubjectById(Long id) {
		ChaoSubjectDO subject = chaoSubjectDAO.querySubjectById(id) ;
		if(subject == null) {
			return null ;
		}
		return new ChaoSubjectDTO(subject) ;
	}

	@Override
	public QueryResult<ChaoSubjectDTO> getSubjectsWithPagination(ChaoSubjectQuery condition, Pagination pagination) {
		int totalRecords = chaoSubjectDAO.countSubjectsWithPagination(condition);
        if (totalRecords <= 0) {
            return new QueryResult<ChaoSubjectDTO>(new ArrayList<ChaoSubjectDTO>(), pagination, totalRecords);
        }
        List<ChaoSubjectDO> doList = chaoSubjectDAO.querySubjectsWithPagination(condition, pagination.getStart(), pagination.getSize()) ;
        List<ChaoSubjectDTO> dtoList = new ArrayList<ChaoSubjectDTO>() ;
        if(CollectionUtils.isNotEmpty(doList)){
        	for(ChaoSubjectDO act : doList) {
        		dtoList.add(new ChaoSubjectDTO(act)) ;
        	}
        }
        return new QueryResult<ChaoSubjectDTO>(dtoList, pagination, totalRecords);
	}

	@Override
	public int updateSubjectById(Long id, ChaoSubjectUpdateCondition condition) {
		return chaoSubjectDAO.updateSubjectById(id, condition) ;
	}
	
	@Override
	public int updateSubject(ChaoSubjectDTO subject) {
		if (subject != null) {
			return chaoSubjectDAO.updateSubject(subject.toDO());
		}
		return 0;
	}
}
