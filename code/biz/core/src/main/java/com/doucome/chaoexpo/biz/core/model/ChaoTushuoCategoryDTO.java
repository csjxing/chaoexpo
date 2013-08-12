package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.core.utils.PictureUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

@SuppressWarnings("serial")
public class ChaoTushuoCategoryDTO extends AbstractModel {

	private ChaoTushuoCategoryDO category;

	public ChaoTushuoCategoryDTO(ChaoTushuoCategoryDO category) {
		if (category == null) {
			category = new ChaoTushuoCategoryDO();
		}
		this.category = category;
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
	
	public String getIntro(int length) {
		return StringUtils.substring(getIntro(), 0 , length) ;
	}
	
	/**
	 * -----------------------------------------------
	 */

	public Long getId() {
		return category.getId();
	}

	public String getName() {
		return category.getName();
	}

	public Date getGmtCreate() {
		return category.getGmtCreate();
	}

	public String getIntro() {
		return category.getIntro();
	}

	public Date getGmtModified() {
		return category.getGmtModified();
	}

	public String getPicUrls() {
		return category.getPicUrls();
	}
	
	public Integer getTushuoCount() {
		return category.getTushuoCount();
	}
	
	public String getStatus() {
		return category.getStatus() ;
	}
}
