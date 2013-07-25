package com.doucome.chaoexpo.web.chao.authz.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.UserStatusEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.web.chao.authz.ChaoAuthz;
import com.doucome.chaoexpo.web.chao.context.AuthzContext;
import com.doucome.chaoexpo.web.chao.context.AuthzContextHolder;
import com.doucome.chaoexpo.web.chao.context.AuthzContextModelEnums;

public class DefaultAuthzImpl implements ChaoAuthz {

	@Autowired
	private ChaoUserService chaoUserService;

	@Override
	public boolean isLogin() {
		
		AuthzContext authzContext = AuthzContextHolder.getContext();
		String authKey = authzContext.getAuthKey();
		String userName = authzContext.getUserName();

		ChaoUserDTO user = (ChaoUserDTO) authzContext.getModel(AuthzContextModelEnums.USER_KEY);
		if (user == null && StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(authKey)) {
			user = chaoUserService.getUserByUserNameAndAuthKey(userName,authKey);
			if (user != null && UserStatusEnums.toEnum(user.getStatus()) == UserStatusEnums.NORMAL) {
				authzContext.setModel(AuthzContextModelEnums.USER_KEY, user);
				authzContext.setAuthentication(true, true);
			}
		}

		return AuthzContextHolder.getContext().isAuthentication();
	}

	@Override
	public String getUserName() {
		if(!isLogin()) {
			return null ;
		}
		AuthzContext authzContext = AuthzContextHolder.getContext();
		return authzContext.getUserName() ;
	}

}
