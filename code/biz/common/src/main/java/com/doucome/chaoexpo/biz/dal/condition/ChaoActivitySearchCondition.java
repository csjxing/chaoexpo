package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoActivitySearchCondition extends AbstractModel  {
	
	public Map<String,Object> toMap() {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("ids", ids) ;
		return map ;
	}

	private List<Long> ids ;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	
	
	
}
