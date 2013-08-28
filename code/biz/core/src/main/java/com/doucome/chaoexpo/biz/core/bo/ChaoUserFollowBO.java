package com.doucome.chaoexpo.biz.core.bo;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserFollowTypeEnums;
import com.doucome.chaoexpo.biz.core.exception.ChaoUserFollowException;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.core.utils.DateUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowDelCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserFollowQuery;

public class ChaoUserFollowBO {

	@Autowired
	private ChaoUserService chaoUserService ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Autowired
	private ChaoUserFollowService chaoUserFollowService ; 
	
	@Autowired
	private ChaoSubjectService chaoSubjectService ;
	
	@Transactional
	public boolean addFollow(ChaoUserFollowDO follow) throws ChaoUserFollowException {
		
		String userName = follow.getUserName() ;
		Long subjId = follow.getSubjectId() ;
		Long actId = follow.getActivityId() ;
		Long tenantId = follow.getTenantId() ;
		String location = follow.getLocation() ;
		String locationCode = follow.getLocationCode() ;
		String targetName = null ;
		ChaoUserFollowTypeEnums type = ChaoUserFollowTypeEnums.toEnum(follow.getType()) ;
		if(type == ChaoUserFollowTypeEnums.UNKNOWN) {
			throw new ChaoUserFollowException("chao.user.follow.type.error") ;
		}
		
		if(StringUtils.isBlank(userName)) {
			throw new ChaoUserFollowException("chao.user.follow.user.required") ;
		}
		
		if(ChaoUserFollowTypeEnums.FOLLOW_ACTIVITY == type) {
			//关注活动
			if(IDUtils.isNotCorrect(actId)) {
				throw new ChaoUserFollowException("chao.user.activity.follow.activity.required") ;
			}
			
			//活动是否存在
			ChaoActivityDTO activity = chaoActivityService.getActivityById(actId) ;
			if(activity == null) {
				throw new ChaoUserFollowException("chao.user.activity.follow.activity.notExists") ;
			}
			
			ChaoUserFollowQuery query = new ChaoUserFollowQuery() ;
			query.setUserName(userName) ;
			query.setActivityId(actId) ;
			query.setType(ChaoUserFollowTypeEnums.FOLLOW_ACTIVITY.getValue()) ;
			
			List<ChaoUserFollowDTO> followList = chaoUserFollowService.getFollowsNoPagination(query) ;
			
			//已经关注过
			if(CollectionUtils.isNotEmpty(followList)) {
				throw new ChaoUserFollowException("chao.user.activity.follow.duplicate") ;
			}
			
			try {
				follow.setTargetName(activity.getName()) ;
				chaoUserFollowService.createFollow(follow) ;
			} catch (DuplicateKeyException e) {
				throw new ChaoUserFollowException("chao.user.activity.follow.duplicate") ;
			}
			
			//incr 活动关注数
			ChaoActivityUpdateCondition incr = new ChaoActivityUpdateCondition() ;
			incr.setIncrFollowCount(1) ;
			chaoActivityService.updateActivityById(actId, incr) ;
			
			//个人关注数
			ChaoUserUpdateCondition incrUserFol = new ChaoUserUpdateCondition() ;
			incrUserFol.setIncrFollowActivityCount(1) ;
			chaoUserService.updateUserByUserName(userName, incrUserFol) ;
			
		} else if(ChaoUserFollowTypeEnums.FOLLOW_SUBJECT == type) {
			//关注专题
			if(IDUtils.isNotCorrect(subjId)) {
				throw new ChaoUserFollowException("chao.user.subject.follow.subject.required") ;
			}
			
			//专题是否存在
			ChaoSubjectDTO subject = chaoSubjectService.getSubjectById(subjId) ;
			if(subject == null) {
				throw new ChaoUserFollowException("chao.user.subject.favorite.subject.notExists") ;
			}
			
			//是否已经关注
			ChaoUserFollowQuery query = new ChaoUserFollowQuery() ;
			query.setUserName(userName) ;
			query.setSubjectId(subjId) ;
			query.setType(type.getValue()) ;
			
			List<ChaoUserFollowDTO> followList = chaoUserFollowService.getFollowsNoPagination(query) ;
			
			//已经关注过
			if(CollectionUtils.isNotEmpty(followList)) {
				throw new ChaoUserFollowException("chao.user.subject.favorite.duplicate") ;
			}
			
			try {
				follow.setTargetName(subject.getName()) ;
				chaoUserFollowService.createFollow(follow) ;
			} catch (DuplicateKeyException e) {
				throw new ChaoUserFollowException("chao.user.subject.favorite.duplicate") ;
			}
			
			//个人关注数
			ChaoUserUpdateCondition incrUserFol = new ChaoUserUpdateCondition() ;
			incrUserFol.setIncrFavoriteSubjectCount(1) ;
			chaoUserService.updateUserByUserName(userName, incrUserFol) ;
			
		} else if(ChaoUserFollowTypeEnums.ACTIVITY_CHECKIN == type) {
			//活动签到
			if(IDUtils.isNotCorrect(actId)) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.activity.required") ;
			}
			
			if(StringUtils.isBlank(location) || StringUtils.isBlank(locationCode)) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.location.required") ;
			}
						
