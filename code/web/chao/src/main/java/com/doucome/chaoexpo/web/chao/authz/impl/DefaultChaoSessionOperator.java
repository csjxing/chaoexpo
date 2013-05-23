package com.doucome.chaoexpo.web.chao.authz.impl;

import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.web.chao.authz.ChaoSessionOperator;
import com.doucome.chaoexpo.web.chao.context.AuthzContext;
import com.doucome.chaoexpo.web.chao.context.AuthzContextHolder;
import com.doucome.chaoexpo.web.chao.context.AuthzContextModelEnums;


public class DefaultChaoSessionOperator implements ChaoSessionOperator {
 
     
    @Override 
	public boolean load(ChaoUserDTO user) {
        if (user == null || StringUtils.isEmpty(user.getUserName())) {
            return false;
        }
        AuthzContext authzContext = AuthzContextHolder.getContext();
        authzContext.clearModels();
        authzContext.setUserName(user.getUserName()) ;
        authzContext.setModel(AuthzContextModelEnums.USER_KEY, user);
        authzContext.setAuthentication(true, true);
        return true;
	}

 
    @Override
    public boolean unload() {
        AuthzContext authzContext = AuthzContextHolder.getContext();
        authzContext.setAuthentication(false, true);
        return true;
    }

	

}
