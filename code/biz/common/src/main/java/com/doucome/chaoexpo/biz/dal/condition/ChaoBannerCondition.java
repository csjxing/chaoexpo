package com.doucome.chaoexpo.biz.dal.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoBannerCondition extends AbstractModel  {
	
	private static final long serialVersionUID = 1L;

	private String bannerId;
	
	private String status ;
	
	private Date gmtCreateStart;
	
	private Date gmtCreateEnd;
	
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("bannerId", bannerId);
		result.put("status", status);
		result.put("gmtCreateStart", gmtCreateStart);
		result.put("gmtCreateEnd", gmtCreateEnd);
		return result;
	}

	public String getBannerId() {
		return bannerId;
	}

	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	public Date getGmtCreateStart() {
		return gmtCreateStart;
	}

	public void setGmtCreateStart(Date gmtCreateStart) {
		this.gmtCreateStart = gmtCreateStart;
	}

	public Date getGmtCreateEnd() {
		return gmtCreateEnd;
	}

	public void setGmtCreateEnd(Date gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