			//经纬度格式
			String[] codes = StringUtils.split(locationCode , ",") ;
			if(codes == null || codes.length != 2) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.location.format.error") ;
			}
			if(!com.doucome.chaoexpo.biz.core.utils.StringUtils.isLocationCode(codes[0]) || !com.doucome.chaoexpo.biz.core.utils.StringUtils.isLocationCode(codes[1])) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.location.format.error") ;
			}
			
			//活动是否存在
			ChaoActivityDTO activity = chaoActivityService.getActivityById(actId) ;
			if(activity == null) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.activity.notExists") ;
			}
			
			Date actStartTime = activity.getGmtActivityStart() ;
			Date actEndTime = activity.getGmtActivityEnd() ;
			
			if(!DateUtils.isBetween(new Date() , actStartTime, actEndTime)) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.activity.time.ended") ;
			}
			
			ChaoUserFollowQuery query = new ChaoUserFollowQuery() ;
			query.setUserName(userName) ;
			query.setActivityId(actId) ;
			query.setType(type.getValue()) ;
			
			List<ChaoUserFollowDTO> followList = chaoUserFollowService.getFollowsNoPagination(query) ;
			
			//已经关注过
			if(CollectionUtils.isNotEmpty(followList)) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.duplicate") ;
			}
			
			try {
				follow.setTargetName(activity.getName()) ;
				chaoUserFollowService.createFollow(follow) ;
			} catch (DuplicateKeyException e) {
				throw new ChaoUserFollowException("chao.user.activity.checkin.duplicate") ;
			}
			
			//incr 签到关注数
			ChaoActivityUpdateCondition incr = new ChaoActivityUpdateCondition() ;
			incr.setIncrCheckinCount(1) ;
			chaoActivityService.updateActivityById(actId, incr) ;
			
			//个人关注数
			ChaoUserUpdateCondition incrUserChck = new ChaoUserUpdateCondition() ;
			incrUserChck.setIncrCheckinActivityCount(1) ;
			chaoUserService.updateUserByUserName(userName, incrUserChck) ;
			
		}
		
		
		return true ;
	}
	
	@Transactional
	public boolean unFollow(ChaoUserFollowDO follow) throws ChaoUserFollowException {
		
		String userName = follow.getUserName() ;
		Long actId = follow.getActivityId() ;
		Long subjId = follow.getSubjectId() ;
		
		if(StringUtils.isBlank(userName)) {
			throw new ChaoUserFollowException("chao.user.unfollow.user.required") ;
		}
		
		ChaoUserFollowTypeEnums type = ChaoUserFollowTypeEnums.toEnum(follow.getType()) ;
		
		if(ChaoUserFollowTypeEnums.FOLLOW_ACTIVITY == type) {
			//活动是否存在
			ChaoActivityDTO activity = chaoActivityService.getActivityById(actId) ;
			if(activity == null) {
				throw new ChaoUserFollowException("chao.user.activity.unfollow.notExists") ;
			}
			
			ChaoUserFollowDelCondition del = new ChaoUserFollowDelCondition() ;
			del.setActivityId(actId) ;
			del.setType(ChaoUserFollowTypeEnums.FOLLOW_ACTIVITY.getValue()) ;
			int delCount = chaoUserFollowService.deleteFollowByCondition(userName, del) ;
			if(delCount > 0) {
				//decr 活动关注数
				ChaoActivityUpdateCondition decr = new ChaoActivityUpdateCondition() ;
				decr.setDecrFollowCount(1) ;
				chaoActivityService.updateActivityById(actId, decr) ;
				
				//个人关注数 - 1
				ChaoUserUpdateCondition decrUserFol = new ChaoUserUpdateCondition() ;
				decrUserFol.setDecrFollowActivityCount(1) ;
				chaoUserService.updateUserByUserName(userName, decrUserFol) ;
			}
		} else if(ChaoUserFollowTypeEnums.FOLLOW_SUBJECT == type) {
			//专题是否存在
			ChaoSubjectDTO subject = chaoSubjectService.getSubjectById(subjId) ;
			if(subject == null) {
				throw new ChaoUserFollowException("chao.subject.favorite.notExists") ;
			}
			
			ChaoUserFollowDelCondition del = new ChaoUserFollowDelCondition() ;
			del.setSubjectId(subjId) ;
			del.setType(ChaoUserFollowTypeEnums.FOLLOW_SUBJECT.getValue()) ;
			int delCount = chaoUserFollowService.deleteFollowByCondition(userName, del) ;
			if(delCount > 0) {
							
				//个人关注数 - 1
				ChaoUserUpdateCondition decrUserFol = new ChaoUserUpdateCondition() ;
				decrUserFol.setDecrFavoriteSubjectCount(1) ;
				chaoUserService.updateUserByUserName(userName, decrUserFol) ;
			}
			
		}
		
		return true ;
	}
}
