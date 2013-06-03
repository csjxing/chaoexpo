package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;
import com.doucome.chaoexpo.biz.core.utils.ChaoNewsUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsCatSearchCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoNewsCategoryDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;

public class ChaoNewsCategoryServiceImpl implements ChaoNewsCategoryService {

	@Autowired
	private ChaoNewsCategoryDAO chaoNewsCategoryDAO ;
	
	@Override
	public long createCategory(ChaoNewsCategoryDO cat) {
		return chaoNewsCategoryDAO.insertCategory(cat) ;
	}

	@Override
	public ChaoNewsCategoryDTO getCategoryById(Long id) {
		ChaoNewsCategoryDO cat = chaoNewsCategoryDAO.queryCategoryById(id) ;
		if(cat == null) {
			return null ;
		}
		return new ChaoNewsCategoryDTO(cat) ;
	}
	
	@Override
	public List<ChaoNewsCategoryDTO> getCategoriesByIds(List<Long> ids) {
		List<ChaoNewsCategoryDO> catList = chaoNewsCategoryDAO.queryCategoriesByIds(ids) ;
		return ChaoNewsUtils.toDTOList(catList) ;
	}

	@Override
	public QueryResult<ChaoNewsCategoryDTO> getCategoriesWithPagination(ChaoNewsCatSearchCondition condition, Pagination pagination) {
		int totalRecords = chaoNewsCategoryDAO.countCategoriesWithPagination(condition);
        if (totalRecords <= 0) {
            return new QueryResult<ChaoNewsCategoryDTO>(new ArrayList<ChaoNewsCategoryDTO>(), pagination, totalRecords);
        }
        List<ChaoNewsCategoryDO> doList = chaoNewsCategoryDAO.queryCategoriesWithPagination(condition, pagination.getStart(), pagination.getSize()) ;
        List<ChaoNewsCategoryDTO> dtoList = ChaoNewsUtils.toDTOList(doList) ;
        return new QueryResult<ChaoNewsCategoryDTO>(dtoList, pagination, totalRecords);
	}

}
