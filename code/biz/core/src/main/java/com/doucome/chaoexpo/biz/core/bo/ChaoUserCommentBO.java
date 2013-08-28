package com.doucome.chaoexpo.biz.core.bo;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.constant.Constant;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserCommentStatusEnums;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserCommentTypeEnums;
import com.doucome.chaoexpo.biz.core.exception.ChaoUserCommentException;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserCommentDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserCommentService;
import com.doucome.chaoexpo.biz.core.utils.ChaoUserCommentUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;

public class ChaoUserCommentBO {

	@Autowired
	private ChaoNewsService chaoNewsService ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Autowired
	private ChaoUserCommentService chaoUserCommentService ;
	
	/**
	 * 
	 * @param comment
	 * @return
	 */
	@Transactional
	public boolean addComment(ChaoUserCommentDO comment) throws ChaoUserCommentException {
		
		String userName = comment.getUserName() ;
		Long toCommentId = comment.getToCommentId() ;
		Long activityId = comment.getActivityId() ;
		Long newsId = comment.getNewsId() ;
		String targetName = null ;
		String content = comment.getContent() ;
		content = StringUtils.substring(content, 0 , Constant.COMMENT_MAX_LENGTH) ;
		comment.setStatus(ChaoUserCommentStatusEnums.NORMAL.getValue()) ;
		ChaoUserCommentTypeEnums type = ChaoUserCommentTypeEnums.UNKNOWN ;
		if(StringUtils.isBlank(content)) {
			throw new ChaoUserCommentException("chao.user.comment.content.blank") ;
		}
		
		if(IDUtils.isNotCorrect(activityId) && IDUtils.isNotCorrect(newsId)) {
			throw new ChaoUserCommentException("chao.user.comment.actOrNews.id.required") ;
		}
		
		if(StringUtils.isBlank(userName)){
			throw new ChaoUserCommentException("chao.user.comment.user.required") ;
		}
		
		if(IDUtils.isCorrect(activityId)) {
			ChaoActivityDTO act = chaoActivityService.getActivityById(activityId) ;
			if(act == null) {
				throw new ChaoUserCommentException("chao.user.comment.activity.error") ;
			}
			type = ChaoUserCommentTypeEnums.ACTIVITY ;
			targetName = act.getName() ;
			
		} else if(IDUtils.isCorrect(newsId)) {
			ChaoNewsDTO news = chaoNewsService.getNewsById(newsId) ;
			if(news == null) {
				throw new ChaoUserCommentException("chao.user.comment.news.error") ;
			}
			type = ChaoUserCommentTypeEnums.NEWS ;
			targetName = news.getTitle() ;
		}
		
		comment.setType(type.getValue()) ;
		comment.setTargetName(targetName) ;
		
		if(IDUtils.isCorrect(toCommentId)) { //回复
			ChaoUserCommentDTO toComment = chaoUserCommentService.getCommentById(toCommentId) ;
			if(toComment != null) {
				if(ChaoUserCommentUtils.isSameTarget(new ChaoUserCommentDTO(comment), toComment)) {
					comment.setToUserName(toComment.getUserName()) ;
				} else {
					comment.setToCommentId(null) ;
				}
			}
		}
		
		if(type == ChaoUserCommentTypeEnums.ACTIVITY) { 
			ChaoActivityUpdateCondition update = new ChaoActivityUpdateCondition() ;
			update.setIncrCommentCount(1) ;
			chaoActivityService.updateActivityById(activityId, update) ; //评论+1
		} else if(type == ChaoUserCommentTypeEnums.NEWS) {
			ChaoNewsUpdateCondition update = new ChaoNewsUpdateCondition() ;
			update.setIncrCommentCount(1) ;
			chaoNewsService.updateNewsById(newsId, update) ;
		}
		
		chaoUserCommentService.createComment(comment) ;
		
		return true ;
	}
	
	
}
