package com.doucome.chaoexpo.web.bops.authz.impl;

import com.doucome.chaoexpo.biz.dal.dataobject.BopsAdminDO;
import com.doucome.chaoexpo.web.bops.authz.BopsAuthz;
import com.doucome.chaoexpo.web.bops.context.AuthzContextHolder;
import com.doucome.chaoexpo.web.bops.context.AuthzContextModelEnum;

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