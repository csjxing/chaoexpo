package com.doucome.chaoexpo.biz.core.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.core.constant.URIConstant;
import com.doucome.chaoexpo.biz.core.enums.PictureSizeEnums;
import com.doucome.chaoexpo.biz.core.service.impl.DefaultUriService;

/**
 * 图片工具
 * @author langben 2012-7-24
 *
 */
public class PictureUtils {

	/**
	 * 根据原始图片找到对应图片
	 * @param picUrl
	 * @param type
	 * @return
	 */
	public static String findPic(String picUrl , PictureSizeEnums type){
		if(type == null){
			return picUrl ;
		}
		
		String ext = FilenameUtils.getExtension(picUrl) ;
		if(type == PictureSizeEnums.NONE){
			return picUrl ;
		}
		return picUrl + "_" + type.getName() + ".jpg" ;
	}
	
	public static String findOriginalPicUrl(String picUrl) {
		if (StringUtils.isEmpty(picUrl)) {
			return picUrl;
		}
		for (PictureSizeEnums sizeEnums: PictureSizeEnums.values()) {
			String suffix = "_" + sizeEnums.getName() + ".jpg";
			if (picUrl.endsWith(suffix)) {
				int index = picUrl.indexOf(suffix);
				String temp = picUrl.substring(0, index);
				if (!temp.endsWith(".jpg")) {
					return picUrl;
				}
				return temp;
			}
		}
		return picUrl;
	}
	
	/**
	 * 
	 * @param picPath
	 * @param sizeEnum
	 * @return
	 */
	public static String getPicAbsoluteUrl(String picPath, PictureSizeEnums sizeEnum) {
		if (StringUtils.isEmpty(picPath)) {
			return picPath;
		}
		StringBuilder tempPath = new StringBuilder();
		if (!picPath.startsWith("http://")) {
			tempPath.append(DefaultUriService.getFactoryURI(URIConstant.PICTURE_ROOT));
		}
		tempPath.append(picPath);
		if (sizeEnum != null && sizeEnum != PictureSizeEnums.NONE) {
			tempPath.append("_").append(sizeEnum.getName()).append(".jpg");
		}
		return tempPath.toString();
	}
	
	/**
	 */
	public static String getPicPath(String picPath, PictureSizeEnums sizeEnum) {
		if (sizeEnum == null || sizeEnum == PictureSizeEnums.NONE) {
			return picPath;
		}
		StringBuilder tempPath = new StringBuilder();
		tempPath.append(picPath).append("_").append(sizeEnum.getName()).append(".jpg");
		return tempPath.toString();
	}
}
