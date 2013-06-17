package com.doucome.chaoexpo.biz.core.enums;

public enum YesNoEnum {

	YES("Y") , 
	NO("N") ,
	UNKNOWN("") ;
	;
	
	private YesNoEnum(String value){
		this.value = value ;
	}
	
	private String value ;
	
	public String getValue(){
		return this.value ;
	}
	
	public static YesNoEnum toEnum(String value){
		for (YesNoEnum temp: values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return UNKNOWN ;
	}
}
