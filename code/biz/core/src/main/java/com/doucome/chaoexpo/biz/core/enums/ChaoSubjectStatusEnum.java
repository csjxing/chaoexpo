package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author ZE2200
 *
 */
public enum ChaoSubjectStatusEnum {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private ChaoSubjectStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChaoSubjectStatusEnum toEnum(String value) {
		for (ChaoSubjectStatusEnum temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOW;
	}
}
