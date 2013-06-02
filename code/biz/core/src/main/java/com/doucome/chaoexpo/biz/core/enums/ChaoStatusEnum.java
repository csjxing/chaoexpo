package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author ZE2200
 *
 */
public enum ChaoStatusEnum {

	ENABLE("E"),
	DISABLE("D");
	
	private String value;
	
	private ChaoStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChaoStatusEnum toEnum(String value) {
		for (ChaoStatusEnum temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return ENABLE;
	}
}
