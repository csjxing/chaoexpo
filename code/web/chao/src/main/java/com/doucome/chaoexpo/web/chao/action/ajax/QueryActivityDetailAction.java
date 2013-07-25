package com.doucome.chaoexpo.web.chao.action.ajax;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserFollowTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 活动列表
 * @author langben 2013-5-21
 *
 */
public class QueryActivityDetailAction extends ChaoBasicAction {

	private JsonModel<ChaoActivityDTO> json = new JsonModel<ChaoActivityDTO>() ;
	
	private Long id ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Autowired
	private ChaoSubjectService chaoSubjectService ;
	
	@Autowired
	private ChaoUserFollowService chaoUserFollowService ;
	
	@Override
	public String execute() throws Exception {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.query.id.required") ;
			return SUCCESS ;
		}
		
		try {
			ChaoActivityDTO activity = chaoActivityService.getActivityById(id) ;
			
			if(activity == null) {
				json.setCode(JsonModel.CODE_ILL_ARGS) ;
				json.setDetail("chao.activity.query.activity.notExists") ;
				return SUCCESS ;
			}
			
			//查询专题
			if(IDUtils.isCorrect(activity.getSubjectId())) {
				Long subjectId = activity.getSubjectId() ;
				ChaoSubjectDTO subject = chaoSubjectService.getSubjectById(subjectId) ;
				activity.setSubject(subject) ;
			}
			
			String userName = chaoAuthz.getUserName() ;
			if(StringUtils.isNotBlank(userName)) {
				//查询是否关注活动
				ChaoUserFollowQuery condition = new ChaoUserFollowQuery() ;
				condition.setActivityId(id) ;
				condition.setUserName(userName) ;
				condition.setType(ChaoUserFollowTypeEnums.FOLLOW_ACTIVITY.getValue()) ;
				List<ChaoUserFollowDTO> followList = chaoUserFollowService.getFollowsNoPagination(condition) ;
				if(CollectionUtils.isEmpty(followList)) {
					activity.setIsUserFollowed(false) ;
				} else {
					activity.setIsUserFollowed(true) ;
				}
			}
			
			json.setCode(JsonModel.CODE_SUCCESS) ;
			json.setData(activity) ;
			
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}

	
	public JsonModel<ChaoActivityDTO> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
