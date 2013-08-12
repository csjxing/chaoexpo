package com.doucome.chaoexpo.web.chao.action.ajax;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.enums.TushuoStatusEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoQuery;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

public class QueryTushuoListAction extends ChaoBasicAction {

	private static final Log log = LogFactory.getLog(QueryTushuoListAction.class) ;
	
	private JsonModel<QueryResult<ChaoTushuoDTO>> json = new JsonModel<QueryResult<ChaoTushuoDTO>>() ;
	
	private Long cateId ;
	
	@Autowired
	private ChaoTushuoService chaoTushuoService ;
	
	private int page ;
	
	@Override
	public String execute() throws Exception {
		try {
			ChaoTushuoQuery query = new ChaoTushuoQuery() ;
			query.setStatus(TushuoStatusEnums.NORMAL.getValue()) ;
			query.setCategoryId(cateId) ;
			QueryResult<ChaoTushuoDTO> result = chaoTushuoService.getTushuosWithPagination(query, new Pagination(page)) ;
			json.setData(result) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
		} catch (Exception e) {
			log.error(e.getMessage() , e) ;
			json.setDetail("chao.tushuo.query.error") ;
			json.setCode(JsonModel.CODE_FAIL) ;
		}
		return SUCCESS ;
	}

	public JsonModel<QueryResult<ChaoTushuoDTO>> getJson() {
		return json;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	
}
