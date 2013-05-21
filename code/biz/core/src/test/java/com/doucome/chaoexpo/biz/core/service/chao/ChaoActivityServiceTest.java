package com.doucome.chaoexpo.biz.core.service.chao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoActivityDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoActivityServiceTest extends AbstractBaseJUnit4Test {

	@Autowired
	private ChaoActivityService chaoActivityService ;
	
	@Test
	public void testInsert() {
		
			ChaoActivityDO activity = new ChaoActivityDO() ;
			activity.setStandPicUrls("") ;
			activity.setName("活动测试") ;
			activity.setContactName("海宁") ;
			activity.setContactPhone("10010") ;
			activity.setIntro("潮城海南") ;
			activity.setLocation("海宁市工人路121号") ;
			chaoActivityService.createActivity(activity) ;
		
	}
}
