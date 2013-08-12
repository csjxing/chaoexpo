package com.doucome.chaoexpo.biz.core.enums;

/**
 * 
 * @author ZE2200
 *
 */
public enum ChaoBannerStatusEnum {

	NORMAL("N"),
	DISABLE("D"),
	UNKNOW("");
	
	private String value;
	
	private ChaoBannerStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChaoBannerStatusEnum toEnum(String value) {
		for (ChaoBannerStatusEnum temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOW;
	}
}
