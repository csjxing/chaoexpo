package com.doucome.chaoexpo.web.bops.action.ajax;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ImageUploadBO;
import com.doucome.chaoexpo.biz.core.model.PicModel;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BImageUploadAction extends BopsBasicAction {
	
	private JsonModel<PicModel> json = new JsonModel<PicModel>();
	
	private String pictureUrl;
	
	private File picture;
	
	private String pictureFileName;
	
	private String pictureContentType;
	
	@Autowired
	private ImageUploadBO imageUploadBO;
	
	public String uploadLocalImage() {
//		PicModel temp = new PicModel("/upload/product/201307/12/1813372004731934.jpg");
//		json.setSuccess(temp);
		String extName = pictureFileName.substring(pictureFileName.lastIndexOf(".") + 1);
		ResultModel<PicModel> model = imageUploadBO.uploadPicture(picture, extName);
		if (model.isSucc()) {
			json.setSuccess(model.getData());
		} else {
			json.setFail(model.getDetail());
		}
		return SUCCESS ;
	}
	
	public String uploadUrlImage() {
//		PicModel temp = new PicModel("/upload/product/201306/24/2128071105370156.jpg");
//		json.setSuccess(temp);
		ResultModel<PicModel> model = imageUploadBO.uploadPicture(pictureUrl);
		if (model.isSucc()) {
			json.setSuccess(model.getData());
		} else {
			json.setFail(model.getDetail());
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

	public JsonModel<PicModel> getJson() {
		return json;
	}
}
