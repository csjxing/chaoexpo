package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

import org.apache.commons.lang.StringUtils;

public class PushTest    {

	public static void main(String[] args) {
		int badge = 1;// 图标小红圈的数值
		String sound = "default";// 铃音
		
		//device token
		List<String> tokens = Arrays.asList("3862eb877960b158f257cc0b00baa9b4e12dc1f4135eb8948aac2c224fa3ee69");
		//p12文件位置
		String certificatePath = "D:/workspace/java/chaoexpo/chaoexpo_master/code/bundle/war/src/main/webapp/WEB-INF/ChaoPushRelease.p12" ;
		//pass
		String certificatePassword = "123456" ;// 此处注意导出的证书密码不能为空因为空密码会报错
		
		String msg = "线上消息测试" ;

		try {
			PushNotificationPayload payLoad = new PushNotificationPayload();
			payLoad.addAlert(msg); // 消息内容
			payLoad.addBadge(badge); // iphone应用图标上小红圈上的数值
			if (!StringUtils.isBlank(sound)) {
				payLoad.addSound(sound);// 铃音
			}
			PushNotificationManager pushManager = new PushNotificationManager();
			// true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
			
			pushManager.initializeConnection(new AppleNotificationServerBasicImpl(certificatePath, certificatePassword, true));
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
			System.out.println("SUCCESSFUL COUNT :" + successful);
			pushManager.stopConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
}
