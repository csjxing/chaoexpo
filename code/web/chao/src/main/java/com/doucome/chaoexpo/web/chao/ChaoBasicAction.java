package com.doucome.chaoexpo.web.chao;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.web.chao.authz.ChaoAuthz;
import com.doucome.chaoexpo.web.common.action.BasicAction;

@SuppressWarnings("serial")
public class ChaoBasicAction extends BasicAction {

	@Autowired
	protected ChaoAuthz chaoAuthz ;
	
}
