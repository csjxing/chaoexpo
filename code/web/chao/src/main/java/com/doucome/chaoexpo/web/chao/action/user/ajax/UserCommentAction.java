package com.doucome.chaoexpo.web.chao.action.user.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ChaoUserCommentBO;
import com.doucome.chaoexpo.biz.core.exception.ChaoUserCommentException;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;
import com.opensymphony.xwork2.ModelDriven;

public class UserCommentAction extends ChaoBasicAction implements ModelDriven<ChaoUserCommentDO> {

	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	private ChaoUserCommentDO comment = new ChaoUserCommentDO() ;
	
	@Autowired
	private ChaoUserCommentBO chaoUserCommentBO ;
	
	@Override
	public String execute() throws Exception {
		
		String userName = chaoAuthz.getUserName() ;
		comment.setUserName(userName) ;
		try {
			chaoUserCommentBO.addComment(comment) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
		} catch (ChaoUserCommentException e) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail(e.getMessage()) ;
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}

	@Override
	public ChaoUserCommentDO getModel() {
		return comment ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}
	
}
