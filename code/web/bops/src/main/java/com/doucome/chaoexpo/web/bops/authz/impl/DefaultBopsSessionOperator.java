package com.doucome.chaoexpo.web.bops.authz.impl;
import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.dal.dataobject.BopsAdminDO;
import com.doucome.chaoexpo.web.bops.authz.BopsSessionOperator;
import com.doucome.chaoexpo.web.bops.context.AuthzContext;
import com.doucome.chaoexpo.web.bops.context.AuthzContextHolder;
import com.doucome.chaoexpo.web.bops.context.AuthzContextModelEnum;

public class DefaultBopsSessionOperator implements BopsSessionOperator {

    @Override
    public boolean load(BopsAdminDO adminDO) {
        if (adminDO == null || StringUtils.isEmpty(adminDO.getAdminId())) {
            return false;
        }
        AuthzContext authzContext = AuthzContextHolder.getContext();
        authzContext.clearModels();
        authzContext.setAdminId(adminDO.getAdminId());
        authzContext.setModel(AuthzContextModelEnum.BOPS_ADMIN_MODEL, adminDO);
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
