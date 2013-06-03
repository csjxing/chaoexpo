package com.doucome.chaoexpo.biz.core.service.chao;

import com.doucome.chaoexpo.biz.core.enums.ChaoStatusEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;

public interface ChaoCategoryService {
	/**
	 * 
	 * @param category
	 * @return
	 */
	Long createCategory(ChaoCategoryDTO category);
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoCategoryDTO getCategory(Long id);
	/**
	 * 
	 * @return
	 */
	QueryResult<ChaoCategoryDTO> getCategoryPage(String status, Pagination page);
	/**
	 * 
	 * @param category
	 * @return
	 */
	int updateCategory(ChaoCategoryDTO category);
	/**
	 * 
	 * @param category
	 * @return
	 */
	int updateCategoryName(Long id, String name);
	/**
	 * 
	 * @param id
	 * @param statusEnum
	 * @return
	 */
	int updateCategoryStatus(Long id, ChaoStatusEnum statusEnum);
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteCategory(Long id);
}
