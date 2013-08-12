package com.doucome.chaoexpo.web.bops.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ImageUploadBO;
import com.doucome.chaoexpo.biz.core.model.ChaoSubjectDTO;
import com.doucome.chaoexpo.biz.core.model.PicModel;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoSubjectService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddSubjectAction extends BopsBasicAction implements ModelDriven<ChaoSubjectDTO> {
	
	private ChaoSubjectDTO subject = new ChaoSubjectDTO();
	
	@Autowired
	private ChaoSubjectService chaoSubjectService;
	@Autowired
	private ImageUploadBO imageUploadBO;
	
	@Override
	public String execute() throws Exception {
		List<String> temps = uploadPictures(subject.getPicUrlList());
		subject.setPicUrlList(temps);
		if (subject.getId() == null) {
			chaoSubjectService.createSubject(subject);
		} else {
			chaoSubjectService.updateSubject(subject);
		}
		return SUCCESS ;
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
	
	public ChaoSubjectDTO getModel() {
		return subject;
	}
}
