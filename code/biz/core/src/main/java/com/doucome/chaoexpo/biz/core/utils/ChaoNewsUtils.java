package com.doucome.chaoexpo.biz.core.utils;

import com.doucome.chaoexpo.biz.common.utils.ReflectUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

public class ChaoNewsUtils {

	public static ChaoNewsUpdateCondition fromNewDO(ChaoNewsDO news) {
		ChaoNewsUpdateCondition condition = new ChaoNewsUpdateCondition() ;
		ReflectUtils.reflectTo(news, condition) ;
		return condition ;
	}
	
}
