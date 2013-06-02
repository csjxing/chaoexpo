package com.doucome.chaoexpo.web.bops.action.ajax;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ImageUploadBO;
import com.doucome.chaoexpo.biz.core.model.param.PictureModel;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class ImageUploadAction extends BopsBasicAction {
	
	private JsonModel<PictureModel> result = new JsonModel<PictureModel>();
	
	private String pictureUrl;
	
	private File picture;
	
	private String pictureFileName;
	
	private String pictureContentType;
	
	@Autowired
	private ImageUploadBO imageUploadBO;
	
	public String uploadLocalPicture() {
		String extName = pictureFileName.substring(pictureFileName.lastIndexOf(".") + 1);
		ResultModel<PictureModel> model = imageUploadBO.uploadPicture(picture, extName);
		if (model.isSucc()) {
			result.setSuccess(model.getData());
		} else {
			result.setFail(model.getDetail());
		}
		return SUCCESS ;
	}
	
	public String uploadUrlPicture() {
		ResultModel<PictureModel> model = imageUploadBO.uploadPicture(pictureUrl);
		if (model.isSucc()) {
			result.setSuccess(model.getData());
		} else {
			result.setFail(model.getDetail());
		}
		return SUCCESS;
	}
	
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}

	public JsonModel<PictureModel> getResult() {
		return result;
	}
}
