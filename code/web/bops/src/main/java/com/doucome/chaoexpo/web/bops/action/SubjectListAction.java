package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoSubjectSearchCondition;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class SubjectListAction extends BopsBasicAction implements ModelDriven<ChaoSubjectSearchCondition> {
	
	private QueryResult<ChaoSubjectDTO> subjectResult;
	
	private ChaoSubjectSearchCondition condition = new ChaoSubjectSearchCondition();
	
	@Autowired
	private ChaoSubjectService chaoSubjectService;
	
	private int page;
	
	@Override
	public String execute() throws Exception {
		subjectResult = chaoSubjectService.getSubjectsWithPagination(condition, new Pagination(page));
		return SUCCESS ;
	}
	
	public QueryResult<ChaoSubjectDTO> getSubjectResult() {
		return subjectResult;
	}
	
	public ChaoSubjectSearchCondition getModel() {
		return condition;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
