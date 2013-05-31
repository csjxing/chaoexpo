package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;

@SuppressWarnings("serial")
public class ChaoNewsAction extends BopsBasicAction {
	
	private ChaoNewsDTO news;
	
	private Long id;
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	
	@Override
	public String execute() throws Exception {
		if (IDUtils.isCorrect(id)) {
			news = chaoNewsService.getNews(id);
		}
		return SUCCESS ;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ChaoNewsDTO getNews() {
		return news;
	}
}
