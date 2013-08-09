package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author ZE2200
 *
 */
public enum ChaoActivityStatusEnum {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private ChaoActivityStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChaoActivityStatusEnum toEnum(String value) {
		for (ChaoActivityStatusEnum temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOW;
	}
}
