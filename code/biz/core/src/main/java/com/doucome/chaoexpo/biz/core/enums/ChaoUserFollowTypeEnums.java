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
	FOLLOW_ACTIVITY("FOL_ACT") ,
	
	/**
	 * 收藏专题
	 */
	FOLLOW_SUBJECT("FOL_SUBJ") ,
	
	/**
	 * 活动签到
	 */
	ACTIVITY_CHECKIN("ACT_CHK") ,
	
	/**
	 * 商户
	 */
	FAVORITE_TENANT("FAV_TEN") ,
	
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
