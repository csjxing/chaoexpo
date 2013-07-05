package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.CultureStatusEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoCultureDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoFirstReadDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoIntroDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoCultureService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoIntroService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoCultureQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 初访必读
 * @author langben 2013-6-19
 *
 */
public class FirstReadAction extends ChaoBasicAction {
	
	private JsonModel<ChaoFirstReadDTO> json = new JsonModel<ChaoFirstReadDTO>() ;

	@Autowired
	private ChaoIntroService chaoIntroService ;
	
	@Autowired
	private ChaoCultureService chaoCultureService ;
	
	private int page = 1 ;
	
	@Override
	public String execute() throws Exception {
		
		ChaoFirstReadDTO firstRead = new ChaoFirstReadDTO() ;
		
		ChaoIntroDTO intro = chaoIntroService.getIntro() ;
		ChaoCultureQuery query = new ChaoCultureQuery() ;
		query.setStatus(CultureStatusEnums.NORMAL.getValue()) ;
		QueryResult<ChaoCultureDTO> cultureResult = chaoCultureService.getCulturesWithPagination(query,new Pagination(page)) ;
		
		firstRead.setIntro(intro) ;
		firstRead.setCultureList(cultureResult.getItems()) ;
		
		json.setCode(JsonModel.CODE_SUCCESS) ;
		json.setData(firstRead) ;
		
		return SUCCESS ;
	}

	public JsonModel<ChaoFirstReadDTO> getJson() {
		return json;
	}
	
}
