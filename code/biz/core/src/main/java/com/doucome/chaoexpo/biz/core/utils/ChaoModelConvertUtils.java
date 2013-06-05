package com.doucome.chaoexpo.biz.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;

public class ChaoModelConvertUtils {

	public static List<ChaoNewsCategoryDTO> toNewsCatDTOList(List<ChaoNewsCategoryDO> doList) {
		List<ChaoNewsCategoryDTO> dtoList = new ArrayList<ChaoNewsCategoryDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoNewsCategoryDO cat : doList) {
				dtoList.add(new ChaoNewsCategoryDTO(cat)) ;
			}
		}
		return dtoList ;
	}
	
	public static List<ChaoAppRecommendDTO> toAppRecommDTOList(List<ChaoAppRecommendDO> doList) {
		List<ChaoAppRecommendDTO> dtoList = new ArrayList<ChaoAppRecommendDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoAppRecommendDO rec : doList) {
				dtoList.add(new ChaoAppRecommendDTO(rec)) ;
			}
		}
		return dtoList ;
	}
	
}
