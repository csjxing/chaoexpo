package com.doucome.chaoexpo.web.chao.authz;

import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;

/**
 * 
 * @author langben 2013-5-21
 * 
 */
public interface ChaoSessionOperator {
 
	 boolean load(ChaoUserDTO user) ;
	 
	 boolean unload() ;
}
