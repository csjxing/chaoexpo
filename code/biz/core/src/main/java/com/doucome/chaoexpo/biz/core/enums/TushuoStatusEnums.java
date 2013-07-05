package com.doucome.chaoexpo.biz.core.enums;

public enum TushuoStatusEnums {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private TushuoStatusEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static TushuoStatusEnums toEnum(String value) {
		for (TushuoStatusEnums e: values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
