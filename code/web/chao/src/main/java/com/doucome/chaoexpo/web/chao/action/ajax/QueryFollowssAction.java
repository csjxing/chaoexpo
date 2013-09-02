package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.ChaoUserFollowTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class QueryFollowssAction extends ChaoBasicAction{

	private JsonModel<QueryResult<ChaoUserFollowDTO>> json = new JsonModel<QueryResult<ChaoUserFollowDTO>>() ;
	
	private int page ;
	
	private int size = 20 ;
	
	private Long activityId ;
	
	private Long subjectId ;
	
	private Long tenantId ;
	
	private String type ;
	
	@Autowired
	private ChaoUserFollowService chaoUserFollowService ;
	
	@Override
	public String execute() throws Exception {
		
		ChaoUserFollowTypeEnums typeEnum = ChaoUserFollowTypeEnums.toEnum(type) ;
		if(typeEnum == ChaoUserFollowTypeEnums.UNKNOWN) {
			
		}
		
		ChaoUserFollowQuery query = new ChaoUserFollowQuery() ;
		query.setActivityId(activityId) ;
		query.setSubjectId(subjectId) ;
		query.setTenantId(tenantId) ;
		query.setType(type) ;		
		
		QueryResult<ChaoUserFollowDTO> queryResult = chaoUserFollowService.getFollowsWithPagination(query, new Pagination(page , size)) ;
		
		json.setData(queryResult) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		
		return SUCCESS ;
	}

	public JsonModel<QueryResult<ChaoUserFollowDTO>> getJson() {
		return json;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
