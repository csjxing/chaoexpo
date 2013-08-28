package com.doucome.chaoexpo.web.chao.action.user.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.ChaoUserCommentTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoUserCommentDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserCommentService;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserCommentQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 我的评论
 * @author langben 2013-8-28
 *
 */
public class MyCommentsAction extends ChaoBasicAction {

	private JsonModel<QueryResult<ChaoUserCommentDTO>> json = new JsonModel<QueryResult<ChaoUserCommentDTO>>() ;
	
	private int page ;
	
	private int size = 20 ;
	
	private Long activityId ;
	
	private Long newsId ;
	
	private String type ;
	
	@Autowired
	private ChaoUserCommentService chaoUserCommentService ;
	
	@Override
	public String execute() throws Exception {
		
		String userName = chaoAuthz.getUserName() ;
		
		ChaoUserCommentQuery query = new ChaoUserCommentQuery() ;
		query.setUserName(userName) ;
		query.setActivityId(activityId) ;
		query.setNewsId(newsId) ;
		
		ChaoUserCommentTypeEnums typeEnum = ChaoUserCommentTypeEnums.toEnum(type) ;
		if(typeEnum != ChaoUserCommentTypeEnums.UNKNOWN) {
			query.setType(type) ;
		}
		
		QueryResult<ChaoUserCommentDTO> queryResult = chaoUserCommentService.getCommentsWithPagination(query, new Pagination(page , size)) ;
		
		json.setData(queryResult) ;
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public JsonModel<QueryResult<ChaoUserCommentDTO>> getJson() {
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

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
