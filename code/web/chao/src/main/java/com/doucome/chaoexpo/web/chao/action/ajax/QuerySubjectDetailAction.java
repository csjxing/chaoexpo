package com.doucome.chaoexpo.web.chao.action.ajax;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserFollowTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class QuerySubjectDetailAction extends ChaoBasicAction {

	private JsonModel<ChaoSubjectDTO> json = new JsonModel<ChaoSubjectDTO>() ;
	
	private Long id ;
	
	@Autowired
	private ChaoSubjectService chaoSubjectService ;
	
	@Autowired
	private ChaoUserFollowService chaoUserFollowService ;
	
	@Override
	public String execute() throws Exception {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.subject.query.id.required") ;
			return SUCCESS ;
		}
		
		try {
		
			ChaoSubjectDTO subject = chaoSubjectService.getSubjectById(id) ;
			if(subject == null) {
				json.setCode(JsonModel.CODE_ILL_ARGS) ;
				json.setDetail("chao.subject.query.subject.notExists") ;
				return SUCCESS ;
			}
			
			String userName = chaoAuthz.getUserName() ;
			if(StringUtils.isNotBlank(userName)) {
				//查询是否关注活动
				ChaoUserFollowQuery condition = new ChaoUserFollowQuery() ;
				condition.setSubjectId(id) ;
				condition.setUserName(userName) ;
				condition.setType(ChaoUserFollowTypeEnums.FOLLOW_SUBJECT.getValue()) ;
				List<ChaoUserFollowDTO> followList = chaoUserFollowService.getFollowsNoPagination(condition) ;
				if(CollectionUtils.isEmpty(followList)) {
					subject.setIsUserFollowed(false) ;
				} else {
					subject.setIsUserFollowed(true) ;
				}
			}
			
			json.setCode(JsonModel.CODE_SUCCESS) ;
			json.setData(subject) ;
			
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}

	public JsonModel<ChaoSubjectDTO> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
