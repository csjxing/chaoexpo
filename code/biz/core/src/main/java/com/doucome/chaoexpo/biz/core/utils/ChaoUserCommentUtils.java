package com.doucome.chaoexpo.biz.core.utils;

import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.common.utils.NumberUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserCommentTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoUserCommentDTO;

public class ChaoUserCommentUtils {

	public static boolean isSameTarget(ChaoUserCommentDTO c1 , ChaoUserCommentDTO c2) {
		
		if(c1 == null || c2 == null) {
			return false ;
		}
		
		if(!StringUtils.equals(c1.getType() , c2.getType())){
			return false ;
		}
		
		ChaoUserCommentTypeEnums type = ChaoUserCommentTypeEnums.toEnum(c1.getType()) ;
		
		if(type == ChaoUserCommentTypeEnums.ACTIVITY) {
			if(NumberUtils.equals(c1.getActivityId() , c2.getActivityId())) {
				
				return true ;
			}
		} else if(type == ChaoUserCommentTypeEnums.NEWS) {
			if(NumberUtils.equals(c1.getNewsId() , c2.getNewsId())) {
				return true ;
			}
		}
		
		return false ;
	}
}
