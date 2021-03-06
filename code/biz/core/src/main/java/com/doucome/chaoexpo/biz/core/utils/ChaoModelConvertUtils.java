package com.doucome.chaoexpo.biz.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.doucome.chaoexpo.biz.core.model.ChaoActivitySignupDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoAppRecommendDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoDeviceDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivitySignupDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoDeviceDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsCategoryDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;

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
	
	public static List<ChaoTushuoDTO> toTushuoDTOList(List<ChaoTushuoDO> doList) {
		List<ChaoTushuoDTO> dtoList = new ArrayList<ChaoTushuoDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoTushuoDO ts : doList) {
				dtoList.add(new ChaoTushuoDTO(ts)) ;
			}
		}
		return dtoList ;
	}
	
	public static List<ChaoTushuoCategoryDTO> toTushuoCateDTOList(List<ChaoTushuoCategoryDO> doList) {
		List<ChaoTushuoCategoryDTO> dtoList = new ArrayList<ChaoTushuoCategoryDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoTushuoCategoryDO ts : doList) {
				dtoList.add(new ChaoTushuoCategoryDTO(ts)) ;
			}
		}
		return dtoList ;
	}
	
	public static List<ChaoUserFollowDTO> toUserFollowDTOList(List<ChaoUserFollowDO> doList) {
		List<ChaoUserFollowDTO> dtoList = new ArrayList<ChaoUserFollowDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoUserFollowDO userFollow : doList) {
				dtoList.add(new ChaoUserFollowDTO(userFollow)) ;
			}
		}
		return dtoList ;
	}
	
	public static Map<Long,ChaoTushuoCategoryDTO> toCateMap(List<ChaoTushuoCategoryDTO> cateList) {
		Map<Long,ChaoTushuoCategoryDTO> cateMap = new HashMap<Long,ChaoTushuoCategoryDTO>() ;
		if(CollectionUtils.isNotEmpty(cateList)) {
			for(ChaoTushuoCategoryDTO cate : cateList) {
				cateMap.put(cate.getId(), cate) ;
			}
		}
		return cateMap ;
	}
	
	public static List<ChaoActivitySignupDTO> toActSignupDTOList(List<ChaoActivitySignupDO> doList) {
		List<ChaoActivitySignupDTO> dtoList = new ArrayList<ChaoActivitySignupDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoActivitySignupDO signup : doList) {
				dtoList.add(new ChaoActivitySignupDTO(signup)) ;
			}
		}
		return dtoList ;
	}
	
	public static List<ChaoDeviceDTO> toDeviceDTOList(List<ChaoDeviceDO> doList) {
		List<ChaoDeviceDTO> dtoList = new ArrayList<ChaoDeviceDTO>() ;
		if(CollectionUtils.isNotEmpty(doList)) {
			for(ChaoDeviceDO signup : doList) {
				dtoList.add(new ChaoDeviceDTO(signup)) ;
			}
		}
		return dtoList ;
	}
}
