package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.dao.ChaoDeviceDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoDeviceDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoDeviceQuery;

public class IBatisChaoDeviceDAO extends SqlMapClientDaoSupport implements ChaoDeviceDAO {

	@Override
	public long insertDevice(ChaoDeviceDO device) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoDevice.insertDevice" , device)) ;
	}

	@Override
	public ChaoDeviceDO queryDeviceByIMEI(String imei) {
		return (ChaoDeviceDO) getSqlMapClientTemplate().queryForObject("ChaoDevice.queryDeviceByIMEI" , imei) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoDeviceDO> queryDeviceWithPagination(ChaoDeviceQuery query,int start, int size) {
		Map<String,Object> map = query.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoDevice.queryDeviceWithPagination" , map) ;
	}

	@Override
	public int countDeviceWithPagination(ChaoDeviceQuery query) {
		Map<String,Object> map = query.toMap() ;
		return NumberUtils.parseInt((Integer) getSqlMapClientTemplate().queryForObject("ChaoDevice.countDeviceWithPagination", map)) ;
	}

}
