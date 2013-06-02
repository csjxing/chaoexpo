package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddNewsAction extends BopsBasicAction implements ModelDriven<ChaoNewsDTO> {	
	
	private ChaoNewsDTO news = new ChaoNewsDTO();
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	
	@Override
	public String execute() throws Exception {
		
		if (news.getId() == null) {
		    chaoNewsService.createNews(news.toDO());
		} else {
			chaoNewsService.updateNews(news);
		}
		
		return SUCCESS ;
	}
	
	public ChaoNewsDTO getModel() {
		return news;
	}
}
