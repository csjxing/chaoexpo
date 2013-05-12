package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.web.bops.authz.BopsAuthz;
import com.doucome.chaoexpo.web.common.action.BasicAction;

@SuppressWarnings("serial")
public abstract class BopsBasicAction extends BasicAction {
	
	protected static final String BOPS_ERROR = "bopsError" ;

    @Autowired
    protected BopsAuthz bopsAuthz;
    
    
    public BopsAuthz getBopsAuthz() {
        return bopsAuthz;
    }
    
 
}
