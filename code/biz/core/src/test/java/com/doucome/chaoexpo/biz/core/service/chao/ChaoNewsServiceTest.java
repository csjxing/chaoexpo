package com.doucome.chaoexpo.biz.core.service.chao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.chaoexpo.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoNewsDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class ChaoNewsServiceTest extends AbstractBaseJUnit4Test {

	@Autowired
	private ChaoNewsService chaoNewsService ;
	
	@Test
	public void testInsert() {
		
		ChaoNewsDO news = new ChaoNewsDO() ;
		news.setTitle("习近平会见特立尼达和多巴哥总统卡莫纳") ;
		news.setSummary("新华网西班牙港6月1日电 中国国家主席习近平1日在西班牙港会见特立尼达和多巴哥总统卡莫纳，就将两国友好关系和互利合作推向更高水平深入交换意见。") ;
		news.setContent("新华网西班牙港6月1日电 中国国家主席习近平1日在西班牙港会见特立尼达和多巴哥总统卡莫纳，就将两国友好关系和互利合作推向更高水平深入交换意见。根据访问日程，习近平当天晚些时候将同特立尼达和多巴哥总理比塞萨尔举行会谈，会见议会领导人。双方将签署经贸、教育等领域合作文件。习近平还将同比塞萨尔总理共同出席库瓦儿童医院动工揭幕仪式。") ;
		news.setSource("网易新闻") ;
		news.setDisplayOrder(System.currentTimeMillis()) ;
		news.setCategoryId(1000L) ;
		news.setGmtPublish(new Date()) ;
		chaoNewsService.createNews(news) ;
		
	}
}
