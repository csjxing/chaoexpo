package com.doucome.chaoexpo.web.chao.interceptor;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.web.chao.authz.ChaoAuthz;
import com.doucome.chaoexpo.web.common.action.BasicAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthzInterceptor extends AbstractInterceptor {

	@Autowired
	private ChaoAuthz chaoAuthz ;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if (!chaoAuthz.isLogin()) {
//			HttpServletRequest request = ServletActionContext.getRequest() ;
//			String toUrl = request.getRequestURL().toString();
//			String requestQueryString = request.getQueryString();
//			if (StringUtils.isNotBlank(requestQueryString)) {
//				toUrl += "?" + requestQueryString;
//			}
//			toUrl = URLEncoder.encode(toUrl, Constant.CHARSET_UTF8);
			
//			invocation.getStack().set("redirectURL", toUrl) ;
			
            return BasicAction.CHAO_LOGIN_JSON ;
        }
		return invocation.invoke();
	}

}
