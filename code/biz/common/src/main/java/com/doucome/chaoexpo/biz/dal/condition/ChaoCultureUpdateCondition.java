package com.doucome.chaoexpo.biz.dal.condition;

import java.util.HashMap;
import java.util.Map;

import com.doucome.chaoexpo.biz.common.utils.ReflectUtils;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;
import com.doucome.chaoexpo.biz.dal.model.AbstractModel;

public class ChaoCultureUpdateCondition extends AbstractModel  {

	/**
	 * 名称
	 */
	private String name ;
	
	/**
	 * 
	 */
	private String intro ;
	
	/**
	 * 
	 */
	private String picUrls ;
	
	/**
	 * 
	 */
	private String status ;
	
	public static ChaoCultureUpdateCondition fromCulture(ChaoCultureDO culture) {
		ChaoCultureUpdateCondition condition = new ChaoCultureUpdateCondition() ;
		ReflectUtils.reflectTo(culture, condition) ;
		return condition;
	} 
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("name", name) ;
		map.put("intro", intro) ;
		map.put("picUrls", picUrls) ;
		map.put("status", status) ;
		return map ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String picUrls) {
		this.picUrls = picUrls;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
