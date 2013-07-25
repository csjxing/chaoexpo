package com.doucome.chaoexpo.biz.core.enums;

public enum UserStatusEnums {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private UserStatusEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static UserStatusEnums toEnum(String value) {
		for (UserStatusEnums e: values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
