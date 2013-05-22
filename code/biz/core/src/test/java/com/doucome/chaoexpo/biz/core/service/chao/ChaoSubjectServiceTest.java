package com.doucome.chaoexpo.biz.core.service.chao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoSubjectDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoSubjectServiceTest extends AbstractBaseJUnit4Test {

	@Autowired
	private ChaoSubjectService chaoSubjectService ;
	
	@Test
	public void testInsert() {
		
			ChaoSubjectDO subject = new ChaoSubjectDO() ;
			subject.setName("专题001") ;
			subject.setWebUrl("http://baidu.com") ;
			chaoSubjectService.createSubject(subject) ;
		
	}
}
