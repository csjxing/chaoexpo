package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoQuery;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoTushuoDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;

public class IBatisChaoTushuoDAO  extends SqlMapClientDaoSupport implements ChaoTushuoDAO {

	@Override
	public long insertTushuo(ChaoTushuoDO tushuo) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoTushuo.insertTushuo" , tushuo)) ;
	}

	@Override
	public ChaoTushuoDO queryTushuoById(Long id) {
		return (ChaoTushuoDO)getSqlMapClientTemplate().queryForObject("ChaoTushuo.queryTushuoById", id) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoTushuoDO> queryTushuosWithPagination(ChaoTushuoQuery query,int start, int size) {
		Map<String,Object> map = query.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoTushuo.queryTushuosWithPagination" , map) ;
	}

	@Override
	public int countTushuosWithPagination(ChaoTushuoQuery query) {
		Map<String,Object> map = query.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoTushuo.countTushuosWithPagination" ,map)) ;
	}

	@Override
	public int updateTushuoById(Long id, ChaoTushuoUpdateCondition update) {
		Map<String,Object> map = update.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoTushuo.updateTushuoById" , map) ;
	}

}
