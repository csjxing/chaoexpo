package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoUserUpdateCondition extends AbstractModel {

	private Integer incrFollowActivityCount ;
	
	private Integer incrFavoriteSubjectCount ;
	
	private Integer incrCheckinActivityCount ;
	
	public Map<String,Object> toMap() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("incrFollowActivityCount", incrFollowActivityCount) ;
		map.put("incrFavoriteSubjectCount", incrFavoriteSubjectCount) ;
		map.put("incrCheckinActivityCount", incrCheckinActivityCount) ;
		return map ;
	}

	public Integer getIncrFollowActivityCount() {
		return incrFollowActivityCount;
	}

	public void setIncrFollowActivityCount(Integer incrFollowActivityCount) {
		this.incrFollowActivityCount = incrFollowActivityCount;
	}

	public Integer getIncrFavoriteSubjectCount() {
		return incrFavoriteSubjectCount;
	}

	public void setIncrFavoriteSubjectCount(Integer incrFavoriteSubjectCount) {
		this.incrFavoriteSubjectCount = incrFavoriteSubjectCount;
	}

	public Integer getIncrCheckinActivityCount() {
		return incrCheckinActivityCount;
	}

	public void setIncrCheckinActivityCount(Integer incrCheckinActivityCount) {
		this.incrCheckinActivityCount = incrCheckinActivityCount;
	}
	
}
