package com.doucome.chaoexpo.biz.core.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.doucome.chaoexpo.biz.common.utils.ReflectUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class ChaoNewsUtils {

	public static ChaoNewsUpdateCondition fromNewDO(ChaoNewsDO news) {
		ChaoNewsUpdateCondition condition = new ChaoNewsUpdateCondition() ;
		ReflectUtils.reflectTo(news, condition) ;
		return condition ;
	}
	
	public static Map<Long,ChaoNewsCategoryDTO> toCatMap(List<ChaoNewsCategoryDTO> categoryList) {
		Map<Long,ChaoNewsCategoryDTO> catMap = new HashMap<Long,ChaoNewsCategoryDTO>() ;
		if(CollectionUtils.isNotEmpty(categoryList)) {
			for(ChaoNewsCategoryDTO cat : categoryList) {
				catMap.put(cat.getId(), cat) ;
			}
		}
		return catMap ;
	}
	
}
