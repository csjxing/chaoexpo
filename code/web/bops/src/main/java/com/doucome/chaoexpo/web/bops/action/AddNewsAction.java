package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.core.utils.ChaoNewsUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class NewNewsAction extends BopsBasicAction implements ModelDriven<ChaoNewsDTO> {	
	private ChaoNewsDO news = new ChaoNewsDO();
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	
	@Override
	public String execute() throws Exception {
		
		if (news.getId() == null) {
		    chaoNewsService.createNews(news);
		} else {
			ChaoNewsUpdateCondition condition = ChaoNewsUtils.fromNewDO(news) ;
			chaoNewsService.updateNewsById(news.getId() , condition );
		}
		
		return SUCCESS ;
	}
	
	public ChaoNewsDTO getModel() {
		return news;
	}
}
