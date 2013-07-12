package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.core.utils.PictureUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

@SuppressWarnings("serial")
public class ChaoTushuoDTO extends AbstractModel {

	private ChaoTushuoDO tushuo ;
	
	public ChaoTushuoDTO(ChaoTushuoDO tushuo) {
		if(tushuo == null) {
			tushuo = new ChaoTushuoDO() ;
		}
		this.tushuo = tushuo ;
	}
	
	public List<PicModel> getPicModelList() {
		List<String> picList = ArrayStringUtils.toList(getPicUrls()) ;
		return PictureUtils.toModelList(picList) ;
	}
	
	public PicModel getPicModel() {
		List<String> picList = ArrayStringUtils.toList(getPicUrls()) ;
		if(CollectionUtils.isEmpty(picList)) {
			return null ;
		}
		return new PicModel(picList.iterator().next()) ;
	}
	
	public String getSubContent(int length) {
		return StringUtils.substring(getContent(), 0, length) ;
	}
	/**
	 * --------------------------------------------------
	 */
	
	public Long getId() {
		return tushuo.getId();
	}

	public String getName() {
		return tushuo.getName();
	}

	public String getPicUrls() {
		return tushuo.getPicUrls();
	}

	public String getContent() {
		return tushuo.getContent();
	}

	public String getCategory() {
		return tushuo.getCategory();
	}
	
	public String getStatus(){
		return tushuo.getStatus() ;
	}

	public Date getGmtCreate() {
		return tushuo.getGmtCreate();
	}

	public Date getGmtModified() {
		return tushuo.getGmtModified();
	}

}
