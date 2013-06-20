package com.doucome.chaoexpo.biz.core.service.chao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoIntroDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoIntroServiceTest extends AbstractBaseJUnit4Test {
	
	@Autowired
	private ChaoIntroService chaoIntroService ;

	@Test
	public void testCreate() {
		
		ChaoIntroDO intro = new ChaoIntroDO() ;
		intro.setHnIntro("海宁介绍") ;
		intro.setHnMapPicUrls("http://img04.taobaocdn.com/tps/i4/T1jbdkFh0fXXcr_tT7-490-170.jpg") ;
		intro.setChaoExpoIntro("潮博会介绍") ;
		chaoIntroService.createIntro(intro) ;
	}
	
}
