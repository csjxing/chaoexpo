package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoTushuoDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoService;
import com.doucome.chaoexpo.biz.dal.query.ChaoTushuoQuery;

/**
 * 图说
 * @author langben 2013-6-20
 *
 */
@SuppressWarnings("serial")
public class TushuoListAction extends BopsBasicAction {

	private QueryResult<ChaoTushuoDTO> queryResult ;
	
	@Autowired
	private ChaoTushuoService chaoTushuoService ;
	
	private int page ;
	
	@Override
	public String execute() throws Exception {
		
		queryResult = chaoTushuoService.getTushuosWithPagination(new ChaoTushuoQuery(), new Pagination(page)) ;
		
		return SUCCESS ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public QueryResult<ChaoTushuoDTO> getQueryResult() {
		return queryResult;
	}
	
}
