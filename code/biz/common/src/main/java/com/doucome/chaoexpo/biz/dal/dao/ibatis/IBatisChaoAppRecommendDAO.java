package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendQuery;
import com.doucome.chaoexpo.biz.dal.condition.ChaoAppRecommendUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoAppRecommendDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;

public class IBatisChaoAppRecommendDAO extends SqlMapClientDaoSupport implements ChaoAppRecommendDAO {

	@Override
	public long insertRecommend(ChaoAppRecommendDO recommend) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoAppRecommend.insertRecommend" , recommend));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoAppRecommendDO> queryRecommendWithPagination(ChaoAppRecommendQuery query, int start, int size) {
		Map<String,Object> map = query.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoAppRecommend.queryRecommendsWithPagination" , map);
	}

	@Override
	public int countRecommendWithPagination(ChaoAppRecommendQuery query) {
		Map<String,Object> map = query.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoAppRecommend.countRecommendsWithPagination",map)) ;
	}

	@Override
	public int updateRecommendById(long id , ChaoAppRecommendUpdateCondition update) {
		Map<String,Object> map = update.toMap() ;
		map.put("id", id) ;
		return getSqlMapClientTemplate().update("ChaoAppRecommend.updateRecommendById" , map);
	}

	@Override
	public int deleteRecommendById(long id) {
		return getSqlMapClientTemplate().delete("ChaoAppRecommend.deleteRecommendById" , id) ;
	}

	@Override
	public ChaoAppRecommendDO queryRecommendById(long id) {
		return (ChaoAppRecommendDO)getSqlMapClientTemplate().queryForObject("ChaoAppRecommend.queryRecommendById",id) ;
	}

}
