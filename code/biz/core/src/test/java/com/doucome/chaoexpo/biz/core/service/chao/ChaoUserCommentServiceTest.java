package com.doucome.chaoexpo.biz.core.service.chao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.chaoexpo.biz.core.enums.ChaoUserCommentTypeEnums;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoUserCommentDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoUserCommentServiceTest extends AbstractBaseJUnit4Test {

	@Autowired
	private ChaoUserCommentService chaoUserCommentService ;
	
	@Test
	public void testCreate() {
		
		ChaoUserCommentDO c = new ChaoUserCommentDO() ;
		c.setActivityId(10212L) ;
		c.setContent("满满的正能量") ;
		c.setStatus("N") ;
		c.setToCommentId(10002L) ;
		c.setToUserName("user_1") ;
		c.setType(ChaoUserCommentTypeEnums.ACTIVITY.getValue()) ;
		c.setUserName("user_2") ;
		
		chaoUserCommentService.createComment(c) ;
		
	}
	
}
