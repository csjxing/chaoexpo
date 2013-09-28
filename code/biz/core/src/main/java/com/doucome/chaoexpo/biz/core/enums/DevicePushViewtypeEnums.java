package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author langben 2013-9-28
 *
 */
public enum DevicePushViewtypeEnums {

	DEFAULT(""), 
	ACTIVITY("activity"), 
	NEWS("news"), 
	IMAGESTORY("imagestory"),
	WEB("web"),
	UNKNOW("unknown");

	private String value;

	private DevicePushViewtypeEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static DevicePushViewtypeEnums toEnum(String value) {
		for (DevicePushViewtypeEnums e : values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
	
}
