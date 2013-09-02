package com.doucome.chaoexpo.biz.core.bo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import com.doucome.chaoexpo.biz.core.enums.TrueOrFalseEnums;
import com.doucome.chaoexpo.biz.core.exception.ChaoActivitySignupException;
import com.doucome.chaoexpo.biz.core.exception.ChaoDuplicateKeyException;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivitySignupService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.core.utils.ChaoUserUtils;
import com.doucome.chaoexpo.biz.core.utils.MD5Util;
import com.doucome.chaoexpo.biz.dal.condition.ChaoActivityUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivitySignupDO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;

/**
 * UserBO
 * @author langben 2013-5-27
 *
 */
public class ChaoUserBO {
	
	@Autowired
	private ChaoUserService chaoUserService ;

	@Autowired
	private ChaoActivitySignupService chaoActivitySignupService ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
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
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void signupActivity(ChaoActivityDTO act , String userName , String contactName , String contactPhone) throws ChaoActivitySignupException {
		if(act == null) {
			throw new ChaoActivitySignupException("chao.activity.signup.act.notExists") ;
			
		}
		
		if(TrueOrFalseEnums.toEnum(act.getCanSignup()) != TrueOrFalseEnums.TRUE) {
			throw new ChaoActivitySignupException("chao.activity.signup.act.signupClosed") ;
		}
		
		ChaoActivitySignupDO signup = new ChaoActivitySignupDO() ;
		signup.setActivityId(act.getId()) ;
		signup.setActivityName(act.getName()) ;
		signup.setContactName(contactName) ;
		signup.setContactPhone(contactPhone) ;
		signup.setUserName(userName) ;
		try {
			long newId = chaoActivitySignupService.createActivitySignup(signup) ;
			ChaoActivityUpdateCondition update = new ChaoActivityUpdateCondition() ;
			update.setIncrSignupCount(1) ;
			chaoActivityService.updateActivityById(act.getId(), update) ;
		} catch (DuplicateKeyException e) {
			throw new ChaoActivitySignupException("chao.activity.signup.duplicate") ;
		}
	}
}
