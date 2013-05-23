package com.doucome.chaoexpo.web.bops.context;

/**
 * 
 * @author langben 2013-5-23
 *
 */
public class AuthzContextHolder {

	private static ThreadLocal<AuthzContext> contextHolder = new ThreadLocal<AuthzContext>();

	public static AuthzContext getContext() {
		if (contextHolder.get() == null) {
			setContext(new AuthzContext());
		}
		return contextHolder.get();
	}

	public static void setContext(AuthzContext context) {
		contextHolder.set(context);
	}
}
