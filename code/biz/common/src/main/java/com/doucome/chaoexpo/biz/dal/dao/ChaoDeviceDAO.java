package com.doucome.chaoexpo.biz.dal.dao;

import java.util.List;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoDeviceDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoDeviceQuery;

/**
 * 
 * @author langben 2013-9-18
 *
 */
public interface ChaoDeviceDAO {

	/**
	 * 
	 * @param device
	 * @return
	 */
	long insertDevice(ChaoDeviceDO device) ;
	
	/**
	 * 
	 * @param imei
	 * @return
	 */
	ChaoDeviceDO queryDeviceByIMEI(String imei) ;
	
	/**
	 * 
	 * @param query
	 * @param start
	 * @param size
	 * @return
	 */
	List<ChaoDeviceDO> queryDeviceWithPagination(ChaoDeviceQuery query , int start , int size) ;
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	int countDeviceWithPagination(ChaoDeviceQuery query) ;
}
