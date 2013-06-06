package com.doucome.chaoexpo.web.bops.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ImageUploadBO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.PicModel;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddNewsAction extends BopsBasicAction implements ModelDriven<ChaoNewsDTO> {	
	
	private ChaoNewsDTO news = new ChaoNewsDTO();
	
	@Autowired
	private ChaoNewsService chaoNewsService;
	@Autowired
	private ImageUploadBO imageUploadBO;
	
	@Override
	public String execute() throws Exception {
		List<String> temps = uploadPictures(news.getPicUrlList());
		news.setPicUrlList(temps);
		if (news.getId() == null) {
		    chaoNewsService.createNews(news.toDO());
		} else {
			chaoNewsService.updateNews(news);
		}
		return SUCCESS;
	}
	
	private List<String> uploadPictures(List<String> picList) {
		List<String> result = new ArrayList<String>();
		if (CollectionUtils.isNotEmpty(picList)) {
			ResultModel<PicModel> model = null;
			for (String temp: picList) {
				if (temp.startsWith("http://")) {
					model = imageUploadBO.uploadPicture(temp);
					if (model.isSucc()) {
						result.add(model.getData().getPath());
					}
				} else {
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	public ChaoNewsDTO getModel() {
		return news;
	}
}
