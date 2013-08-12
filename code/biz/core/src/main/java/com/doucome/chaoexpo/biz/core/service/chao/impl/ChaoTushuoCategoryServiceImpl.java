package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.biz.core.utils.ChaoModelConvertUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoCateUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoTushuoCategoryDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoCategoryQuery;

public class ChaoTushuoCategoryServiceImpl implements ChaoTushuoCategoryService {

	@Autowired
	private ChaoTushuoCategoryDAO chaoTushuoCategoryDAO ;
	
	@Override
	public long createCategory(ChaoTushuoCategoryDO category) {
		return chaoTushuoCategoryDAO.insertCategory(category) ;
	}
	
	@Override
	public ChaoTushuoCategoryDTO getCategoryById(long id) {
		ChaoTushuoCategoryDO cate = chaoTushuoCategoryDAO.queryCategoryById(id) ;
		if(cate == null) {
			return null ;
		}
		return new ChaoTushuoCategoryDTO(cate) ;
	}


	@Override
	public List<ChaoTushuoCategoryDTO> getCategories(ChaoTushuoCategoryQuery query) {
		List<ChaoTushuoCategoryDO> catList = chaoTushuoCategoryDAO.queryCategories(query) ;
		return ChaoModelConvertUtils.toTushuoCateDTOList(catList) ;
	}

	@Override
	public int updateCategoryById(long id,
			ChaoTushuoCateUpdateCondition condition) {
		return chaoTushuoCategoryDAO.updateCategoryById(id, condition) ;
	}

	
}
