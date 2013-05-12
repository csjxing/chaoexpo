package com.doucome.chaoexpo.biz.core.enums;

public enum SuccOrFailEnums {
	SUCCESS("S"), 
	FAIL("F"),
	UNKNOWN("");
	
	private String value;
	
	private SuccOrFailEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static SuccOrFailEnums toEnum(String value) {
		for (SuccOrFailEnums temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOWN;
	}
	
	public static SuccOrFailEnums toEnum(boolean isSucc) {
		return isSucc? SUCCESS: FAIL;
	}
}
