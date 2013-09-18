package com.doucome.chaoexpo.biz.core.enums;

public enum DevicePushParamKeyEnums {

	IOS_DEVICE_TOKEN("IOS_DEV_TOKEN"),
	UNKNOW("");
	
	private String value;
	
	private DevicePushParamKeyEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static DevicePushParamKeyEnums toEnum(String value) {
		for (DevicePushParamKeyEnums e: values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
