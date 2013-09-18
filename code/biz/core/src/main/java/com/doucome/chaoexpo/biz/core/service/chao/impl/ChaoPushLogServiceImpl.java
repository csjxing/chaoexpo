package com.doucome.chaoexpo.biz.core.service.chao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.service.chao.ChaoPushLogService;
import com.doucome.chaoexpo.biz.dal.dao.ChaoPushLogDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoPushLogDO;

public class ChaoPushLogServiceImpl implements ChaoPushLogService {

	@Autowired
	private ChaoPushLogDAO chaoPushLogDAO ;
	
	@Override
	public long createPushLog(ChaoPushLogDO pushLog) {
		return chaoPushLogDAO.insertPushLog(pushLog) ;
	}

}
