package com.doucome.chaoexpo.biz.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum TrueOrFalseEnums {

	TRUE("T") , 
	FALSE("F") ,
	
	UNKNOWN("") ;
	;
	
	private TrueOrFalseEnums(String value){
		this.value = value ;
	}
	
	private String value ;
	
	public String getValue(){
		return this.value ;
	}
	
	private static final Map<String, TrueOrFalseEnums> map = new HashMap<String, TrueOrFalseEnums>();
	static {
		TrueOrFalseEnums[] enums = TrueOrFalseEnums.values();
        for (TrueOrFalseEnums e : enums) {
            map.put(e.getValue(), e);
        }
    }
	public static TrueOrFalseEnums toEnum(String value){
		TrueOrFalseEnums e = map.get(value);
		if(e != null){
			return e ;
		}
		return UNKNOWN ;
	}
}
