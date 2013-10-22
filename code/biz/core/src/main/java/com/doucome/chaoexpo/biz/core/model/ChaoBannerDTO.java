package com.doucome.chaoexpo.biz.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.doucome.chaoexpo.biz.core.utils.JacksonHelper;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoBannerDO;

public class ChaoBannerDTO {

	private ChaoBannerDO banner;
	
	private List<BannerPicModel> picModels;

	public ChaoBannerDTO() {
		this(null);
	}
	
	public ChaoBannerDTO(ChaoBannerDO banner) {
		if (banner == null) {
			banner = new ChaoBannerDO();
		}
		this.banner = banner;
		initPicModels(banner.getPicConfigs());
	}
	
	private void initPicModels(String picConfigs) {
		picModels = new ArrayList<BannerPicModel>();
		try {
			BannerPicConfig[] configs = JacksonHelper.fromJSON(picConfigs, BannerPicConfig[].class);
			CollectionUtils.reverseArray(configs) ;
			for (BannerPicConfig config: configs) {
				picModels.add(new BannerPicModel(config));
			}
			
		} catch (Exception e) {
			
		}
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
		return picModels;
	}
	
	public void setPicModels(List<BannerPicModel> picModels) {
		this.picModels = picModels;
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
		if (CollectionUtils.isNotEmpty(picModels)) {
			List<BannerPicConfig> picConfigList = new ArrayList<BannerPicConfig>() ;
			for (int i = 0; i < picModels.size(); i++) {
				BannerPicModel bpm = picModels.get(i) ;
				if(bpm != null) {
					picConfigList.add(picModels.get(i).toPicConfig()) ;
				}
			}
			try {
				BannerPicConfig[] picConfigs = picConfigList.toArray(new BannerPicConfig[picConfigList.size()]);
				banner.setPicConfigs(JacksonHelper.toJSON(picConfigs));
			} catch(Exception e) {
				
			}
		}
		return banner;
	}
}
