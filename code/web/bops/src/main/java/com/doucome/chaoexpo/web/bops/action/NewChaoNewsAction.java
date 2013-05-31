package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.param.PictureModel;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class NewChaoNewsAction extends BopsBasicAction implements ModelDriven<ChaoNewsDTO> {
	
	private ChaoNewsDTO news = new ChaoNewsDTO();
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	
	@Override
	public String execute() throws Exception {
		
		if (news.getId() == null) {
		    Long id = chaoNewsService.createNews(news);
		} else {
			chaoNewsService.updateNews(news);
		}
		
		return SUCCESS ;
	}
	
	private PictureModel uploadPicture() {
		
		return null;
	}
	
	public ChaoNewsDTO getModel() {
		return news;
	}
}
