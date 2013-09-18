package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.dao.ChaoPushLogDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoPushLogDO;

public class IBatisChaoPushLogDAO extends SqlMapClientDaoSupport implements ChaoPushLogDAO {

	@Override
	public long insertPushLog(ChaoPushLogDO pushLog) {
		return NumberUtils.parseLong((Long) getSqlMapClientTemplate().insert("ChaoPushLog.insertPushLog" , pushLog) );
	}

}
