package com.doucome.chaoexpo.web.bops.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoTushuoCategoryService;
import com.doucome.chaoexpo.biz.dal.condition.ChaoTushuoCateUpdateCondition;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoTushuoCategoryDO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 添加图说分类
 * @author langben 2013-7-5
 *
 */
public class AddTushuoCateAction extends BopsBasicAction implements ModelDriven<ChaoTushuoCategoryDO> {

	private ChaoTushuoCategoryDO cate = new ChaoTushuoCategoryDO() ;
	
	@Autowired
	private ChaoTushuoCategoryService chaoTushuoCategoryService ;
	
	@Override
	public String execute() throws Exception {	
		if(IDUtils.isCorrect(cate.getId())) {
			ChaoTushuoCateUpdateCondition update = ChaoTushuoCateUpdateCondition.fromCate(cate) ;
			int effectCount = chaoTushuoCategoryService.updateCategoryById(cate.getId(), update) ;
		} else {
			long newId = chaoTushuoCategoryService.createCategory(cate) ;
		}
		return SUCCESS ;
	}
	
	@Override
	public ChaoTushuoCategoryDO getModel() {
		return cate ;
	}

}
