package com.doucome.chaoexpo.biz.core.enums;

public enum BannerStatusEnums {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private BannerStatusEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static BannerStatusEnums toEnum(String value) {
		for (BannerStatusEnums e: values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
