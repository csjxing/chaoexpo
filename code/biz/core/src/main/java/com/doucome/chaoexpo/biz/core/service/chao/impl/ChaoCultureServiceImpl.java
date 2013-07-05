package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoCultureDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCultureService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureQuery;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoCultureDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;

public class ChaoCultureServiceImpl implements ChaoCultureService {
	
	@Autowired
	private ChaoCultureDAO chaoCultureDAO ;

	@Override
	public long createCulture(ChaoCultureDO culture) {
		return chaoCultureDAO.insertCulture(culture) ;
	}

	@Override
	public ChaoCultureDTO getCultureById(long id) {
		ChaoCultureDO culture = chaoCultureDAO.queryCultureById(id) ;
		return new ChaoCultureDTO(culture) ;
	}

	@Override
	public QueryResult<ChaoCultureDTO> getCulturesWithPagination(ChaoCultureQuery query,Pagination pagination) {
		int totalRecords = chaoCultureDAO.countCulturesWithPagination(query) ;
        if (totalRecords <= 0) {
            return new QueryResult<ChaoCultureDTO>(new ArrayList<ChaoCultureDTO>(), pagination, totalRecords);
        }
        List<ChaoCultureDO> doList = chaoCultureDAO.queryCulturesWithPagination(query ,pagination.getStart(), pagination.getSize()) ;
        List<ChaoCultureDTO> dtoList = new ArrayList<ChaoCultureDTO>() ;
        if(CollectionUtils.isNotEmpty(doList)){
        	for(ChaoCultureDO act : doList) {
        		dtoList.add(new ChaoCultureDTO(act)) ;
        	}
        }
        return new QueryResult<ChaoCultureDTO>(dtoList, pagination, totalRecords);
	}

	@Override
	public int deleteCultureById(long id) {
		return chaoCultureDAO.deleteCultureById(id) ;
	}

	@Override
	public int updateCultureById(long id, ChaoCultureUpdateCondition update) {
		return chaoCultureDAO.updateCultureById(id, update) ;
	}

}
