package com.doucome.chaoexpo.biz.core.model;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.doucome.chaoexpo.biz.core.utils.JacksonHelper;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoDeviceDO;

public class ChaoDeviceDTO {

	private static final Log log = LogFactory.getLog(ChaoDeviceDTO.class) ;
	
	private ChaoDeviceDO device ;
	
	private Map<String,String> pushParamMap ;
	
	public ChaoDeviceDTO(ChaoDeviceDO device) {
		if(device == null) {
			device = new ChaoDeviceDO() ;
		}
		this.device = device ;
	}
	
	public Map<String,String> getPushParamMap() {
		if(pushParamMap == null) {
			if(StringUtils.isNotBlank(this.getPushParam())) {
				try {
					pushParamMap = JacksonHelper.fromJSON(this.getPushParam(), Map.class) ;
				} catch (Exception e) {
					log.error(e.getMessage() , e) ;
				}
			}
		}
		return pushParamMap ;
	}
	
	/**
	 * ----------------------------------------
	 */
	
	public Long getId() {
		return device.getId();
	}

	public String getImei() {
		return device.getImei();
	}

	public String getPushParam() {
		return device.getPushParam();
	}

	public Date getGmtCreate() {
		return device.getGmtCreate();
	}

	public Date getGmtModified() {
		return device.getGmtModified() ;
	}

	public String getOsType() {
		return device.getOsType();
	}
	
}
