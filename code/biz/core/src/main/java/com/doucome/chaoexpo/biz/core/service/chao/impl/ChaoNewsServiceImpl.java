package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.TrueOrFalseEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.core.utils.ChaoDisplayOrderUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;
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
	public QueryResult<ChaoNewsDTO> getNewsSummarysWithPagination(ChaoNewsSearchCondition condition, Pagination page) {
		int count = chaoNewsDAO.countNewsSummarysWithPagination(condition);
        if (count <= 0) {
            return new QueryResult<ChaoNewsDTO>(new ArrayList<ChaoNewsDTO>(), page, count);
        }
        List<ChaoNewsDO> newsDOs = chaoNewsDAO.queryNewsSummarysWithPagination(condition, page.getStart() - 1, page.getSize());
        return new QueryResult<ChaoNewsDTO>(convert(newsDOs), page, count);
	}
	
	@Override
	public QueryResult<ChaoNewsDTO> getNewsPage(ChaoNewsCondition condition, Pagination page) {
		int count = chaoNewsDAO.countNews(condition);
		if (count == 0) {
			return new QueryResult<ChaoNewsDTO>(new ArrayList<ChaoNewsDTO>(), page, count);
		}
		List<ChaoNewsDO> temps = chaoNewsDAO.queryNewsPage(condition, page.getStart() - 1, page.getSize());
		return new QueryResult<ChaoNewsDTO>(convert(temps), page, count);
	}

	@Override
	public int updateNewsById(long id, ChaoNewsUpdateCondition condition) {
		return chaoNewsDAO.updateNewsById(id, condition) ;
	}

	@Override
	public int updateNews(ChaoNewsDTO news) {
		if (news == null) {
			return 0;
		}
		return chaoNewsDAO.updateNews(news.toDO());
	}
	
	private List<ChaoNewsDTO> convert(List<ChaoNewsDO> chaoNews) {
		List<ChaoNewsDTO> result = new ArrayList<ChaoNewsDTO>() ;
        if(CollectionUtils.isNotEmpty(chaoNews)){
        	for(ChaoNewsDO news : chaoNews) {
        		result.add(new ChaoNewsDTO(news)) ;
        	}
        }
        return result;
	}
	
}