package com.doucome.chaoexpo.web.bops.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ImageUploadBO;
import com.doucome.chaoexpo.biz.core.model.ChaoActivityDTO;
import com.doucome.chaoexpo.biz.core.model.PicModel;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoActivityService;
import com.doucome.chaoexpo.biz.core.utils.DateUtils;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AddActivityAction extends BopsBasicAction implements ModelDriven<ChaoActivityDTO> {
	
	private ChaoActivityDTO activity = new ChaoActivityDTO();
	
	@Autowired
	private ChaoActivityService chaoActivityService;
	
	@Autowired
	private ImageUploadBO imageUploadBO;
	
	@Override
	public String execute() throws Exception {
		
		Date actStartTime = activity.getGmtActivityStart() ;
		Date actEndTime = activity.getGmtActivityEnd() ;
		
		actStartTime = DateUtils.setTime(actStartTime, 0, 0, 0) ;
		actEndTime = DateUtils.setTime(actEndTime, 23, 59, 59) ;
		if(actStartTime.after(actEndTime)) {
			addFieldError("gmtActivity", "chao.activity.add.gmtActivity.error") ;
			return INPUT  ;
		}
		
		activity.setGmtActivityStart(actStartTime) ;
		activity.setGmtActivityEnd(actEndTime) ;
		
		List<String> temps = uploadPictures(activity.getPicUrlList());
		activity.setPicUrlList(temps);
		temps = uploadPictures(activity.getStandPicUrlList());
		activity.setStandPicUrlList(temps);
		if (activity.getId() == null) {
		    chaoActivityService.createActivity(activity.toDO());
		} else {
			chaoActivityService.updateActivity(activity);
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
	
	public ChaoActivityDTO getModel() {
		return activity;
	}

	public ChaoActivityDTO getActivity() {
		return activity;
	}

	public void setActivity(ChaoActivityDTO activity) {
		this.activity = activity;
	}
}
