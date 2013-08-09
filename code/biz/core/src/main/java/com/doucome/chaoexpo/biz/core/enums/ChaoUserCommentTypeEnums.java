package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author langben 2013-5-27
 *
 */
public enum ChaoUserCommentTypeEnums {

	/**
	 * 活动关注
	 */
	ACTIVITY("ACT") ,
	
	/**
	 * 专题关注
	 */
	NEWS("NEWS") ,
	
	UNKNOWN("") ,
	;
	
	private String value;
	
	private ChaoUserCommentTypeEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChaoUserCommentTypeEnums toEnum(String value) {
		for (ChaoUserCommentTypeEnums temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOWN;
	}
}
