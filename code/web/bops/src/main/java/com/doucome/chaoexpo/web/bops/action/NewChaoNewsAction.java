package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.model.param.PictureModel;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.biz.core.utils.ChaoNewsUtils;
import com.doucome.chaoexpo.biz.dal.condition.ChaoNewsUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class NewChaoNewsAction extends BopsBasicAction implements ModelDriven<ChaoNewsDO> {
	
	private ChaoNewsDO news = new ChaoNewsDO();
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	
	@Override
	public String execute() throws Exception {
		
		if (news.getId() == null) {
		    Long id = chaoNewsService.createNews(news);
		} else {
			ChaoNewsUpdateCondition condition = ChaoNewsUtils.fromNewDO(news) ;
			chaoNewsService.updateNewsById(news.getId() , condition );
		}
		
		return SUCCESS ;
	}
	
	private PictureModel uploadPicture() {
		
		return null;
	}
	
	public ChaoNewsDO getModel() {
		return news;
	}
}
