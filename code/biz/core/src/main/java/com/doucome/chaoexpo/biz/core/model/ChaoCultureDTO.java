package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.core.utils.PictureUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoCultureDTO extends AbstractModel {

	private ChaoCultureDO culture ;
	
	public ChaoCultureDTO(ChaoCultureDO culture) {
		if(culture == null) {
			culture = new ChaoCultureDO() ;
		}
		this.culture = culture ;
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
	
	public String getSubIntro(int length) {
		return StringUtils.substring(getIntro(), 0 , length) ;
	}
	
	/**
	 * ----------------------------
	 * @return
	 */
	
	public Long getId() {
		return culture.getId();
	}

	public String getName() {
		return culture.getName();
	}

	public String getIntro() {
		return culture.getIntro();
	}

	public String getPicUrls() {
		return culture.getPicUrls();
	}

	public String getStatus() {
		return culture.getStatus() ;
	}
	
	public Date getGmtModified() {
		return culture.getGmtModified();
	}

	public Date getGmtCreate() {
		return culture.getGmtCreate();
	}
	
}
