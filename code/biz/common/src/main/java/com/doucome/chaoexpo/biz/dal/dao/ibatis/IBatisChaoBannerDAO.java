package com.doucome.chaoexpo.biz.dal.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.doucome.chaoexpo.biz.dal.condition.ChaoBannerCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoBannerDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoBannerDO;

public class IBatisChaoBannerDAO extends SqlMapClientDaoSupport implements ChaoBannerDAO {

	@Override
	public Long insertBanner(ChaoBannerDO banner) {
		return (Long) getSqlMapClientTemplate().insert("chaoBanner.insertBanner", banner);
	}

	@Override
	public ChaoBannerDO queryBanner(Long id) {
		return (ChaoBannerDO) getSqlMapClientTemplate().queryForObject("chaoBanner.queryBanner", id);
	}

	@Override
	public ChaoBannerDO queryBanner(String bannerId) {
		return (ChaoBannerDO) getSqlMapClientTemplate().queryForObject("chaoBanner.queryBannerByBannerId", bannerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChaoBannerDO> queryBannerPage(ChaoBannerCondition condition, int start, int size) {
		Map<String, Object> params = condition.toMap();
		params.put("start", start);
		params.put("size", size);
		return (List<ChaoBannerDO>) getSqlMapClientTemplate().queryForList("chaoBanner.queryBannerPage", params);
	}
	
	@Override
	public int countBanners(ChaoBannerCondition condition) {
		return (Integer) getSqlMapClientTemplate().queryForObject("chaoBanner.countBanners", condition.toMap());
	}

	@Override
	public int updateBanner(ChaoBannerDO banner) {
		return (int) getSqlMapClientTemplate().update("chaoBanner.updateBanner", banner);
	}
	
	
}
