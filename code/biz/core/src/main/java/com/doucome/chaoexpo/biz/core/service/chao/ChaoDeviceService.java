package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.List;

import com.doucome.chaoexpo.biz.core.model.ChaoDeviceDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoDeviceDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoDeviceQuery;

public interface ChaoDeviceService {

	/**
	 * 
	 * @param device
	 * @return
	 */
	long createDevice(ChaoDeviceDO device) ;
	
	/**
	 * 
	 * @param imei
	 * @return
	 */
	ChaoDeviceDTO getDeviceByIMEI(String imei) ;
	
	/**
	 * 
	 * @param query
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoDeviceDTO> getDeviceNoPagination(ChaoDeviceQuery query , int size) ;
	
	/**
	 * 
	 * @param query
	 * @param pagination
	 * @return
	 */
	QueryResult<ChaoDeviceDTO> getDeviceWithPagination(ChaoDeviceQuery query,Pagination pagination) ;
}
