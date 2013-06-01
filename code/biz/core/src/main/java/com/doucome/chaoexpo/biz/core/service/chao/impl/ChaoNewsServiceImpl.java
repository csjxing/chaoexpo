package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoNewsDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;


public class ChaoNewsServiceImpl implements ChaoNewsService {

	@Autowired
	private ChaoNewsDAO chaoNewsDAO ;
	
	@Override
	public long createNews(ChaoNewsDO news) {
		return chaoNewsDAO.insertNews(news) ;
	}
	
	@Override
	public ChaoNewsDTO getNewsById(long id) {
		ChaoNewsDO news = chaoNewsDAO.queryNewsById(id) ;
		if(news == null) {
			return null ;
		}
		return new ChaoNewsDTO(news) ;
	}

	@Override
	public QueryResult<ChaoNewsDTO> getNewsSummarysWithPagination(ChaoNewsSearchCondition condition, Pagination pagination) {
		int totalRecords = chaoNewsDAO.countNewsSummarysWithPagination(condition);
        if (totalRecords <= 0) {
            return new QueryResult<ChaoNewsDTO>(new ArrayList<ChaoNewsDTO>(), pagination, totalRecords);
        }
        List<ChaoNewsDO> doList = chaoNewsDAO.queryNewsSummarysWithPagination(condition, pagination.getStart(), pagination.getSize()) ;
        List<ChaoNewsDTO> dtoList = new ArrayList<ChaoNewsDTO>() ;
        if(CollectionUtils.isNotEmpty(doList)){
        	for(ChaoNewsDO news : doList) {
        		dtoList.add(new ChaoNewsDTO(news)) ;
        	}
        }
        return new QueryResult<ChaoNewsDTO>(dtoList, pagination, totalRecords);
	}

	@Override
	public int updateNewsById(long id, ChaoNewsUpdateCondition condition) {
		return chaoNewsDAO.updateNewsById(id, condition) ;
	}

}
