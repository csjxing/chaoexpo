package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.enums.CultureStatusEnums;
import com.doucome.chaoexpo.biz.core.enums.TushuoStatusEnums;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoAppRecommendService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCultureService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureUpdateCondition;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 
 * @author langben 2013-6-19
 *
 */
public class CultureOperateAction extends BopsBasicAction  {

	private JsonModel<Boolean> json = new JsonModel<Boolean>();
	
	private Long id ;
	
	private String status ;
	
	@Autowired
	private ChaoCultureService chaoCultureService ;
	
	public String updateStatus () {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.culture.delete.id.error") ;
			return SUCCESS ;
		}
		
		CultureStatusEnums e = CultureStatusEnums.toEnum(status) ;
		if(e == CultureStatusEnums.UNKNOW) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.culture.updateStatus.status.error") ;
			return SUCCESS ;
		}
		
		ChaoCultureUpdateCondition condition = new ChaoCultureUpdateCondition() ;
		condition.setStatus(status) ;
		int effectCount = chaoCultureService.updateCultureById(id, condition) ;
		if(effectCount <= 0) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("bops.culture.updateStatus.effectCount.zero") ;
			return SUCCESS ;
		}
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		
		return SUCCESS ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
