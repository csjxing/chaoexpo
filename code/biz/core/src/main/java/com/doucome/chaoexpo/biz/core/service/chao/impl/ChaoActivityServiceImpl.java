package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivitySearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoActivityDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;

/**
 * 
 * @author langben 2013-5-21
 *
 */
public class ChaoActivityServiceImpl implements ChaoActivityService {

	@Autowired
	private ChaoActivityDAO chaoActivityDAO ;
	
	@Override
	public Long createActivity(ChaoActivityDO activity) {
		return chaoActivityDAO.insertActivity(activity) ;
	}

	@Override
	public ChaoActivityDTO getActivityById(Long id) {
		ChaoActivityDO act = chaoActivityDAO.queryActivityById(id) ;
		if(act == null) {
			return null ;
		}
		return new ChaoActivityDTO(act) ;
	}

	@Override
	public QueryResult<ChaoActivityDTO> getActivityWithPagination(ChaoActivitySearchCondition condition, Pagination pagination) {
		int totalRecords = chaoActivityDAO.countActivityWithPagination(condition);
        if (totalRecords <= 0) {
            return new QueryResult<ChaoActivityDTO>(new ArrayList<ChaoActivityDTO>(), pagination, totalRecords);
        }
        List<ChaoActivityDO> doList = chaoActivityDAO.queryActivityWithPagination(condition, pagination.getStart(), pagination.getSize()) ;
        List<ChaoActivityDTO> dtoList = new ArrayList<ChaoActivityDTO>() ;
        if(CollectionUtils.isNotEmpty(doList)){
        	for(ChaoActivityDO act : doList) {
        		dtoList.add(new ChaoActivityDTO(act)) ;
        	}
        }
        return new QueryResult<ChaoActivityDTO>(dtoList, pagination, totalRecords);
	}

	@Override
	public int updateActivityById(Long id, ChaoActivityUpdateCondition condition) {
		return chaoActivityDAO.updateActivityById(id, condition) ;
	}

}
