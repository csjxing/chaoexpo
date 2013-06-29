package com.doucome.chaoexpo.biz.core.service.chao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoAppRecommendDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoAppRecommendServiceTest extends AbstractBaseJUnit4Test {

	@Autowired
	private ChaoAppRecommendService chaoAppRecommendService ;
	
	@Test
	public void testCreate() {
		ChaoAppRecommendDO recommend = new ChaoAppRecommendDO() ;
		//recommend.setAppStoreUrl("http://baidu.com") ;
		recommend.setAppName("找你妹") ;
		recommend.setIntro("找你妹找你妹妹") ;
		recommend.setLogoUrl("/upload/product/201305/05/154602700642787.jpg") ;
		chaoAppRecommendService.createRecommend(recommend) ;
	}
}
