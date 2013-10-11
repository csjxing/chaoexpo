package com.doucome.chaoexpo.biz.core.enums;

public enum DeviceStatusEnums {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private DeviceStatusEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static DeviceStatusEnums toEnum(String value) {
		for (DeviceStatusEnums e: values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
