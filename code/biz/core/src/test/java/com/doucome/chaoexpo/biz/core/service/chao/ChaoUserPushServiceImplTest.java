package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoUserPushServiceImplTest extends AbstractBaseJUnit4Test {

	@Autowired
	private ChaoUserPushService chaoUserPushService ;
	
	@Test
	public void test_pushToIOS() {
		String p12File = "d:/iPhoneChao.p12" ;
		String deviceToken = "3862eb877960b158f257cc0b00baa9b4e12dc1f4135eb8948aac2c224fa3ee69" ;
		int count = chaoUserPushService.pushToIOS(Arrays.asList(deviceToken), "潮博会测试消息，收到回复", p12File) ;
		System.out.println(count);
	}
}
