package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 活动列表
 * @author langben 2013-5-21
 *
 */
public class QueryActivityDetailAction extends ChaoBasicAction {

	private JsonModel<ChaoActivityDTO> json = new JsonModel<ChaoActivityDTO>() ;
	
	private Long id ;
	
	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Autowired
	private ChaoSubjectService chaoSubjectService ;
	
	@Override
	public String execute() throws Exception {
		
		if(IDUtils.isNotCorrect(id)) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.activity.query.id.required") ;
			return SUCCESS ;
		}
		
		try {
			ChaoActivityDTO activity = chaoActivityService.getActivityById(id) ;
			
			//查询专题
			if(activity != null && IDUtils.isCorrect(activity.getSubjectId())) {
				Long subjectId = activity.getSubjectId() ;
				ChaoSubjectDTO subject = chaoSubjectService.getSubjectById(subjectId) ;
				activity.setSubject(subject) ;
			}
			
			json.setCode(JsonModel.CODE_SUCCESS) ;
			json.setData(activity) ;
		} catch (Exception e) {
			json.setCode(JsonModel.CODE_FAIL) ;
			json.setDetail(e.getMessage()) ;
		}
		
		return SUCCESS ;
	}

	
	public JsonModel<ChaoActivityDTO> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
