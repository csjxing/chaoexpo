package com.doucome.chaoexpo.web.chao.action.ajax;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.TushuoCateStatusEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoCategoryDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoCategoryQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class QueryTushuoCatesAction extends ChaoBasicAction {

	private static final Log log = LogFactory.getLog(QueryTushuoCatesAction.class) ;
	
	private JsonModel<List<ChaoTushuoCategoryDTO>> json = new JsonModel<List<ChaoTushuoCategoryDTO>>() ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	@Override
	public String execute() throws Exception {
		try {
			ChaoTushuoCategoryQuery query = new ChaoTushuoCategoryQuery() ;
			query.setStatus(TushuoCateStatusEnums.NORMAL.getValue()) ;
			List<ChaoTushuoCategoryDTO> cateList = chaoTushuoCategoryService.getCategories(query) ;
			json.setData(cateList) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
		} catch (Exception e) {
			json.setDetail("chao.tushuo.cate.query.error") ;
			json.setCode(JsonModel.CODE_FAIL) ;
			log.error(e.getMessage() , e) ;
		}
			
		return SUCCESS ;
	}

	public JsonModel<List<ChaoTushuoCategoryDTO>> getJson() {
		return json;
	}
	
}
