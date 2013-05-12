package com.doucome.chaoexpo.web.bops.authz.impl;

import com.doucome.chaoexpo.biz.dal.dataobject.BopsAdminDO;
import com.doucome.chaoexpo.web.bops.authz.BopsAuthz;
import com.doucome.chaoexpo.web.bops.context.AuthzContextHolder;
import com.doucome.chaoexpo.web.bops.context.AuthzContextModelEnum;

/**
 * 类DefaultAuthzImpl.java的实现描述：Authz.java的默认实现
 * 
 * @author ib 2012-3-24 下午01:27:48
 */
public class DefaultAuthzImpl implements BopsAuthz {

    @Override
    public BopsAdminDO getAdminDO() {
        return (BopsAdminDO) AuthzContextHolder.getContext().getModel(AuthzContextModelEnum.BOPS_ADMIN_MODEL);
    }

    @Override
    public boolean isLogin() {
        return AuthzContextHolder.getContext().isAuthentication();
    }

    @Override
    public String getAdminId() {
        return AuthzContextHolder.getContext().getAdminId();
    }

}
