package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.List;

/**
 * 推送
 * @author langben 2013-9-18
 *
 */
public interface ChaoUserPushService {

	int pushToIOS(List<String> deviceTokens , String alert , String p12File) ;
}
