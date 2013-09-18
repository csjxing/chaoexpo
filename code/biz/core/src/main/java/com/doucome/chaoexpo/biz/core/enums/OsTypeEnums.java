package com.doucome.chaoexpo.biz.core.enums;

public enum OsTypeEnums {

	IOS("IOS"),
	UNKNOW("");
	
	private String value;
	
	private OsTypeEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static OsTypeEnums toEnum(String value) {
		for (OsTypeEnums e: values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
