package com.doucome.chaoexpo.biz.core.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.YesNoEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.core.utils.ChaoDisplayOrderUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;

public class ChaoNewsBO {
	
	private static final Log logger = LogFactory.getLog(ChaoNewsBO.class);

	@Autowired
	private ChaoNewsService chaoNewsService ;
	@Autowired
	private ChaoNewsCategoryService chaoNewsCategoryService;
	
	/**
	 * 获取新闻详情.
	 * @param newsId
	 * @return
	 */
	public ResultModel<ChaoNewsDTO> getNewsDetail(Long newsId) {
		ResultModel<ChaoNewsDTO> result = new ResultModel<ChaoNewsDTO>();
		if (IDUtils.isNotCorrect(newsId)) {
			result.setFail("param.error");
			return result;
		}
		try {
			ChaoNewsDTO newsDTO = chaoNewsService.getNewsById(newsId);
			if (newsDTO != null) {
				if (newsDTO.getCategoryId() != null) {
					ChaoNewsCategoryDTO category = chaoNewsCategoryService.getCategoryById(newsDTO.getCategoryId());
				    newsDTO.setCategoryName(category != null? category.getCatName(): null);
				}
				result.setSuccess(newsDTO);
			} else {
				result.setFail("news.not.exist");
			}
		} catch(Exception e) {
			logger.error(e);
			result.setFail("internal.exception");
		}
		return result;
	}
	
	/**
	 * 获取新闻摘要列表.
	 * @param condition
	 * @param page
	 * @return
	 */
	public ResultModel<QueryResult<ChaoNewsDTO>> getNewsSummaryPage(ChaoNewsSearchCondition condition, Pagination page) {
		ResultModel<QueryResult<ChaoNewsDTO>> result = new ResultModel<QueryResult<ChaoNewsDTO>>();
		if (condition == null || page == null) {
			result.setFail("param.error");
			return result;
		}
		try {
			QueryResult<ChaoNewsDTO> newsResult = chaoNewsService.getNewsSummarysWithPagination(condition, page);
			List<ChaoNewsDTO> news = newsResult.getItems();
			Set<Long> categoryIds = new HashSet<Long>();
			for (ChaoNewsDTO temp: news) {
				if (temp.getCategoryId() != null) {
				    categoryIds.add(temp.getCategoryId());
				}
				temp.setContent("");
			}
			List<ChaoNewsCategoryDTO> categories = chaoNewsCategoryService.getCategoriesByIds(new ArrayList<Long>(categoryIds));
			for (ChaoNewsDTO temp: news) {
				for (ChaoNewsCategoryDTO cate: categories) {
					if (cate.getId().equals(temp.getCategoryId())) {
						temp.setCategoryName(cate.getCatName());
						break;
					}
				}
			}
			result.setSuccess(newsResult);
		} catch (Exception e) {
			logger.error(e);
			result.setFail("internal.exception");
		}
		return result;
	}
	
	/**
	 * 
	 * @param id
	 * @param topEnum
	 * @return
	 */
	public ResultModel<Integer> resetNewsToTop(Long id, YesNoEnum topEnum) {
		ResultModel<Integer> result = new ResultModel<Integer>();
		if (IDUtils.isNotCorrect(id) || topEnum == null || topEnum == YesNoEnum.UNKNOWN) {
			result.setFail("param.error");
			return result;
		}
		ChaoNewsUpdateCondition condition = new ChaoNewsUpdateCondition();
		condition.setIsTop(topEnum.getValue());
		int count = chaoNewsService.updateNewsById(id, condition);
		if (count == 0) {
			result.setFail("news.not.exist");
		} else {
			result.setSuccess(count);
		}
		return result;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ResultModel<Integer> moveNewsToFirst(Long id) {
		ResultModel<Integer> result = new ResultModel<Integer>();
		if (IDUtils.isNotCorrect(id)) {
			result.setFail("param.error");
			return result;
		}
		ChaoNewsUpdateCondition condition = new ChaoNewsUpdateCondition();
		condition.setDisplayOrder(ChaoDisplayOrderUtils.getDisplayOrder());
		int count = chaoNewsService.updateNewsById(id, condition);
		if (count == 0) {
			result.setFail("news.not.exist");
		} else {
			result.setSuccess(count);
		}
		return result;
	}
}
