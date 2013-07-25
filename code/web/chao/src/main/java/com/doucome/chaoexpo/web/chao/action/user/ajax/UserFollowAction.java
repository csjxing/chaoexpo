package com.doucome.chaoexpo.web.chao.action.user.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ChaoUserFollowBO;
import com.doucome.chaoexpo.biz.core.exception.ChaoUserFollowException;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserFollowDO;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 关注
 * @author langben 2013-5-28
 *
 */
public class UserFollowAction extends ChaoBasicAction implements ModelDriven<ChaoUserFollowDO>{

	private ChaoUserFollowDO follow = new ChaoUserFollowDO() ;
	
	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	@Autowired
	private ChaoUserFollowBO chaoUserFollowBO ;
	
	/**
	 * 关注活动
	 * @return
	 */
	public String execute() {
		
		String userName = chaoAuthz.getUserName() ;
		follow.setUserName(userName) ;
		try {
			chaoUserFollowBO.addFollow(follow) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
		} catch (ChaoUserFollowException e) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail(e.getMessage()) ;
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}
	
	public String unfollow() {

		String userName = chaoAuthz.getUserName() ;
		follow.setUserName(userName) ;
		try {
			chaoUserFollowBO.unFollow(follow) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
		} catch (ChaoUserFollowException e) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail(e.getMessage()) ;
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	@Override
	public ChaoUserFollowDO getModel() {
		return follow ;
	}
	
	
}
