package com.doucome.chaoexpo.biz.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.core.enums.DevicePushParamKeyEnums;
import com.doucome.chaoexpo.biz.core.enums.OsTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoDeviceDTO;

public class ChaoDeviceUtils {

	public static List<String> getDeviceTokens(List<ChaoDeviceDTO> dtoList) {
		List<String> tokenList = new ArrayList<String>() ;
		
		for(ChaoDeviceDTO device : dtoList) {
			if(OsTypeEnums.toEnum(device.getOsType()) != OsTypeEnums.IOS) {
				continue ;
			}
			Map<String,String> paramMap = device.getPushParamMap() ;
			if(paramMap == null) {
				continue ;
			}
			String token = paramMap.get(DevicePushParamKeyEnums.IOS_DEVICE_TOKEN.getValue()) ;
			if(StringUtils.isBlank(token)) {
				continue ;
			}
			tokenList.add(token) ;
		}
		
		return tokenList ;
	}
}
