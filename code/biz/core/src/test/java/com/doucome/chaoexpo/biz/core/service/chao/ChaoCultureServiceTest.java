package com.doucome.chaoexpo.biz.core.service.chao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoCultureDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoCultureServiceTest extends AbstractBaseJUnit4Test  {

	@Autowired
	private ChaoCultureService chaoCultureService ;
	
	@Test
	public void testCreate() {
		for(int i= 0 ;i<50 ;i++) {
			ChaoCultureDO culture = new ChaoCultureDO() ;
			culture.setName("钱君匋博物馆" + i) ;
			culture.setIntro("钱君匋博物馆简介") ;
			
			chaoCultureService.createCulture(culture) ;
		}
	}
	
}
