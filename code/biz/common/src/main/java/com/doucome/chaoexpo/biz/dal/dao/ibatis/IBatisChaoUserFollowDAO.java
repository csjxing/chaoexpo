package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowSearchCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserFollowDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;

public class IBatisChaoUserFollowDAO extends SqlMapClientDaoSupport implements ChaoUserFollowDAO {

	@Override
	public long insertFollow(ChaoUserFollowDO follow) {
		return NumberUtils.parseLong((Long)getSqlMapClientTemplate().insert("ChaoUserFollow.insertFollow" , follow)) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoUserFollowDO> queryFollowsWithPagination(ChaoUserFollowSearchCondition condition, int start, int size) {
		Map<String,Object> map = condition.toMap() ;
		map.put("start", start - 1) ;
		map.put("size", size) ;
		return getSqlMapClientTemplate().queryForList("ChaoUserFollow.queryFollowsWithPagination" , map);
	}

	@Override
	public int countFollowsWithPagination(ChaoUserFollowSearchCondition condition) {
		Map<String,Object> map = condition.toMap() ;
		return NumberUtils.parseInt((Integer)getSqlMapClientTemplate().queryForObject("ChaoUserFollow.countFollowsWithPagination" , map));
	}

}
