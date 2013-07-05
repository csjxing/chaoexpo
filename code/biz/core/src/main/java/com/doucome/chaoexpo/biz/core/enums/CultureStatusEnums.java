package com.doucome.chaoexpo.biz.core.enums;

public enum CultureStatusEnums {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private CultureStatusEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static CultureStatusEnums toEnum(String value) {
		for (CultureStatusEnums e: values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
