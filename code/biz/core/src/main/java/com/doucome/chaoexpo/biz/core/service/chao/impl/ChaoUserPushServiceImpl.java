package com.doucome.chaoexpo.biz.core.service.chao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.doucome.chaoexpo.biz.core.constant.EnvConstant;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserPushService;
import com.doucome.chaoexpo.biz.core.utils.EnvPropertiesUtil;

public class ChaoUserPushServiceImpl implements ChaoUserPushService {
	
	private static final Log log = LogFactory.getLog(ChaoUserPushServiceImpl.class) ;
	
	private String iosCertificatePassword ;

	@Override
	public int pushToIOS(List<String> deviceTokens, String alert , String p12File , Map<String,String> customParam ) {
		
		int badge = 1;// 图标小红圈的数值
		String sound = "default";// 铃音

		List<String> tokens = deviceTokens;
		String certificatePath = p12File ;
		String certificatePassword = iosCertificatePassword ;// 此处注意导出的证书密码不能为空因为空密码会报错
		//boolean sendCount = true;

		try {
			PushNotificationPayload payLoad = new PushNotificationPayload();
			payLoad.addAlert(alert); // 消息内容
			payLoad.addBadge(badge); // iphone应用图标上小红圈上的数值
			if (!StringUtils.isBlank(sound)) {
				payLoad.addSound(sound);// 铃音
			}
			if(MapUtils.isNotEmpty(customParam)) {
				for(Map.Entry<String, String> e : customParam.entrySet()) {
					payLoad.addCustomDictionary(e.getKey()	, e.getValue()) ;
				}
			}
			PushNotificationManager pushManager = new PushNotificationManager();
			// true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
			Boolean production = Boolean.valueOf(EnvPropertiesUtil.getProperty(EnvConstant.CHAOEXPO_PRODUCTION)) ;
			pushManager.initializeConnection(new AppleNotificationServerBasicImpl(certificatePath, certificatePassword, production));
			List<PushedNotification> notifications = new ArrayList<PushedNotification>();
			
			// 发送push消息
			List<Device> device = new ArrayList<Device>();
			for (String token : tokens) {
				device.add(new BasicDevice(token));
			}
			notifications = pushManager.sendNotifications(payLoad, device);
			
			List<PushedNotification> failedNotifications = PushedNotification
					.findFailedNotifications(notifications);
			List<PushedNotification> successfulNotifications = PushedNotification
					.findSuccessfulNotifications(notifications);
			int failed = failedNotifications.size();
			int successful = successfulNotifications.size();
			pushManager.stopConnection();
			
			return successful ;
		} catch (Exception e) {
			log.error(e.getMessage() , e) ;
		}
		return 0 ;
	}

	public String getIosCertificatePassword() {
		return iosCertificatePassword;
	}

	public void setIosCertificatePassword(String iosCertificatePassword) {
		this.iosCertificatePassword = iosCertificatePassword;
	}

}
