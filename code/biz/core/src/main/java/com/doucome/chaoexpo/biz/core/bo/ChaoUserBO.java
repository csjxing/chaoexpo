package com.doucome.chaoexpo.biz.core.bo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.doucome.chaoexpo.biz.core.exception.ChaoDuplicateKeyException;
import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.core.utils.ChaoUserUtils;
import com.doucome.chaoexpo.biz.core.utils.MD5Util;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;

/**
 * UserBO
 * @author langben 2013-5-27
 *
 */
public class ChaoUserBO {
	
	@Autowired
	private ChaoUserService chaoUserService ;

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
	
}
