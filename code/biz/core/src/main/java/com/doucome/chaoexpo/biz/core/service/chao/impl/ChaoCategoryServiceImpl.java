package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoStatusEnum;
import com.doucome.chaoexpo.biz.core.model.ChaoCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCategoryService;
import com.doucome.chaoexpo.biz.dal.dao.ChaoCategoryDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCategoryDO;

/**
 * 
 * @author langben 2013-5-21
 *
 */
public class ChaoCategoryServiceImpl implements ChaoCategoryService {

	@Autowired
	private ChaoCategoryDAO chaoCategoryDAO ;

	@Override
	public Long createCategory(ChaoCategoryDTO category) {
		if (category == null) {
			return 0l;
		}
		return chaoCategoryDAO.insertCategory(category.toDO());
	}

	@Override
	public ChaoCategoryDTO getCategory(Long id) {
		if (IDUtils.isNotCorrect(id)) {
			return null;
		}
		ChaoCategoryDO temp = chaoCategoryDAO.queryCategory(id);
		if (temp != null) {
			return new ChaoCategoryDTO(temp);
		}
		return null;
	}

	@Override
	public QueryResult<ChaoCategoryDTO> getCategoryPage(String status, Pagination page) {
		if (page == null) {
			return new QueryResult<ChaoCategoryDTO>(new ArrayList<ChaoCategoryDTO>(), page, 0);
		}
		int count = chaoCategoryDAO.countCategory(status);
		if (count == 0) {
			return new QueryResult<ChaoCategoryDTO>(new ArrayList<ChaoCategoryDTO>(), page, 0);
		}
		List<ChaoCategoryDO> temps = chaoCategoryDAO.queryCategoryPage(status, page.getStart() - 1, page.getSize());
		return new QueryResult<ChaoCategoryDTO>(convert(temps), page, count); 
	}
	
	@Override
	public int updateCategory(ChaoCategoryDTO category) {
		if (category == null) {
			return 0;
		}
		return chaoCategoryDAO.updateCategory(category.toDO());
	}
	
	@Override
	public int updateCategoryName(Long id, String name) {
		if (IDUtils.isNotCorrect(id) || StringUtils.isEmpty(name)) {
			return 0;
		}
		return chaoCategoryDAO.updateCategoryName(id, name);
	}

	@Override
	public int updateCategoryStatus(Long id, ChaoStatusEnum statusEnum) {
		if (IDUtils.isNotCorrect(id) || statusEnum == null) {
			return 0;
		}
		return chaoCategoryDAO.updateCategoryStatus(id, statusEnum.getValue());
	}

	@Override
	public int deleteCategory(Long id) {
		if (IDUtils.isNotCorrect(id)) {
			return 0;
		}
		return chaoCategoryDAO.deleteCategory(id);
	}
	
	private List<ChaoCategoryDTO> convert(List<ChaoCategoryDO> categories) {
		List<ChaoCategoryDTO> result = new ArrayList<ChaoCategoryDTO>();
		if (CollectionUtils.isNotEmpty(categories)) {
			for (ChaoCategoryDO temp: categories) {
				result.add(new ChaoCategoryDTO(temp));
			}
		}
		return result;
	}
}
