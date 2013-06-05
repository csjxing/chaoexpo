package com.doucome.chaoexpo.biz.core.model;

import com.doucome.chaoexpo.biz.core.enums.PictureSizeEnums;
import com.doucome.chaoexpo.biz.core.utils.PictureUtils;

public class PicModel {
	
	public PicModel(String path) {
		this.path = path ;
	}

	private String path ;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return PictureUtils.getPicAbsoluteUrl(path, PictureSizeEnums.NONE) ;
	}
	
	public String getSum100x000() {
		return PictureUtils.getPicAbsoluteUrl(path, PictureSizeEnums._100x000) ;
	}
	
	public String getSum(String size) {
		return PictureUtils.getPicAbsoluteUrl(path, PictureSizeEnums.toEnum(size)) ;
	}
	
}
