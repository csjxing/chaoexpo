package com.doucome.chaoexpo.web.bops.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.utils.MD5Util;
import com.doucome.chaoexpo.biz.dal.dao.BopsAdminDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.BopsAdminDO;
import com.doucome.chaoexpo.web.bops.authz.BopsSessionOperator;

/**
 * 类LoginAction.java的实现描述：后台登陆
 * 
 * @author ib 2012-4-21 下午03:12:47
 */
@SuppressWarnings("serial")
public class LoginAction extends BopsBasicAction {

    @Autowired
    private BopsAdminDAO        bopsAdminDAO;
    @Autowired
    private BopsSessionOperator bopsSessionOperator;
    private String              loginId;
    private String              password;
    private int                 resultCode;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String doLogin() {
        if (StringUtils.isBlank(loginId) || StringUtils.isBlank(password)) {
            resultCode = 1;
            return ERROR;
        }
        String md5Password = MD5Util.getMD5(password);
        BopsAdminDO adminDO = bopsAdminDAO.queryByAdminIdAndPass(loginId, md5Password);
        if (adminDO == null) {
            resultCode = 2;
            return ERROR;
        }
        bopsSessionOperator.load(adminDO);
        return SUCCESS;
    }

    public String doLogout() {
        bopsSessionOperator.unload();
        return SUCCESS;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getResultCode() {
        return resultCode;
    }

}
