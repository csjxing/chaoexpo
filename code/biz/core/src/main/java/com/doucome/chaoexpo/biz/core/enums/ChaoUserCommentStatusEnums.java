package com.doucome.chaoexpo.biz.core.enums;

public enum ChaoUserCommentStatusEnums {

	NORMAL("N"), DISABLE("D"), UNKNOW("");

	private String value;

	private ChaoUserCommentStatusEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static ChaoUserCommentStatusEnums toEnum(String value) {
		for (ChaoUserCommentStatusEnums e : values()) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return UNKNOW;
	}
}
