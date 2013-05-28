package com.doucome.chaoexpo.web.chao.action.user.ajax;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserFollowTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowSearchCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 关注
 * @author langben 2013-5-28
 *
 */
public class AddFollowAction extends ChaoBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	private Long id ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Autowired
	private ChaoUserFollowService chaoUserFollowService ;
	
	public String followActivity() {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.follow.id.required") ;
			return SUCCESS ;
		}
		
		String userName = chaoAuthz.getUserName() ;
		//用户是否登陆
		if(StringUtils.isBlank(userName)){
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.follow.user.required") ;
			return SUCCESS ;
		}
		
		//活动是否存在
		ChaoActivityDTO activity = chaoActivityService.getActivityById(id) ;
		if(activity == null) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.follow.notExists") ;
			return SUCCESS ;
		}
		
		//
		ChaoUserFollowSearchCondition condition = new ChaoUserFollowSearchCondition() ;
		condition.setUserName(userName) ;
		condition.setActivityId(id) ;
		condition.setType(ChaoUserFollowTypeEnums.ACTIVITY.getValue()) ;
		
		List<ChaoUserFollowDTO> followList = chaoUserFollowService.getFollowsNoPagination(condition) ;
		
		//已经关注过
		if(CollectionUtils.isNotEmpty(followList)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.follow.duplicate") ;
			return SUCCESS ;
		}
		
		ChaoUserFollowDO follow = new ChaoUserFollowDO() ;
		follow.setUserName(userName) ;
		follow.setType(ChaoUserFollowTypeEnums.ACTIVITY.getValue()) ;
		follow.setActivityId(id) ;
		chaoUserFollowService.createFollow(follow) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		return SUCCESS ;
	}
	
	public String followSubjectt() {
		return SUCCESS ;
	}
	
	public String followTenant() {
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
