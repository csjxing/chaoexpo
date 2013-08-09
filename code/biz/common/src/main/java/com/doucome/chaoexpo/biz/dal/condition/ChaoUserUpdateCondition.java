package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoUserUpdateCondition extends AbstractModel {

	private Integer incrFollowActivityCount ;
	
	private Integer incrFavoriteSubjectCount ;
	
	private Integer incrCheckinActivityCount ;
	
	private Integer decrFollowActivityCount ;
	
	private Integer decrFavoriteSubjectCount ;
	
	private Integer decrCheckinActivityCount ;
	
	private String status ;
	
	public Map<String,Object> toMap() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("incrFollowActivityCount", incrFollowActivityCount) ;
		map.put("incrFavoriteSubjectCount", incrFavoriteSubjectCount) ;
		map.put("incrCheckinActivityCount", incrCheckinActivityCount) ;
		map.put("decrFollowActivityCount", decrFollowActivityCount) ;
		map.put("decrFavoriteSubjectCount", decrFavoriteSubjectCount) ;
		map.put("decrCheckinActivityCount", decrCheckinActivityCount) ;
		map.put("status", status) ;
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

	public Integer getDecrFollowActivityCount() {
		return decrFollowActivityCount;
	}

	public void setDecrFollowActivityCount(Integer decrFollowActivityCount) {
		this.decrFollowActivityCount = decrFollowActivityCount;
	}

	public Integer getDecrFavoriteSubjectCount() {
		return decrFavoriteSubjectCount;
	}

	public void setDecrFavoriteSubjectCount(Integer decrFavoriteSubjectCount) {
		this.decrFavoriteSubjectCount = decrFavoriteSubjectCount;
	}

	public Integer getDecrCheckinActivityCount() {
		return decrCheckinActivityCount;
	}

	public void setDecrCheckinActivityCount(Integer decrCheckinActivityCount) {
		this.decrCheckinActivityCount = decrCheckinActivityCount;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
