package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author langben 2013-5-27
 *
 */
public enum ChaoUserFollowTypeEnums {

	/**
	 * 活动关注
	 */
	ACTIVITY("ACT") ,
	
	/**
	 * 专题关注
	 */
	SUBJECT("SUBJ") ,
	
	/**
	 * 商户
	 */
	TENANT("TEN") ,
	
	UNKNOWN("") ,
	;
	
	private String value;
	
	private ChaoUserFollowTypeEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChaoUserFollowTypeEnums toEnum(String value) {
		for (ChaoUserFollowTypeEnums temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOWN;
	}
}
