package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;
import com.doucome.chaoexpo.biz.core.utils.ChaoModelConvertUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoTushuoDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoQuery;

public class ChaoTushuoServiceImpl implements ChaoTushuoService {

	@Autowired
	private ChaoTushuoDAO chaoTushuoDAO ;
	
	@Override
	public long createTushuo(ChaoTushuoDO tushuo) {
		return chaoTushuoDAO.insertTushuo(tushuo) ;
	}

	@Override
	public ChaoTushuoDTO getTushuoById(Long id) {
		ChaoTushuoDO tushuo = chaoTushuoDAO.queryTushuoById(id) ;
		if(tushuo == null) {
			return null ;
		}
		return new ChaoTushuoDTO(tushuo) ; 
	}

	@Override
	public QueryResult<ChaoTushuoDTO> getTushuosWithPagination(ChaoTushuoQuery query, Pagination pagination) {
		int totalRecords = chaoTushuoDAO.countTushuosWithPagination(query);
        if (totalRecords <= 0) {
            return new QueryResult<ChaoTushuoDTO>(new ArrayList<ChaoTushuoDTO>(), pagination, totalRecords);
        }
        List<ChaoTushuoDO> tushuoList = chaoTushuoDAO.queryTushuosWithPagination(query, pagination.getStart(), pagination.getSize());
        List<ChaoTushuoDTO> dtoList = ChaoModelConvertUtils.toTushuoDTOList(tushuoList) ;
        return new QueryResult<ChaoTushuoDTO>(dtoList, pagination, totalRecords);
	}

	@Override
	public int updateTushuoById(Long id, ChaoTushuoUpdateCondition update) {
		return chaoTushuoDAO.updateTushuoById(id, update) ;
	}

	@Override
	public int updateTushuoCateById(Long id, Long newCateId) {
		return chaoTushuoDAO.updateTushuoCateById(id, newCateId) ;
	}

}
