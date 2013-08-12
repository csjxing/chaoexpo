package com.doucome.chaoexpo.biz.core.model;

import com.doucome.chaoexpo.biz.core.enums.PictureSizeEnums;
import com.doucome.chaoexpo.biz.core.utils.PictureUtils;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

/**
 * 
 * @author ze2200
 *
 */
public class BannerPicModel extends AbstractModel {
	
	private static final long serialVersionUID = 1L;
	
	private BannerPicConfig picConfig;
	
	public BannerPicModel() {
		this(null);
	}
	
	public BannerPicModel(BannerPicConfig picConfig) {
		if (picConfig == null) {
			picConfig = new BannerPicConfig();
		}
		this.picConfig =  picConfig;
	}

	public String getPicPath() {
		return picConfig.getPicPath();
	}

	public void setPicPath(String picPath) {
		picConfig.setPicPath(picPath);
	}

	public String getClickUrl() {
		return picConfig.getClickUrl();
	}

	public void setClickUrl(String clickUrl) {
		picConfig.setClickUrl(clickUrl);
	}

	public String getPicUrl() {
		return PictureUtils.getPicAbsoluteUrl(getPicPath(), PictureSizeEnums.NONE) ;
	}
	
	public String getPicUrl100x000() {
		return PictureUtils.getPicAbsoluteUrl(getPicPath(), PictureSizeEnums._100x000) ;
	}
	
	public String getSumPicUrl(String size) {
		return PictureUtils.getPicAbsoluteUrl(getPicPath(), PictureSizeEnums.toEnum(size)) ;
	}
	
	public BannerPicConfig toPicConfig() {
		return this.picConfig;
	}
	
}
