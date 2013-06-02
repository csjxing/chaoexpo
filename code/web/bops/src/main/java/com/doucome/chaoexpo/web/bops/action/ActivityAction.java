package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;

@SuppressWarnings("serial")
public class ActivityAction extends BopsBasicAction {
	
	private Long id;
	
	private ChaoActivityDTO activity;
	
	@Autowired
	private ChaoActivityService chaoActivityService;
	
	@Override
	public String execute() throws Exception {
		if (IDUtils.isCorrect(id)) {
			activity = chaoActivityService.getActivityById(id);
		}
		
		return SUCCESS ;
	}
	
	
	public ChaoActivityDTO getActivity() {
		return activity;
	}
	
	public void setId(Long id){
		this.id = id;
	}
}
