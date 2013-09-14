package com.doucome.chaoexpo.web.bops.action.ajax;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserCommentStatusEnums;
import com.doucome.chaoexpo.biz.core.enums.UserStatusEnums;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserCommentService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserCommentUpdateCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class UserCommentOperateAction extends BopsBasicAction {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private String commentId ;
	
	private String status ;
	
	@Autowired
	private ChaoUserCommentService chaoUserCommentService ;
	
	public String updateStatus() {
		
		if(StringUtils.isBlank(commentId)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.userComment.updateStatus.id.required") ;
			return SUCCESS ;
		}
		
		Long commentIdLong = Long.valueOf(StringUtils.trim(commentId)) ;
		
		if(IDUtils.isNotCorrect(commentIdLong)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.userComment.updateStatus.id.required") ;
			return SUCCESS ;
		}
		
		ChaoUserCommentStatusEnums e = ChaoUserCommentStatusEnums.toEnum(status) ;
		if(e == ChaoUserCommentStatusEnums.UNKNOW) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.userComment.updateStatus.status.error") ;
			return SUCCESS ;
		}
		
		ChaoUserCommentUpdateCondition update = new ChaoUserCommentUpdateCondition() ;
		update.setStatus(status) ;
		
		int effectCount = chaoUserCommentService.updateCommentById(commentIdLong , update) ; 
		
		if(effectCount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.userComment.updateStatus.effectCount.zero") ;
			return SUCCESS ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
