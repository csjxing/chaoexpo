package com.doucome.chaoexpo.biz.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.core.utils.JacksonHelper;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoBannerDO;

public class ChaoBannerDTO {

	private ChaoBannerDO banner;

	public ChaoBannerDTO() {
		this(null);
	}
	
	public ChaoBannerDTO(ChaoBannerDO banner) {
		if (banner == null) {
			banner = new ChaoBannerDO();
		}
		this.banner = banner;
	}
	
	public Long getId() {
		return banner.getId();
	}

	public void setId(Long id) {
		banner.setId(id);
	}

	public String getBannerId() {
		return banner.getBannerId();
	}

	public void setBannerId(String bannerId) {
		banner.setBannerId(bannerId);
	}
	
	public List<BannerPicModel> getPicModels() {
		List<BannerPicModel> models = new ArrayList<BannerPicModel>();
		String[] picConfigs = StringUtils.split(banner.getPicConfigs(), ";");
		for (String temp: picConfigs) {
			try {
				models.add(new BannerPicModel(JacksonHelper.fromJSON(temp, BannerPicConfig.class)));
			} catch (Exception e) {
			}
		}
		return models;
	}
	
	public void setPicConfigs(List<String> picConfigs) {
		banner.setPicConfigs(ArrayStringUtils.toString(picConfigs, ";"));
	}

	public String getStatus() {
		return banner.getStatus();
	}

	public void setStatus(String status) {
		banner.setStatus(status);
	}
	
	public String getMemo() {
		return banner.getMemo();
	}
	
	public void setMemo(String memo) {
		banner.setMemo(memo);
	}

	public Date getGmtCreate() {
		return banner.getGmtCreate();
	}

	public void setGmtCreate(Date gmtCreate) {
		banner.setGmtCreate(gmtCreate);
	}

	public Date getGmtModified() {
		return banner.getGmtModified();
	}

	public void setGmtModified(Date gmtModified) {
		banner.setGmtModified(gmtModified);
	}
	
	public ChaoBannerDO toDO() {
		return banner;
	}
}
