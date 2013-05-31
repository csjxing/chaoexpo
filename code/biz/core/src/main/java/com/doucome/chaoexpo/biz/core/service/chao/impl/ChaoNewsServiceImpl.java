package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoNewsDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class ChaoNewsServiceImpl implements ChaoNewsService {

	@Autowired
	private ChaoNewsDAO chaoNewsDAO;

	@Override
	public Long createNews(ChaoNewsDTO news) {
		if (news == null) {
			return 0l;
		}
		return chaoNewsDAO.insertNews(news.toDO());
	}

	@Override
	public ChaoNewsDTO getNews(Long id) {
		if (IDUtils.isNotCorrect(id)) {
			return null;
		}
		ChaoNewsDO news = chaoNewsDAO.queryNews(id);
		if (news == null) {
			return null;
		}
		return new ChaoNewsDTO(news);
	}

	@Override
	public QueryResult<ChaoNewsDTO> getNewsPage(ChaoNewsCondition condition, Pagination page) {
		if (condition == null) {
			condition = new ChaoNewsCondition();
		}
		int count = chaoNewsDAO.countNews(condition);
		if (count == 0) {
			return new QueryResult<ChaoNewsDTO>(new ArrayList<ChaoNewsDTO>(), page, 0);
		}
		List<ChaoNewsDO> newsDOs = chaoNewsDAO.queryNewsPage(condition, page.getStart() - 1, page.getSize());
		return new QueryResult<ChaoNewsDTO>(convert(newsDOs), page, count);
	}

	@Override
	public int updateNews(ChaoNewsDTO news) {
		if (news == null) {
			return 0;
		}
		return chaoNewsDAO.updateNews(news.toDO());
	}

	@Override
	public int moveNewsFront(Long id) {
		if (IDUtils.isNotCorrect(id)) {
			return 0;
		}
		return chaoNewsDAO.updateNewsDisplayOrder(id);
	}
	
	private List<ChaoNewsDTO> convert(List<ChaoNewsDO> news) {
		List<ChaoNewsDTO> result = new ArrayList<ChaoNewsDTO>();
		if (CollectionUtils.isNotEmpty(news)) {
			for (ChaoNewsDO temp: news) {
				result.add(new ChaoNewsDTO(temp));
			}
		}
		return result;
		
	}
}
