package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoDeviceDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoDeviceService;
import com.doucome.chaoexpo.biz.core.utils.ChaoModelConvertUtils;
import com.doucome.chaoexpo.biz.dal.dao.ChaoDeviceDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoDeviceDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoDeviceQuery;

public class ChaoDeviceServiceImpl implements ChaoDeviceService {

	@Autowired
	private ChaoDeviceDAO chaoDeviceDAO ;
	
	@Override
	public long createDevice(ChaoDeviceDO device) {
		return chaoDeviceDAO.insertDevice(device) ;
	}

	@Override
	public ChaoDeviceDTO getDeviceByIMEI(String imei) {
		ChaoDeviceDO device = chaoDeviceDAO.queryDeviceByIMEI(imei) ;
		if(device == null) {
			return null ;
		}
		return new ChaoDeviceDTO(device) ;
	}

	@Override
	public List<ChaoDeviceDTO> getDeviceNoPagination(ChaoDeviceQuery query,int size) {
		List<ChaoDeviceDO> doList = chaoDeviceDAO.queryDeviceWithPagination(query, 1, size) ;
		return ChaoModelConvertUtils.toDeviceDTOList(doList) ;
	}

	@Override
	public QueryResult<ChaoDeviceDTO> getDeviceWithPagination(ChaoDeviceQuery query, Pagination pagination) {
		int totalRecords = chaoDeviceDAO.countDeviceWithPagination(query) ;
        if (totalRecords <= 0) {
            return new QueryResult<ChaoDeviceDTO>(new ArrayList<ChaoDeviceDTO>(), pagination, totalRecords);
        }
        List<ChaoDeviceDO> doList = chaoDeviceDAO.queryDeviceWithPagination(query,pagination.getStart(),pagination.getSize()) ;
        List<ChaoDeviceDTO> dtoList = ChaoModelConvertUtils.toDeviceDTOList(doList) ;
        return new QueryResult<ChaoDeviceDTO>(dtoList, pagination, totalRecords);
	}

}
