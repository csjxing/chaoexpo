package com.doucome.chaoexpo.biz.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.doucome.chaoexpo.biz.common.utils.ReflectUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class ChaoNewsUtils {

	public static ChaoNewsUpdateCondition fromNewDO(ChaoNewsDO news) {
		ChaoNewsUpdateCondition condition = new ChaoNewsUpdateCondition() ;
		ReflectUtils.reflectTo(news, condition) ;
		return condition ;
	}
	
	public static List<ChaoNewsCategoryDTO> toDTOList(List<ChaoNewsCategoryDO> doList) {
		List<ChaoNewsCategoryDTO> dtoList = new ArrayList<ChaoNewsCategoryDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoNewsCategoryDO cat : doList) {
				dtoList.add(new ChaoNewsCategoryDTO(cat)) ;
			}
		}
		return dtoList ;
	}
}
