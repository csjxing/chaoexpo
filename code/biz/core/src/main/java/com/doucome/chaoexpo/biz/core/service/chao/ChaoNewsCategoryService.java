package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.List;

import com.doucome.chaoexpo.biz.core.enums.ChaoStatusEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCatSearchCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;

public interface ChaoNewsCategoryService {

	/**
	 * 
	 * @param news
	 * @return
	 */
	long createCategory(ChaoNewsCategoryDO cat) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ChaoNewsCategoryDTO getCategoryById(Long id) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<ChaoNewsCategoryDTO> getCategoriesByIds(List<Long> ids) ;

	/**
	 * 
	 * @param condition
	 * @param start
	 * @param size
	 * @return
	 */
	QueryResult<ChaoNewsCategoryDTO> getCategoriesWithPagination(ChaoNewsCatSearchCondition condition , Pagination pagination) ;
	/**
	 * 
	 * @param category
	 * @return
	 */
	int updateCategory(ChaoNewsCategoryDTO category);
	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	int updateStstus(Long id, ChaoStatusEnum status);
}
