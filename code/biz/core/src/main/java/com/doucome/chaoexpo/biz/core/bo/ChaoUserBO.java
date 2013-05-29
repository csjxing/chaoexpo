package com.doucome.chaoexpo.biz.core.bo;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import com.doucome.chaoexpo.biz.core.enums.ChaoUserFollowTypeEnums;
import com.doucome.chaoexpo.biz.core.exception.ChaoDuplicateKeyException;
import com.doucome.chaoexpo.biz.core.exception.ChaoUserFollowException;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserFollowDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserFollowService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.core.utils.ChaoUserUtils;
import com.doucome.chaoexpo.biz.core.utils.MD5Util;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserFollowSearchCondition;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;

/**
 * UserBO
 * @author langben 2013-5-27
 *
 */
public class ChaoUserBO {
	
	@Autowired
	private ChaoUserService chaoUserService ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Autowired
	private ChaoUserFollowService chaoUserFollowService ;

	/**
	 * 注册
	 * @return
	 * @throws ChaoDuplicateKeyException
	 */
	public ChaoUserDTO register() throws ChaoDuplicateKeyException {
		
		Long maxId = chaoUserService.getMaxId() ;
		
		String userName = ChaoUserUtils.randomUserName(maxId) ;
		for(int i = 0 ; i < 2 ; i ++) {
			ChaoUserDTO existsUser = chaoUserService.getUserByUserName(userName) ;
			if(existsUser != null) {
				userName += "_0" ;
				continue ;
			}
			break ;
		}
		String authKey = MD5Util.getMD5(userName) ;
		ChaoUserDO user = new ChaoUserDO() ;
		user.setUserName(userName) ;
		user.setAuthKey(authKey) ;
		user.setGmtAuth(new Date()) ;
		try {
			Long newId = chaoUserService.createUser(user) ;
			return chaoUserService.getUserByUserName(userName) ;
			
		} catch (DuplicateKeyException e) {
			throw new ChaoDuplicateKeyException(e) ;
		}
		
	}
	
	@Transactional
	public boolean followActivity(String userName , Long actId) throws ChaoUserFollowException {
		//活动是否存在
		ChaoActivityDTO activity = chaoActivityService.getActivityById(actId) ;
		if(activity == null) {
			throw new ChaoUserFollowException("chao.activity.follow.notExists") ;
		}
		
		//
		ChaoUserFollowSearchCondition condition = new ChaoUserFollowSearchCondition() ;
		condition.setUserName(userName) ;
		condition.setActivityId(actId) ;
		condition.setType(ChaoUserFollowTypeEnums.ACTIVITY.getValue()) ;
		
		List<ChaoUserFollowDTO> followList = chaoUserFollowService.getFollowsNoPagination(condition) ;
		
		//已经关注过
		if(CollectionUtils.isNotEmpty(followList)) {
			throw new ChaoUserFollowException("chao.activity.follow.duplicate") ;
		}
		
		ChaoUserFollowDO follow = new ChaoUserFollowDO() ;
		follow.setUserName(userName) ;
		follow.setType(ChaoUserFollowTypeEnums.ACTIVITY.getValue()) ;
		follow.setActivityId(actId) ;
		chaoUserFollowService.createFollow(follow) ;
		
		//incr 活动关注数
		ChaoActivityUpdateCondition incr = new ChaoActivityUpdateCondition() ;
		incr.setIncrFollowCount(1) ;
		chaoActivityService.updateActivityById(actId, incr) ;
		
		//个人关注数
		ChaoUserUpdateCondition incrUserFol = new ChaoUserUpdateCondition() ;
		incrUserFol.setIncrFollowActivityCount(1) ;
		chaoUserService.updateUserByUserName(userName, incrUserFol) ;
		
		return true ;
	}
	
}
