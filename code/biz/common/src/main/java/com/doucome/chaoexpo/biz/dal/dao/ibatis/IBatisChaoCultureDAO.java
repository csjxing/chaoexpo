package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureQuery;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoCultureDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;

/**
 * 
 * @author langben 2013-6-20
 *
 */
public class IBatisChaoCultureDAO extends SqlMapClientDaoSupport implements ChaoCultureDAO {

	@Override
	public long insertCulture(ChaoCultureDO culture) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoCulture.insertCulture" , culture)) ;
	}

	@Override
	public ChaoCultureDO queryCultureById(long id) {
		return (ChaoCultureDO)getSqlMapClientTemplate().queryForObject("ChaoCulture.queryCultureById" , id) ;
	}

	@Override
	public List<ChaoCultureDO> queryCulturesWithPagination(ChaoCultureQuery query,int start, int size) {
		Map<String,Object> map = query.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoCulture.queryCulturesWithPagination" , map) ;
	}

	@Override
	public int countCulturesWithPagination(ChaoCultureQuery query) {
		Map<String,Object> map = query.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoCulture.countCulturesWithPagination" , map)) ;
	}

	@Override
	public int deleteCultureById(long id) {
		return getSqlMapClientTemplate().delete("ChaoCulture.deleteCultureById" , id) ;
	}

	@Override
	public int updateCultureById(long id, ChaoCultureUpdateCondition update) {
		Map<String,Object> map = update.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoCulture.updateCultureById" , map) ;
	}

}
