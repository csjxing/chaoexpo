package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author ZE2200
 *
 */
public enum ChaoNewsStatusEnum {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private ChaoNewsStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChaoNewsStatusEnum toEnum(String value) {
		for (ChaoNewsStatusEnum temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOW;
	}
}
