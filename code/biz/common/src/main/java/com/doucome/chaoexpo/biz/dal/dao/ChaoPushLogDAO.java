package com.doucome.chaoexpo.biz.dal.dao;

import com.doucome.chaoexpo.biz.dal.dataobject.ChaoPushLogDO;

/**
 * 
 * @author langben 2013-9-18
 *
 */
public interface ChaoPushLogDAO {

	/**
	 * 
	 * @param device
	 * @return
	 */
	long insertPushLog(ChaoPushLogDO pushLog) ;
	
}
