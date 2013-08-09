package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoUserDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoUserUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dao.ChaoUserDAO;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoUserQuery;

public class ChaoUserServiceImpl implements ChaoUserService {

	@Autowired
	private ChaoUserDAO chaoUserDAO ;
	
	@Override
	public Long createUser(ChaoUserDO user) {
		return chaoUserDAO.insertUser(user) ;
	}

	@Override
	public ChaoUserDTO getUserByUserName(String userName) {
		ChaoUserDO user = chaoUserDAO.queryUserByUserName(userName) ;
		if(user == null) {
			return null ;
		}
		return new ChaoUserDTO(user) ;
	}
	
	@Override
	public ChaoUserDTO getUserByUserNameAndAuthKey(String userName,String authKey) {
		ChaoUserDO user = chaoUserDAO.queryUserByUserNameAndAuthKey(userName,authKey) ;
		if(user == null) {
			return null ;
		}
		return new ChaoUserDTO(user) ;
	}

	@Override
	public int updateUserByUserName(String userName,ChaoUserUpdateCondition condition) {
		return chaoUserDAO.updateUserByUserName(userName, condition) ;
	}

	@Override
	public long getMaxId() {
		return chaoUserDAO.queryMaxId() ;
	}

	@Override
	public QueryResult<ChaoUserDTO> getUsersWithPagination(ChaoUserQuery query,Pagination pagination) {
		int totalRecords = chaoUserDAO.countUsersWithPagination(query) ;
        if (totalRecords <= 0) {
            return new QueryResult<ChaoUserDTO>(new ArrayList<ChaoUserDTO>(), pagination, totalRecords);
        }
        List<ChaoUserDO> doList = chaoUserDAO.queryUsersWithPagination(query,pagination.getStart(),pagination.getSize()) ;
        List<ChaoUserDTO> dtoList = new ArrayList<ChaoUserDTO>() ;
        if(CollectionUtils.isNotEmpty(doList)){
        	for(ChaoUserDO user : doList) {
        		dtoList.add(new ChaoUserDTO(user)) ;
        	}
        }
        return new QueryResult<ChaoUserDTO>(dtoList, pagination, totalRecords);
	}

}
