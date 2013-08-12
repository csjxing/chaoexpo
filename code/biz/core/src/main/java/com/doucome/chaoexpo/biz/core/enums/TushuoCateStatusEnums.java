package com.doucome.chaoexpo.biz.core.enums;

public enum TushuoCateStatusEnums {

	NORMAL("N"), DISABLE("D"), UNKNOW("");

	private String value;

	private TushuoCateStatusEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static TushuoCateStatusEnums toEnum(String value) {
		for (TushuoCateStatusEnums e : values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
