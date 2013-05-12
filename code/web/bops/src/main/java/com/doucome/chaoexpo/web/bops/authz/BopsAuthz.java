package com.doucome.chaoexpo.web.bops.authz;

import com.doucome.chaoexpo.biz.dal.dataobject.BopsAdminDO;

/**
 * 类Authz.java的实现描述：登录认证信息
 * 
 * @author ib 2012-3-24 下午01:27:16
 */
public interface BopsAuthz {

    /**
     * 判断用户是否登录状态
     * 
     * @return
     */
    public boolean isLogin();
    
    public String getAdminId();

    /**
     * 获取帐号信息
     * 
     * @return
     */
    public BopsAdminDO getAdminDO();
}
